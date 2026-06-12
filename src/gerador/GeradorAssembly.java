import java.util.LinkedHashMap;
import java.util.Map;

public class GeradorAssembly {
  private final Map<String, String> literaisString = new LinkedHashMap<>();
  private int contadorString = 0;
  private int contadorRotulosInternos = 0;
  private CodigoIntermediario codigo;

  public String gerar(CodigoIntermediario codigo) {
    this.codigo = codigo;
    this.literaisString.clear();
    this.contadorString = 0;
    this.contadorRotulosInternos = 0;

    coletarLiteraisString();

    StringBuilder asm = new StringBuilder();
    asm.append("; Codigo Assembly x86 gerado a partir do 3AC otimizado\n");
    asm.append("; Programa: ").append(codigo.getNomePrograma()).append("\n\n");

    gerarData(asm);
    gerarText(asm);

    return asm.toString();
  }

  private void coletarLiteraisString() {
    for (String instrucao : codigo.getInstrucoes()) {
      String linha = instrucao.trim();
      if (linha.startsWith("WRITE ")) {
        String valor = linha.substring(6).trim();
        if (ehLiteralString(valor) && !literaisString.containsKey(valor)) {
          literaisString.put(valor, "str_" + contadorString++);
        }
      }
    }
  }

  private void gerarData(StringBuilder asm) {
    asm.append("section .data\n");

    for (Map.Entry<String, Tipo> entrada : codigo.getVariaveis().entrySet()) {
      String nome = entrada.getKey();
      Tipo tipo = entrada.getValue();

      if (tipo == Tipo.INTEGER) {
        asm.append("  ").append(nome).append(" dw 0\n");
      } else if (tipo == Tipo.BOOLEAN) {
        asm.append("  ").append(nome).append(" db 0\n");
      } else if (tipo == Tipo.STRING) {
        asm.append("  ").append(nome).append(" db 256 dup(0)\n");
      }
    }

    for (String temp : codigo.getTemporarios().keySet()) {
      asm.append("  ").append(temp).append(" dw 0\n");
    }

    for (Map.Entry<String, String> entrada : literaisString.entrySet()) {
      String literal = removerAspas(entrada.getKey());
      asm.append("  ").append(entrada.getValue()).append(" db \"")
          .append(escaparStringAssembly(literal)).append("\", 0\n");
    }

    asm.append("\n");
  }

  private void gerarText(StringBuilder asm) {
    asm.append("section .text\n");
    asm.append("global _start\n\n");
    asm.append("_start:\n");

    for (String instrucao : codigo.getInstrucoes()) {
      gerarInstrucao(asm, instrucao.trim());
    }

    asm.append("\n  ; Encerramento do programa\n");
    asm.append("  mov ax, 4C00h\n");
    asm.append("  int 21h\n\n");

    asm.append("; Rotinas externas ou de biblioteca esperadas:\n");
    asm.append("; _read_integer, _read_boolean, _read_string\n");
    asm.append("; _print_integer, _print_boolean, _print_string\n");
  }

  private void gerarInstrucao(StringBuilder asm, String linha) {
    if (linha.isEmpty()) return;

    if (linha.endsWith(":")) {
      asm.append(linha).append("\n");
      return;
    }

    if (linha.startsWith("GOTO ")) {
      asm.append("  jmp ").append(linha.substring(5).trim()).append("\n");
      return;
    }

    if (linha.startsWith("IF_FALSE ")) {
      gerarIfFalse(asm, linha);
      return;
    }

    if (linha.startsWith("READ ")) {
      gerarRead(asm, linha.substring(5).trim());
      return;
    }

    if (linha.startsWith("WRITE ")) {
      gerarWrite(asm, linha.substring(6).trim());
      return;
    }

    if (linha.contains(" = ")) {
      gerarAtribuicao(asm, linha);
      return;
    }

    asm.append("  ; Instrucao nao mapeada: ").append(linha).append("\n");
  }

  private void gerarIfFalse(StringBuilder asm, String linha) {
    String[] partes = linha.split("\\s+");
    if (partes.length != 4) {
      asm.append("  ; IF_FALSE invalido: ").append(linha).append("\n");
      return;
    }

    String condicao = partes[1];
    String rotulo = partes[3];

    carregarAx(asm, condicao);
    asm.append("  cmp ax, 0\n");
    asm.append("  je ").append(rotulo).append("\n");
  }

