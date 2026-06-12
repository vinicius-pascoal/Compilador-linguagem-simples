import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtimizadorCodigoIntermediario {

  public CodigoIntermediario otimizar(CodigoIntermediario original) {
    CodigoIntermediario otimizado = new CodigoIntermediario();
    otimizado.setNomePrograma(original.getNomePrograma());

    for (Map.Entry<String, Tipo> entrada : original.getVariaveis().entrySet()) {
      otimizado.declararVariavel(entrada.getKey(), entrada.getValue());
    }

    for (Map.Entry<String, Tipo> entrada : original.getTemporarios().entrySet()) {
      otimizado.declararTemporario(entrada.getKey(), entrada.getValue());
    }

    List<String> primeiraPassagem = aplicarOtimizacoesLocais(original.getInstrucoes());
    List<String> segundaPassagem = removerBlocosInalcancaveis(primeiraPassagem);
    List<String> terceiraPassagem = removerSaltosParaProximoRotulo(segundaPassagem);

    for (String instrucao : terceiraPassagem) {
      otimizado.adicionarInstrucao(instrucao);
    }

    return otimizado;
  }

  private List<String> aplicarOtimizacoesLocais(List<String> instrucoes) {
    List<String> resultado = new ArrayList<>();
    Map<String, String> constantes = new HashMap<>();

    for (String instrucao : instrucoes) {
      String linha = instrucao.trim();

      if (linha.isEmpty()) {
        continue;
      }

      if (linha.endsWith(":")) {
        constantes.clear();
        resultado.add(linha);
        continue;
      }

      if (linha.startsWith("READ ")) {
        String variavel = linha.substring(5).trim();
        constantes.remove(variavel);
        resultado.add(linha);
        continue;
      }

      if (linha.startsWith("WRITE_INTEGER ")) {
        String valor = linha.substring("WRITE_INTEGER ".length()).trim();
        resultado.add("WRITE_INTEGER " + substituirSeConstante(valor, constantes));
        continue;
      }

      if (linha.startsWith("WRITE_BOOLEAN ")) {
        String valor = linha.substring("WRITE_BOOLEAN ".length()).trim();
        resultado.add("WRITE_BOOLEAN " + substituirSeConstante(valor, constantes));
        continue;
      }

      if (linha.startsWith("WRITE_STRING ")) {
        resultado.add(linha);
        continue;
      }

      if (linha.startsWith("WRITE ")) {
        String valor = linha.substring(6).trim();
        resultado.add("WRITE " + substituirSeConstante(valor, constantes));
        continue;
      }

      if (linha.startsWith("IF_FALSE ")) {
        String[] partes = linha.split("\\s+");
        if (partes.length == 4 && "GOTO".equals(partes[2])) {
          String condicao = substituirSeConstante(partes[1], constantes);
          String rotulo = partes[3];

          if ("0".equals(condicao)) {
            resultado.add("GOTO " + rotulo);
          } else if (!"1".equals(condicao)) {
            resultado.add("IF_FALSE " + condicao + " GOTO " + rotulo);
          }
        } else {
          resultado.add(linha);
        }

        constantes.clear();
        continue;
      }

      if (linha.startsWith("GOTO ")) {
        resultado.add(linha);
        constantes.clear();
        continue;
      }

      if (!linha.contains(" = ")) {
        resultado.add(linha);
        continue;
      }

      String[] atribuicao = linha.split(" = ", 2);
      String destino = atribuicao[0].trim();
      String expressao = atribuicao[1].trim();

      String otimizada = otimizarAtribuicao(destino, expressao, constantes);
      atualizarConstantes(destino, otimizada, constantes);
      resultado.add(otimizada);
    }

    return resultado;
  }

  private String otimizarAtribuicao(String destino, String expressao, Map<String, String> constantes) {
    String[] partes = expressao.split("\\s+");

    if (ehInteiro(expressao)) {
      return destino + " = " + expressao;
    }

    if (expressao.startsWith("~")) {
      String operando = substituirSeConstante(expressao.substring(1), constantes);
      if ("0".equals(operando)) return destino + " = 1";
      if ("1".equals(operando)) return destino + " = 0";
      return destino + " = ~" + operando;
    }

    if (expressao.startsWith("-") && expressao.length() > 1) {
      String operando = substituirSeConstante(expressao.substring(1), constantes);
      if (ehInteiro(operando)) return destino + " = " + (-Integer.parseInt(operando));
      return destino + " = -" + operando;
    }

    if (partes.length == 1) {
      String valor = substituirSeConstante(partes[0], constantes);
      return destino + " = " + valor;
    }

    if (partes.length == 3) {
      String esquerda = substituirSeConstante(partes[0], constantes);
      String operador = partes[1];
      String direita = substituirSeConstante(partes[2], constantes);

      String dobrado = dobrarConstantes(esquerda, operador, direita);
      if (dobrado != null) {
        return destino + " = " + dobrado;
      }

      return destino + " = " + esquerda + " " + operador + " " + direita;
    }

    return destino + " = " + expressao;
  }

  private void atualizarConstantes(String destino, String linhaOtimizada, Map<String, String> constantes) {
    String[] atribuicao = linhaOtimizada.split(" = ", 2);
    if (atribuicao.length != 2) {
      constantes.remove(destino);
      return;
    }

    String expressao = atribuicao[1].trim();
    if (ehInteiro(expressao)) {
      constantes.put(destino, expressao);
    } else {
      constantes.remove(destino);
    }
  }

  private String substituirSeConstante(String operando, Map<String, String> constantes) {
    return constantes.getOrDefault(operando, operando);
  }

  private String dobrarConstantes(String esquerda, String operador, String direita) {
    if (!ehInteiro(esquerda) || !ehInteiro(direita)) {
      return null;
    }

    int a = Integer.parseInt(esquerda);
    int b = Integer.parseInt(direita);

    switch (operador) {
      case "+": return String.valueOf(a + b);
      case "-": return String.valueOf(a - b);
      case "*": return String.valueOf(a * b);
      case "/": return b == 0 ? null : String.valueOf(a / b);
      case "<": return a < b ? "1" : "0";
      case ">": return a > b ? "1" : "0";
      case "<=": return a <= b ? "1" : "0";
      case ">=": return a >= b ? "1" : "0";
      case "==": return a == b ? "1" : "0";
      case "<>": return a != b ? "1" : "0";
      case "AND": return (a != 0 && b != 0) ? "1" : "0";
      case "OR": return (a != 0 || b != 0) ? "1" : "0";
      default: return null;
    }
  }

  private boolean ehInteiro(String valor) {
    return valor != null && valor.matches("-?\\d+");
  }


  private List<String> removerBlocosInalcancaveis(List<String> instrucoes) {
    java.util.Set<String> rotulosReferenciados = new java.util.HashSet<>();

    for (String instrucao : instrucoes) {
      String linha = instrucao.trim();
      if (linha.startsWith("GOTO ")) {
        rotulosReferenciados.add(linha.substring(5).trim());
      } else if (linha.startsWith("IF_FALSE ")) {
        String[] partes = linha.split("\\s+");
        if (partes.length == 4) {
          rotulosReferenciados.add(partes[3]);
        }
      }
    }

    List<String> resultado = new ArrayList<>();
    boolean pulando = false;

    for (String instrucao : instrucoes) {
      String linha = instrucao.trim();

      if (linha.endsWith(":")) {
        String rotulo = linha.substring(0, linha.length() - 1);
        boolean ultimoFoiGoto = !resultado.isEmpty() && resultado.get(resultado.size() - 1).startsWith("GOTO ");

        if (!rotulosReferenciados.contains(rotulo) && ultimoFoiGoto) {
          pulando = true;
          continue;
        }

        if (rotulosReferenciados.contains(rotulo)) {
          pulando = false;
        }
      }

      if (!pulando) {
        resultado.add(linha);
      }
    }

    return resultado;
  }

  private List<String> removerSaltosParaProximoRotulo(List<String> instrucoes) {
    List<String> resultado = new ArrayList<>();

    for (int i = 0; i < instrucoes.size(); i++) {
      String atual = instrucoes.get(i);

      if (atual.startsWith("GOTO ") && i + 1 < instrucoes.size()) {
        String rotulo = atual.substring(5).trim();
        String proxima = instrucoes.get(i + 1).trim();

        if (proxima.equals(rotulo + ":")) {
          continue;
        }
      }

      resultado.add(atual);
    }

    return resultado;
  }
}
