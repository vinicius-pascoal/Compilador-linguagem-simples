import org.antlr.v4.runtime.tree.TerminalNode;

public class GeradorCodigoIntermediario extends ProjetoIParserBaseVisitor<ResultadoExpressao3AC> {
  private final CodigoIntermediario codigo = new CodigoIntermediario();
  private int contadorTemporarios = 0;
  private int contadorRotulos = 0;

  public CodigoIntermediario gerar(ProjetoIParser.ProgContext ctx) {
    contadorTemporarios = 0;
    contadorRotulos = 0;

    if (ctx.ID() != null) {
      codigo.setNomePrograma(ctx.ID().getText());
    }

    visit(ctx);
    return codigo;
  }

  private String novoTemporario(Tipo tipo) {
    String nome = "t_" + contadorTemporarios++;
    codigo.declararTemporario(nome, tipo);
    return nome;
  }

  private String novoRotulo(String prefixo) {
    return prefixo + "_" + contadorRotulos++;
  }

  private void emitir(String instrucao) {
    codigo.adicionarInstrucao(instrucao);
  }

  private Tipo obterTipo(ProjetoIParser.TipContext ctx) {
    if (ctx.INTEGER() != null) return Tipo.INTEGER;
    if (ctx.BOOLEAN() != null) return Tipo.BOOLEAN;
    if (ctx.STRING() != null) return Tipo.STRING;
    return Tipo.INVALIDO;
  }

  private Tipo tipoDeIdentificador(String nome) {
    Tipo tipo = codigo.getTipo(nome);
    return tipo == Tipo.INVALIDO ? Tipo.INTEGER : tipo;
  }

  @Override
  public ResultadoExpressao3AC visitProg(ProjetoIParser.ProgContext ctx) {
    visit(ctx.decls());
    visit(ctx.cmdComp());
    return null;
  }