  private void gerarRead(StringBuilder asm, String variavel) {
    Tipo tipo = codigo.getTipo(variavel);

    if (tipo == Tipo.BOOLEAN) {
      asm.append("  call _read_boolean\n");
    } else if (tipo == Tipo.STRING) {
      asm.append("  lea dx, [").append(variavel).append("]\n");
      asm.append("  call _read_string\n");
      return;
    } else {
      asm.append("  call _read_integer\n");
    }

    armazenarAx(asm, variavel);
  }

  private void gerarWrite(StringBuilder asm, String valor) {
    if (ehLiteralString(valor)) {
      String rotulo = literaisString.get(valor);
      asm.append("  push offset ").append(rotulo).append("\n");
      asm.append("  call _print_string\n");
      return;
    }

    Tipo tipo = codigo.getTipo(valor);

    if (tipo == Tipo.BOOLEAN) {
      carregarAx(asm, valor);
      asm.append("  push ax\n");
      asm.append("  call _print_boolean\n");
    } else if (tipo == Tipo.STRING) {
      asm.append("  push offset ").append(valor).append("\n");
      asm.append("  call _print_string\n");
    } else {
      carregarAx(asm, valor);
      asm.append("  push ax\n");
      asm.append("  call _print_integer\n");
    }
  }

  private void gerarAtribuicao(StringBuilder asm, String linha) {
    String[] partesAtribuicao = linha.split(" = ", 2);
    String destino = partesAtribuicao[0].trim();
    String expressao = partesAtribuicao[1].trim();
    String[] partes = expressao.split("\\s+");

    if (expressao.startsWith("~")) {
      gerarNegacaoLogica(asm, destino, expressao.substring(1));
      return;
    }

    if (expressao.startsWith("-") && expressao.length() > 1 && !ehInteiro(expressao)) {
      carregarAx(asm, expressao.substring(1));
      asm.append("  neg ax\n");
      armazenarAx(asm, destino);
      return;
    }

    if (partes.length == 1) {
      gerarAtribuicaoSimples(asm, destino, partes[0]);
      return;
    }

    if (partes.length == 3) {
      gerarOperacaoBinaria(asm, destino, partes[0], partes[1], partes[2]);
      return;
    }

    asm.append("  ; Atribuicao nao mapeada: ").append(linha).append("\n");
  }

  private void gerarAtribuicaoSimples(StringBuilder asm, String destino, String origem) {
    carregarAx(asm, origem);
    armazenarAx(asm, destino);
  }

  private void gerarOperacaoBinaria(StringBuilder asm, String destino, String esquerda, String operador, String direita) {
    switch (operador) {
      case "+":
        carregarAx(asm, esquerda);
        carregarBx(asm, direita);
        asm.append("  add ax, bx\n");
        armazenarAx(asm, destino);
        break;
      case "-":
        carregarAx(asm, esquerda);
        carregarBx(asm, direita);
        asm.append("  sub ax, bx\n");
        armazenarAx(asm, destino);
        break;
      case "*":
        carregarAx(asm, esquerda);
        carregarBx(asm, direita);
        asm.append("  imul bx\n");
        armazenarAx(asm, destino);
        break;
      case "/":
        carregarAx(asm, esquerda);
        carregarBx(asm, direita);
        asm.append("  cwd\n");
        asm.append("  idiv bx\n");
        armazenarAx(asm, destino);
        break;
      case "AND":
        carregarAx(asm, esquerda);
        carregarBx(asm, direita);
        asm.append("  and ax, bx\n");
        armazenarAx(asm, destino);
        break;
      case "OR":
        carregarAx(asm, esquerda);
        carregarBx(asm, direita);
        asm.append("  or ax, bx\n");
        armazenarAx(asm, destino);
        break;
      case "<":
      case ">":
      case "<=":
      case ">=":
      case "==":
      case "<>":
        gerarComparacao(asm, destino, esquerda, operador, direita);
        break;
      default:
        asm.append("  ; Operador nao mapeado: ").append(operador).append("\n");
    }
  }

