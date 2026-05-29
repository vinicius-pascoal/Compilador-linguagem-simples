import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

  public static void main(String[] args) {
    String arquivoEntrada = args.length > 0 ? args[0] : "exemplos/input.txt";

    try {
      CharStream input = CharStreams.fromFileName(arquivoEntrada);

      ProjetoILexer lexer = new ProjetoILexer(input);
      lexer.removeErrorListeners();
      lexer.addErrorListener(new ErroLexicoListener());

      CommonTokenStream tokens = new CommonTokenStream(lexer);
      tokens.fill();
      validarTokensLexicos(tokens);
      tokens.seek(0);

      ProjetoIParser parser = new ProjetoIParser(tokens);
      parser.removeErrorListeners();
      parser.addErrorListener(new ErroSintaticoListener());

      ParseTree tree = parser.prog();

      if (parser.getNumberOfSyntaxErrors() > 0) {
        throw new FalhaCompilacao("Compilacao interrompida: erros sintaticos encontrados.");
      }

      AnalisadorSemantico semantico = new AnalisadorSemantico();
      semantico.visit(tree);

      System.out.println("Compilacao realizada com sucesso.");
      System.out.println("Analise lexica: OK");
      System.out.println("Analise sintatica: OK");
      System.out.println("Analise semantica: OK");

      GeradorCodigo gerador = new GeradorCodigo();
      String codigo = gerador.gerar((ProjetoIParser.ProgContext) tree);
      String className = gerador.getClassName();
      java.nio.file.Path outPath = java.nio.file.Paths.get("generated", className + ".java");
      java.nio.file.Files.createDirectories(outPath.getParent());
      java.nio.file.Files.writeString(outPath, codigo);
      System.out.println("Codigo Java gerado em: " + outPath.toString());

    } catch (ErroSemantico e) {
      System.err.println(e.getMessage());
      System.exit(1);

    } catch (FalhaCompilacao e) {
      System.err.println(e.getMessage());
      System.exit(1);

    } catch (Exception e) {
      System.err.println("Erro ao executar compilador: " + e.getMessage());
      System.exit(1);
    }
  }

  private static void validarTokensLexicos(CommonTokenStream tokens) {
    for (Token token : tokens.getTokens()) {
      if (token.getType() == ProjetoILexer.ERRO_CTE_2_BYTES) {
        throw new FalhaCompilacao(
            "Erro lexico na linha " + token.getLine() +
                ", coluna " + (token.getCharPositionInLine() + 1) +
                ": constante inteira ultrapassa 2 bytes: " + token.getText());
      }

      if (token.getType() == ProjetoILexer.ERRO) {
        throw new FalhaCompilacao(
            "Erro lexico na linha " + token.getLine() +
                ", coluna " + (token.getCharPositionInLine() + 1) +
                ": caractere invalido: " + token.getText());
      }
    }
  }

  private static class ErroLexicoListener extends BaseErrorListener {
    @Override
    public void syntaxError(
        Recognizer<?, ?> recognizer,
        Object offendingSymbol,
        int line,
        int charPositionInLine,
        String msg,
        RecognitionException e) {

      throw new FalhaCompilacao(
          "Erro lexico na linha " + line +
              ", coluna " + (charPositionInLine + 1) +
              ": " + msg);
    }
  }

  private static class ErroSintaticoListener extends BaseErrorListener {
    @Override
    public void syntaxError(
        Recognizer<?, ?> recognizer,
        Object offendingSymbol,
        int line,
        int charPositionInLine,
        String msg,
        RecognitionException e) {

      throw new FalhaCompilacao(
          "Erro sintatico na linha " + line +
              ", coluna " + (charPositionInLine + 1) +
              ": " + msg);
    }
  }

  private static class FalhaCompilacao extends RuntimeException {
    public FalhaCompilacao(String mensagem) {
      super(mensagem);
    }
  }
}
