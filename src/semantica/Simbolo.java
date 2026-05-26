public class Simbolo {

  private final String nome;
  private final Tipo tipo;

  public Simbolo(String nome, Tipo tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }

  public String getNome() {
    return nome;
  }

  public Tipo getTipo() {
    return tipo;
  }
}
