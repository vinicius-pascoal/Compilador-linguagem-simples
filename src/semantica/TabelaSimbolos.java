import java.util.LinkedHashMap;
import java.util.Map;

public class TabelaSimbolos {

  private final Map<String, Simbolo> simbolos = new LinkedHashMap<>();

  public void declarar(String nome, Tipo tipo) {
    String chave = nome.toLowerCase();

    if (simbolos.containsKey(chave)) {
      throw new ErroSemantico("Variavel ja declarada: " + nome);
    }

    simbolos.put(chave, new Simbolo(nome, tipo));
  }

  public Simbolo buscar(String nome) {
    String chave = nome.toLowerCase();

    Simbolo simbolo = simbolos.get(chave);

    if (simbolo == null) {
      throw new ErroSemantico("Variavel nao declarada: " + nome);
    }

    return simbolo;
  }

  public boolean existe(String nome) {
    return simbolos.containsKey(nome.toLowerCase());
  }
}