  @Override
  public ResultadoExpressao3AC visitDeclTip(ProjetoIParser.DeclTipContext ctx) {
    Tipo tipo = obterTipo(ctx.tip());

    for (TerminalNode id : ctx.listId().ID()) {
      codigo.declararVariavel(id.getText(), tipo);
    }

    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdComp(ProjetoIParser.CmdCompContext ctx) {
    if (ctx.listCmd() != null) {
      visit(ctx.listCmd());
    }
    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdBase(ProjetoIParser.CmdBaseContext ctx) {
    if (ctx.listCmd() != null) {
      visit(ctx.listCmd());
    }
    return null;
  }

  @Override
  public ResultadoExpressao3AC visitListCmd(ProjetoIParser.ListCmdContext ctx) {
    for (ProjetoIParser.CmdContext cmd : ctx.cmd()) {
      visit(cmd);
    }
    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdRead(ProjetoIParser.CmdReadContext ctx) {
    for (TerminalNode id : ctx.listId().ID()) {
      emitir("READ " + id.getText());
    }
    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdWrite(ProjetoIParser.CmdWriteContext ctx) {
    for (ProjetoIParser.ElemWContext elem : ctx.listW().elemW()) {
      if (elem.CADEIA() != null) {
        emitir("WRITE_STRING " + elem.CADEIA().getText());
      } else {
        ResultadoExpressao3AC valor = visit(elem.expr());
        emitir(instrucaoWrite(valor.getTipo()) + " " + valor.getLugar());
      }
    }
    return null;
  }

  private String instrucaoWrite(Tipo tipo) {
    if (tipo == Tipo.BOOLEAN) return "WRITE_BOOLEAN";
    if (tipo == Tipo.STRING) return "WRITE_STRING";
    return "WRITE_INTEGER";
  }

  @Override
  public ResultadoExpressao3AC visitCmdAtrib(ProjetoIParser.CmdAtribContext ctx) {
    String destino = ctx.ID().getText();
    ResultadoExpressao3AC valor = visit(ctx.expr());
    emitir(destino + " = " + valor.getLugar());
    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdIf(ProjetoIParser.CmdIfContext ctx) {
    ResultadoExpressao3AC condicao = visit(ctx.expr());

    String rotuloElse = novoRotulo("L_ELSE");
    String rotuloFim = novoRotulo("L_END_IF");

    emitir("IF_FALSE " + condicao.getLugar() + " GOTO " + rotuloElse);
    visit(ctx.cmdBase(0));

    if (ctx.cmdBase().size() > 1) {
      emitir("GOTO " + rotuloFim);
      emitir(rotuloElse + ":");
      visit(ctx.cmdBase(1));
      emitir(rotuloFim + ":");
    } else {
      emitir(rotuloElse + ":");
    }

    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdWhile(ProjetoIParser.CmdWhileContext ctx) {
    String rotuloInicio = novoRotulo("L_WHILE_START");
    String rotuloFim = novoRotulo("L_WHILE_END");

    emitir(rotuloInicio + ":");
    ResultadoExpressao3AC condicao = visit(ctx.expr());
    emitir("IF_FALSE " + condicao.getLugar() + " GOTO " + rotuloFim);
    visit(ctx.cmdBase());
    emitir("GOTO " + rotuloInicio);
    emitir(rotuloFim + ":");

    return null;
  }

  @Override
  public ResultadoExpressao3AC visitCmdFor(ProjetoIParser.CmdForContext ctx) {
    String variavelControle = ctx.ID().getText();
    ResultadoExpressao3AC inicio = visit(ctx.expr(0));
    ResultadoExpressao3AC fim = visit(ctx.expr(1));
    String rotuloInicio = novoRotulo("L_FOR_START");
    String rotuloFim = novoRotulo("L_FOR_END");

    emitir(variavelControle + " = " + inicio.getLugar());
    emitir(rotuloInicio + ":");

    String tempCondicao = novoTemporario(Tipo.BOOLEAN);
    emitir(tempCondicao + " = " + variavelControle + " <= " + fim.getLugar());
    emitir("IF_FALSE " + tempCondicao + " GOTO " + rotuloFim);

    visit(ctx.cmdBase());

    String tempIncremento = novoTemporario(Tipo.INTEGER);
    emitir(tempIncremento + " = " + variavelControle + " + 1");
    emitir(variavelControle + " = " + tempIncremento);
    emitir("GOTO " + rotuloInicio);
    emitir(rotuloFim + ":");

    return null;
  }

  @Override
  public ResultadoExpressao3AC visitExpr(ProjetoIParser.ExprContext ctx) {
    return visit(ctx.exprOr());
  }

  @Override
  public ResultadoExpressao3AC visitExprOr(ProjetoIParser.ExprOrContext ctx) {
    ResultadoExpressao3AC resultado = visit(ctx.exprAnd(0));

    for (int i = 1; i < ctx.exprAnd().size(); i++) {
      ResultadoExpressao3AC direita = visit(ctx.exprAnd(i));
      String temp = novoTemporario(Tipo.BOOLEAN);
      emitir(temp + " = " + resultado.getLugar() + " OR " + direita.getLugar());
      resultado = new ResultadoExpressao3AC(temp, Tipo.BOOLEAN);
    }

    return resultado;
  }

  @Override
  public ResultadoExpressao3AC visitExprAnd(ProjetoIParser.ExprAndContext ctx) {
    ResultadoExpressao3AC resultado = visit(ctx.exprRel(0));

    for (int i = 1; i < ctx.exprRel().size(); i++) {
      ResultadoExpressao3AC direita = visit(ctx.exprRel(i));
      String temp = novoTemporario(Tipo.BOOLEAN);
      emitir(temp + " = " + resultado.getLugar() + " AND " + direita.getLugar());
      resultado = new ResultadoExpressao3AC(temp, Tipo.BOOLEAN);
    }

    return resultado;
  }

  @Override
  public ResultadoExpressao3AC visitExprRel(ProjetoIParser.ExprRelContext ctx) {
    ResultadoExpressao3AC esquerda = visit(ctx.exprAdd(0));

    if (ctx.exprAdd().size() == 1) {
      return esquerda;
    }

    ResultadoExpressao3AC direita = visit(ctx.exprAdd(1));
    String operador = ctx.getChild(1).getText();
    String temp = novoTemporario(Tipo.BOOLEAN);
    emitir(temp + " = " + esquerda.getLugar() + " " + operador + " " + direita.getLugar());
    return new ResultadoExpressao3AC(temp, Tipo.BOOLEAN);
  }

  @Override
  public ResultadoExpressao3AC visitExprAdd(ProjetoIParser.ExprAddContext ctx) {
    ResultadoExpressao3AC resultado = visit(ctx.exprSub(0));

    for (int i = 1; i < ctx.exprSub().size(); i++) {
      ResultadoExpressao3AC direita = visit(ctx.exprSub(i));
      String temp = novoTemporario(Tipo.INTEGER);
      emitir(temp + " = " + resultado.getLugar() + " + " + direita.getLugar());
      resultado = new ResultadoExpressao3AC(temp, Tipo.INTEGER);
    }

    return resultado;
  }

  @Override
  public ResultadoExpressao3AC visitExprSub(ProjetoIParser.ExprSubContext ctx) {
    ResultadoExpressao3AC resultado = visit(ctx.exprMul(0));

    for (int i = 1; i < ctx.exprMul().size(); i++) {
      ResultadoExpressao3AC direita = visit(ctx.exprMul(i));
      String temp = novoTemporario(Tipo.INTEGER);
      emitir(temp + " = " + resultado.getLugar() + " - " + direita.getLugar());
      resultado = new ResultadoExpressao3AC(temp, Tipo.INTEGER);
    }

    return resultado;
  }

  @Override
  public ResultadoExpressao3AC visitExprMul(ProjetoIParser.ExprMulContext ctx) {
    ResultadoExpressao3AC resultado = visit(ctx.exprDiv(0));

    for (int i = 1; i < ctx.exprDiv().size(); i++) {
      ResultadoExpressao3AC direita = visit(ctx.exprDiv(i));
      String temp = novoTemporario(Tipo.INTEGER);
      emitir(temp + " = " + resultado.getLugar() + " * " + direita.getLugar());
      resultado = new ResultadoExpressao3AC(temp, Tipo.INTEGER);
    }

    return resultado;
  }

  @Override
  public ResultadoExpressao3AC visitExprDiv(ProjetoIParser.ExprDivContext ctx) {
    ResultadoExpressao3AC resultado = visit(ctx.exprUnary(0));

    for (int i = 1; i < ctx.exprUnary().size(); i++) {
      ResultadoExpressao3AC direita = visit(ctx.exprUnary(i));
      String temp = novoTemporario(Tipo.INTEGER);
      emitir(temp + " = " + resultado.getLugar() + " / " + direita.getLugar());
      resultado = new ResultadoExpressao3AC(temp, Tipo.INTEGER);
    }

    return resultado;
  }

  @Override
  public ResultadoExpressao3AC visitExprUnary(ProjetoIParser.ExprUnaryContext ctx) {
    if (ctx.exprPrimary() != null) {
      return visit(ctx.exprPrimary());
    }

    ResultadoExpressao3AC valor = visit(ctx.exprUnary());

    if (ctx.OPAD() != null) {
      return valor;
    }

    if (ctx.OPSUB() != null) {
      String temp = novoTemporario(Tipo.INTEGER);
      emitir(temp + " = -" + valor.getLugar());
      return new ResultadoExpressao3AC(temp, Tipo.INTEGER);
    }

    if (ctx.OPNEG() != null) {
      String temp = novoTemporario(Tipo.BOOLEAN);
      emitir(temp + " = ~" + valor.getLugar());
      return new ResultadoExpressao3AC(temp, Tipo.BOOLEAN);
    }

    return valor;
  }

  @Override
  public ResultadoExpressao3AC visitExprPrimary(ProjetoIParser.ExprPrimaryContext ctx) {
    if (ctx.ID() != null) {
      String nome = ctx.ID().getText();
      return new ResultadoExpressao3AC(nome, tipoDeIdentificador(nome));
    }

    if (ctx.CTE() != null) {
      return new ResultadoExpressao3AC(ctx.CTE().getText(), Tipo.INTEGER);
    }

    if (ctx.TRUE() != null) {
      return new ResultadoExpressao3AC("1", Tipo.BOOLEAN);
    }

    if (ctx.FALSE() != null) {
      return new ResultadoExpressao3AC("0", Tipo.BOOLEAN);
    }

    if (ctx.expr() != null) {
      return visit(ctx.expr());
    }

    return new ResultadoExpressao3AC("0", Tipo.INVALIDO);
  }
}