  private void gerarComparacao(StringBuilder asm, String destino, String esquerda, String operador, String direita) {
    String rotuloVerdadeiro = novoRotuloInterno("ASM_TRUE");
    String rotuloFim = novoRotuloInterno("ASM_END_CMP");

    carregarAx(asm, esquerda);
    carregarBx(asm, direita);
    asm.append("  cmp ax, bx\n");
    armazenarImediato(asm, destino, "0");
    asm.append("  ").append(saltoComparacao(operador)).append(" ").append(rotuloVerdadeiro).append("\n");
    asm.append("  jmp ").append(rotuloFim).append("\n");
    asm.append(rotuloVerdadeiro).append(":\n");
    armazenarImediato(asm, destino, "1");
    asm.append(rotuloFim).append(":\n");
  }

  private void gerarNegacaoLogica(StringBuilder asm, String destino, String operando) {
    String rotuloVerdadeiro = novoRotuloInterno("ASM_NEG_TRUE");
    String rotuloFim = novoRotuloInterno("ASM_NEG_END");

    carregarAx(asm, operando);
    asm.append("  cmp ax, 0\n");
    armazenarImediato(asm, destino, "0");
    asm.append("  je ").append(rotuloVerdadeiro).append("\n");
    asm.append("  jmp ").append(rotuloFim).append("\n");
    asm.append(rotuloVerdadeiro).append(":\n");
    armazenarImediato(asm, destino, "1");
    asm.append(rotuloFim).append(":\n");
  }

  private String saltoComparacao(String operador) {
    switch (operador) {
      case "<": return "jl";
      case ">": return "jg";
      case "<=": return "jle";
      case ">=": return "jge";
      case "==": return "je";
      case "<>": return "jne";
      default: return "je";
    }
  }

  private String novoRotuloInterno(String prefixo) {
    return prefixo + "_" + contadorRotulosInternos++;
  }

  private void carregarAx(StringBuilder asm, String operando) {
    if (ehInteiro(operando)) {
      asm.append("  mov ax, ").append(operando).append("\n");
      return;
    }

    Tipo tipo = codigo.getTipo(operando);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(operando)) {
      asm.append("  xor ax, ax\n");
      asm.append("  mov al, byte ptr [").append(operando).append("]\n");
    } else {
      asm.append("  mov ax, word ptr [").append(operando).append("]\n");
    }
  }

  private void carregarBx(StringBuilder asm, String operando) {
    if (ehInteiro(operando)) {
      asm.append("  mov bx, ").append(operando).append("\n");
      return;
    }

    Tipo tipo = codigo.getTipo(operando);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(operando)) {
      asm.append("  xor bx, bx\n");
      asm.append("  mov bl, byte ptr [").append(operando).append("]\n");
    } else {
      asm.append("  mov bx, word ptr [").append(operando).append("]\n");
    }
  }

  private void armazenarAx(StringBuilder asm, String destino) {
    Tipo tipo = codigo.getTipo(destino);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(destino)) {
      asm.append("  mov byte ptr [").append(destino).append("], al\n");
    } else {
      asm.append("  mov word ptr [").append(destino).append("], ax\n");
    }
  }

  private void armazenarImediato(StringBuilder asm, String destino, String valor) {
    Tipo tipo = codigo.getTipo(destino);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(destino)) {
      asm.append("  mov byte ptr [").append(destino).append("], ").append(valor).append("\n");
    } else {
      asm.append("  mov word ptr [").append(destino).append("], ").append(valor).append("\n");
    }
  }

  private boolean ehInteiro(String valor) {
    return valor != null && valor.matches("-?\\d+");
  }

  private boolean ehLiteralString(String valor) {
    return valor != null && valor.length() >= 2 && valor.startsWith("\"") && valor.endsWith("\"");
  }

  private String removerAspas(String literal) {
    if (ehLiteralString(literal)) {
      return literal.substring(1, literal.length() - 1);
    }
    return literal;
  }

  private String escaparStringAssembly(String valor) {
    return valor.replace("\\", "\\\\").replace("\"", "\\\"");
  }
}
