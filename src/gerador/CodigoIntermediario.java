import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CodigoIntermediario {
  private final List<String> instrucoes = new ArrayList<>();
  private final Map<String, Tipo> variaveis = new LinkedHashMap<>();
  private final Map<String, Tipo> temporarios = new LinkedHashMap<>();
  private String nomePrograma = "programa";

  public void setNomePrograma(String nomePrograma) {
    if (nomePrograma != null && !nomePrograma.isBlank()) {
      this.nomePrograma = nomePrograma;
    }
  }

  public String getNomePrograma() {
    return nomePrograma;
  }

  public void adicionarInstrucao(String instrucao) {
    instrucoes.add(instrucao);
  }

  public List<String> getInstrucoes() {
    return Collections.unmodifiableList(instrucoes);
  }

  public void declararVariavel(String nome, Tipo tipo) {
    variaveis.put(nome, tipo);
  }

  public Map<String, Tipo> getVariaveis() {
    return Collections.unmodifiableMap(variaveis);
  }

  public void declararTemporario(String nome, Tipo tipo) {
    temporarios.put(nome, tipo);
  }

  public Map<String, Tipo> getTemporarios() {
    return Collections.unmodifiableMap(temporarios);
  }

  public Tipo getTipo(String nome) {
    if (variaveis.containsKey(nome)) {
      return variaveis.get(nome);
    }

    if (temporarios.containsKey(nome)) {
      return temporarios.get(nome);
    }

    return Tipo.INVALIDO;
  }

  public String comoTexto() {
    StringBuilder sb = new StringBuilder();

    sb.append("# Codigo intermediario 3AC\n");
    sb.append("# Programa: ").append(nomePrograma).append("\n\n");

    for (String instrucao : instrucoes) {
      sb.append(instrucao).append(System.lineSeparator());
    }

    return sb.toString();
  }
}
