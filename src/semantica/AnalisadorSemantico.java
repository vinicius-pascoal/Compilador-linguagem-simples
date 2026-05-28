import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AnalisadorSemantico extends ProjetoIParserBaseVisitor<Tipo> {

  private final TabelaSimbolos tabela = new TabelaSimbolos();

  public TabelaSimbolos getTabela() {
    return tabela;
  }

  private ErroSemantico erro(Token token, String mensagem) {
    return new ErroSemantico(
        token.getLine(),
        token.getCharPositionInLine() + 1,
        mensagem);
  }

  private Tipo obterTipo(ProjetoIParser.TipContext ctx) {
    if (ctx.INTEGER() != null) {
      return Tipo.INTEGER;
    }

    if (ctx.BOOLEAN() != null) {
      return Tipo.BOOLEAN;
    }

    if (ctx.STRING() != null) {
      return Tipo.STRING;
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitProg(ProjetoIParser.ProgContext ctx) {
    visit(ctx.decls());
    visit(ctx.cmdComp());
    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitDeclTip(ProjetoIParser.DeclTipContext ctx) {
    Tipo tipo = obterTipo(ctx.tip());

    for (TerminalNode id : ctx.listId().ID()) {
      String nome = id.getText();

      try {
        tabela.declarar(nome, tipo);
      } catch (ErroSemantico e) {
        throw erro(id.getSymbol(), "variavel ja declarada: " + nome);
      }
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitCmdRead(ProjetoIParser.CmdReadContext ctx) {
    for (TerminalNode id : ctx.listId().ID()) {
      String nome = id.getText();
      tabela.buscar(nome);
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitCmdWrite(ProjetoIParser.CmdWriteContext ctx) {
    visit(ctx.listW());
    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitElemW(ProjetoIParser.ElemWContext ctx) {
    if (ctx.CADEIA() != null) {
      return Tipo.STRING;
    }

    return visit(ctx.expr());
  }

  @Override
  public Tipo visitCmdAtrib(ProjetoIParser.CmdAtribContext ctx) {
    String nomeVariavel = ctx.ID().getText();

    Simbolo simbolo = tabela.buscar(nomeVariavel);
    Tipo tipoVariavel = simbolo.getTipo();

    Tipo tipoExpressao = visit(ctx.expr());

    if (tipoVariavel != tipoExpressao) {
      throw erro(
          ctx.ID().getSymbol(),
          "atribuicao invalida. Variavel '" + nomeVariavel +
              "' e do tipo " + tipoVariavel +
              ", mas recebeu expressao do tipo " + tipoExpressao);
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitCmdIf(ProjetoIParser.CmdIfContext ctx) {
    Tipo tipoCondicao = visit(ctx.expr());

    if (tipoCondicao != Tipo.BOOLEAN) {
      throw erro(
          ctx.IF().getSymbol(),
          "condicao do IF deve ser BOOLEAN");
    }

    for (ProjetoIParser.CmdBaseContext bloco : ctx.cmdBase()) {
      visit(bloco);
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitCmdWhile(ProjetoIParser.CmdWhileContext ctx) {
    Tipo tipoCondicao = visit(ctx.expr());

    if (tipoCondicao != Tipo.BOOLEAN) {
      throw erro(
          ctx.WHILE().getSymbol(),
          "condicao do WHILE deve ser BOOLEAN");
    }

    visit(ctx.cmdBase());
    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitCmdFor(ProjetoIParser.CmdForContext ctx) {
    String nomeVariavel = ctx.ID().getText();
    Simbolo simbolo = tabela.buscar(nomeVariavel);

    if (simbolo.getTipo() != Tipo.INTEGER) {
      throw erro(
          ctx.ID().getSymbol(),
          "variavel de controle do FOR deve ser INTEGER");
    }

    Tipo tipoInicio = visit(ctx.expr(0));
    Tipo tipoFim = visit(ctx.expr(1));

    if (tipoInicio != Tipo.INTEGER || tipoFim != Tipo.INTEGER) {
      throw erro(
          ctx.FOR().getSymbol(),
          "expressoes do FOR devem ser INTEGER");
    }

    visit(ctx.cmdBase());
    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitExpr(ProjetoIParser.ExprContext ctx) {
    return visit(ctx.exprOr());
  }

  @Override
  public Tipo visitExprOr(ProjetoIParser.ExprOrContext ctx) {
    Tipo tipo = visit(ctx.exprAnd(0));

    for (int i = 1; i < ctx.exprAnd().size(); i++) {
      Tipo outroTipo = visit(ctx.exprAnd(i));

      if (tipo != Tipo.BOOLEAN || outroTipo != Tipo.BOOLEAN) {
        throw erro(
            ctx.getStart(),
            "operador OR exige operandos BOOLEAN");
      }

      tipo = Tipo.BOOLEAN;
    }

    return tipo;
  }

  @Override
  public Tipo visitExprAnd(ProjetoIParser.ExprAndContext ctx) {
    Tipo tipo = visit(ctx.exprRel(0));

    for (int i = 1; i < ctx.exprRel().size(); i++) {
      Tipo outroTipo = visit(ctx.exprRel(i));

      if (tipo != Tipo.BOOLEAN || outroTipo != Tipo.BOOLEAN) {
        throw erro(
            ctx.getStart(),
            "operador AND exige operandos BOOLEAN");
      }

      tipo = Tipo.BOOLEAN;
    }

    return tipo;
  }

  @Override
  public Tipo visitExprRel(ProjetoIParser.ExprRelContext ctx) {
    Tipo tipoEsquerda = visit(ctx.exprAdd(0));

    if (ctx.exprAdd().size() == 1) {
      return tipoEsquerda;
    }

    Tipo tipoDireita = visit(ctx.exprAdd(1));

    if (ctx.OPREL() != null || ctx.OPMOE() != null) {
      if (tipoEsquerda != Tipo.INTEGER || tipoDireita != Tipo.INTEGER) {
        throw erro(
            ctx.getStart(),
            "operadores relacionais <, >, <= e >= exigem operandos INTEGER");
      }

      return Tipo.BOOLEAN;
    }

    if (ctx.OPDIF() != null || ctx.OPEQ() != null) {
      if (tipoEsquerda != tipoDireita) {
        throw erro(
            ctx.getStart(),
            "operadores == e <> exigem operandos do mesmo tipo");
      }

      return Tipo.BOOLEAN;
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitExprAdd(ProjetoIParser.ExprAddContext ctx) {
    Tipo tipo = visit(ctx.exprSub(0));

    for (int i = 1; i < ctx.exprSub().size(); i++) {
      Tipo outroTipo = visit(ctx.exprSub(i));

      if (tipo != Tipo.INTEGER || outroTipo != Tipo.INTEGER) {
        throw erro(
            ctx.getStart(),
            "operador + exige operandos INTEGER");
      }

      tipo = Tipo.INTEGER;
    }

    return tipo;
  }

  @Override
  public Tipo visitExprSub(ProjetoIParser.ExprSubContext ctx) {
    Tipo tipo = visit(ctx.exprMul(0));

    for (int i = 1; i < ctx.exprMul().size(); i++) {
      Tipo outroTipo = visit(ctx.exprMul(i));

      if (tipo != Tipo.INTEGER || outroTipo != Tipo.INTEGER) {
        throw erro(
            ctx.getStart(),
            "operador - exige operandos INTEGER");
      }

      tipo = Tipo.INTEGER;
    }

    return tipo;
  }

  @Override
  public Tipo visitExprMul(ProjetoIParser.ExprMulContext ctx) {
    Tipo tipo = visit(ctx.exprDiv(0));

    for (int i = 1; i < ctx.exprDiv().size(); i++) {
      Tipo outroTipo = visit(ctx.exprDiv(i));

      if (tipo != Tipo.INTEGER || outroTipo != Tipo.INTEGER) {
        throw erro(
            ctx.getStart(),
            "operador * exige operandos INTEGER");
      }

      tipo = Tipo.INTEGER;
    }

    return tipo;
  }

  @Override
  public Tipo visitExprDiv(ProjetoIParser.ExprDivContext ctx) {
    Tipo tipo = visit(ctx.exprUnary(0));

    for (int i = 1; i < ctx.exprUnary().size(); i++) {
      Tipo outroTipo = visit(ctx.exprUnary(i));

      if (tipo != Tipo.INTEGER || outroTipo != Tipo.INTEGER) {
        throw erro(
            ctx.getStart(),
            "operador / exige operandos INTEGER");
      }

      tipo = Tipo.INTEGER;
    }

    return tipo;
  }

  @Override
  public Tipo visitExprUnary(ProjetoIParser.ExprUnaryContext ctx) {
    if (ctx.exprPrimary() != null) {
      return visit(ctx.exprPrimary());
    }

    Tipo tipo = visit(ctx.exprUnary());

    if (ctx.OPNEG() != null) {
      if (tipo != Tipo.BOOLEAN) {
        throw erro(
            ctx.getStart(),
            "operador ~ exige operando BOOLEAN");
      }

      return Tipo.BOOLEAN;
    }

    if (ctx.OPAD() != null || ctx.OPSUB() != null) {
      if (tipo != Tipo.INTEGER) {
        throw erro(
            ctx.getStart(),
            "operador unario + ou - exige operando INTEGER");
      }

      return Tipo.INTEGER;
    }

    return Tipo.INVALIDO;
  }

  @Override
  public Tipo visitExprPrimary(ProjetoIParser.ExprPrimaryContext ctx) {
    if (ctx.ID() != null) {
      String nome = ctx.ID().getText();
      return tabela.buscar(nome).getTipo();
    }

    if (ctx.CTE() != null) {
      return Tipo.INTEGER;
    }

    if (ctx.TRUE() != null || ctx.FALSE() != null) {
      return Tipo.BOOLEAN;
    }

    if (ctx.expr() != null) {
      return visit(ctx.expr());
    }

    return Tipo.INVALIDO;
  }
}
