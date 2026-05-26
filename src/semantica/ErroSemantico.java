public class ErroSemantico extends RuntimeException {

  public ErroSemantico(String mensagem) {
    super("Erro semantico: " + mensagem);
  }

  public ErroSemantico(int linha, int coluna, String mensagem) {
    super("Erro semantico na linha " + linha + ", coluna " + coluna + ": " + mensagem);
  }
}
