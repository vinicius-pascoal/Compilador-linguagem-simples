import java.util.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class GeradorCodigo extends ProjetoIParserBaseVisitor<String> {

  private final StringBuilder sb = new StringBuilder();
  private final StringBuilder decls = new StringBuilder();
  private final Map<String, String> varTypes = new LinkedHashMap<>();
  private String className = "ProgramaGerado";

  public String gerar(ProjetoIParser.ProgContext ctx) {
    sb.setLength(0);
    decls.setLength(0);
    varTypes.clear();
    // usar o identificador do prog como nome da classe
    if (ctx.ID() != null)
      className = ctx.ID().getText();

    sb.append("import java.util.*;\n");
    sb.append("public class ").append(className).append(" {\n");
    sb.append("  public static void main(String[] args) {\n");
    sb.append("    Scanner sc = new Scanner(System.in);\n");

    // collect declarations first
    visit(ctx.decls());

    // emit declarations
    if (decls.length() > 0) {
      sb.append(decls.toString());
      sb.append("\n");
    }

    // emit commands
    visit(ctx.cmdComp());

    sb.append("  }\n");
    sb.append("}\n");

    return sb.toString();
  }

  public String getClassName() {
    return className;
  }

  @Override
  public String visitDeclTip(ProjetoIParser.DeclTipContext ctx) {
    String tipoJava = null;
    if (ctx.tip().INTEGER() != null)
      tipoJava = "int";
    if (ctx.tip().BOOLEAN() != null)
      tipoJava = "boolean";
    if (ctx.tip().STRING() != null)
      tipoJava = "String";

    for (org.antlr.v4.runtime.tree.TerminalNode id : ctx.listId().ID()) {
      String nome = id.getText();
      varTypes.put(nome, tipoJava);
      decls.append("    ").append(tipoJava).append(" ").append(nome).append(";\n");
    }

    return "";
  }

  @Override
  public String visitCmdAtrib(ProjetoIParser.CmdAtribContext ctx) {
    String nome = ctx.ID().getText();
    String expr = visit(ctx.expr());
    sb.append("    ").append(nome).append(" = ").append(expr).append(";\n");
    return "";
  }

  @Override
  public String visitCmdRead(ProjetoIParser.CmdReadContext ctx) {
    for (org.antlr.v4.runtime.tree.TerminalNode id : ctx.listId().ID()) {
      String nome = id.getText();
      String tipo = varTypes.getOrDefault(nome, "int");
      if ("int".equals(tipo))
        sb.append("    ").append(nome).append(" = sc.nextInt();\n");
      else if ("boolean".equals(tipo))
        sb.append("    ").append(nome).append(" = sc.nextBoolean();\n");
      else
        sb.append("    ").append(nome).append(" = sc.nextLine();\n");
    }
    return "";
  }

  @Override
  public String visitCmdWrite(ProjetoIParser.CmdWriteContext ctx) {
    for (ProjetoIParser.ElemWContext w : ctx.listW().elemW()) {
      String v = visit(w);
      sb.append("    System.out.println(").append(v).append(");\n");
    }
    return "";
  }

  @Override
  public String visitElemW(ProjetoIParser.ElemWContext ctx) {
    if (ctx.CADEIA() != null)
      return ctx.CADEIA().getText();
    return visit(ctx.expr());
  }

  @Override
  public String visitCmdIf(ProjetoIParser.CmdIfContext ctx) {
    String cond = visit(ctx.expr());
    sb.append("    if (").append(cond).append(") ");
    visit(ctx.cmdBase(0));
    if (ctx.cmdBase().size() > 1) {
      sb.append(" else ");
      visit(ctx.cmdBase(1));
    }
    sb.append("\n");
    return "";
  }

  @Override
  public String visitCmdWhile(ProjetoIParser.CmdWhileContext ctx) {
    String cond = visit(ctx.expr());
    sb.append("    while (").append(cond).append(") ");
    visit(ctx.cmdBase());
    sb.append("\n");
    return "";
  }

  @Override
  public String visitCmdFor(ProjetoIParser.CmdForContext ctx) {
    String id = ctx.ID().getText();
    String inicio = visit(ctx.expr(0));
    String fim = visit(ctx.expr(1));
    String inicializador = varTypes.containsKey(id) ? (id + " = " + inicio) : ("int " + id + " = " + inicio);
    sb.append("    for (").append(inicializador).append("; ").append(id)
        .append(" <= ").append(fim).append("; ").append(id).append("++) ");
    visit(ctx.cmdBase());
    sb.append("\n");
    return "";
  }

  @Override
  public String visitCmdBase(ProjetoIParser.CmdBaseContext ctx) {
    sb.append("{\n");
    if (ctx.listCmd() != null)
      visit(ctx.listCmd());
    sb.append("    }");
    return "";
  }

  @Override
  public String visitListCmd(ProjetoIParser.ListCmdContext ctx) {
    for (ProjetoIParser.CmdContext c : ctx.cmd()) {
      visit(c);
    }
    return "";
  }

  // Expressions: build Java expression strings
  @Override
  public String visitExpr(ProjetoIParser.ExprContext ctx) {
    return visit(ctx.exprOr());
  }

  @Override
  public String visitExprOr(ProjetoIParser.ExprOrContext ctx) {
    String res = visit(ctx.exprAnd(0));
    for (int i = 1; i < ctx.exprAnd().size(); i++) {
      res = "(" + res + " || " + visit(ctx.exprAnd(i)) + ")";
    }
    return res;
  }

  @Override
  public String visitExprAnd(ProjetoIParser.ExprAndContext ctx) {
    String res = visit(ctx.exprRel(0));
    for (int i = 1; i < ctx.exprRel().size(); i++) {
      res = "(" + res + " && " + visit(ctx.exprRel(i)) + ")";
    }
    return res;
  }

  @Override
  public String visitExprRel(ProjetoIParser.ExprRelContext ctx) {
    if (ctx.exprAdd().size() == 1)
      return visit(ctx.exprAdd(0));

    String esq = visit(ctx.exprAdd(0));
    String dir = visit(ctx.exprAdd(1));

    if (ctx.OPREL() != null || ctx.OPMOE() != null)
      return "(" + esq + " " + ctx.getChild(1).getText() + " " + dir + ")";
    if (ctx.OPEQ() != null)
      return "(" + esq + " == " + dir + ")";
    if (ctx.OPDIF() != null)
      return "(" + esq + " != " + dir + ")";

    return "";
  }

  @Override
  public String visitExprAdd(ProjetoIParser.ExprAddContext ctx) {
    String res = visit(ctx.exprSub(0));
    for (int i = 1; i < ctx.exprSub().size(); i++) {
      res = "(" + res + " + " + visit(ctx.exprSub(i)) + ")";
    }
    return res;
  }

  @Override
  public String visitExprSub(ProjetoIParser.ExprSubContext ctx) {
    String res = visit(ctx.exprMul(0));
    for (int i = 1; i < ctx.exprMul().size(); i++) {
      res = "(" + res + " - " + visit(ctx.exprMul(i)) + ")";
    }
    return res;
  }

  @Override
  public String visitExprMul(ProjetoIParser.ExprMulContext ctx) {
    String res = visit(ctx.exprDiv(0));
    for (int i = 1; i < ctx.exprDiv().size(); i++) {
      res = "(" + res + " * " + visit(ctx.exprDiv(i)) + ")";
    }
    return res;
  }

  @Override
  public String visitExprDiv(ProjetoIParser.ExprDivContext ctx) {
    String res = visit(ctx.exprUnary(0));
    for (int i = 1; i < ctx.exprUnary().size(); i++) {
      res = "(" + res + " / " + visit(ctx.exprUnary(i)) + ")";
    }
    return res;
  }

  @Override
  public String visitExprUnary(ProjetoIParser.ExprUnaryContext ctx) {
    if (ctx.exprPrimary() != null)
      return visit(ctx.exprPrimary());
    String inner = visit(ctx.exprUnary());
    if (ctx.OPNEG() != null)
      return "(!" + inner + ")";
    if (ctx.OPAD() != null)
      return "(" + inner + ")";
    if (ctx.OPSUB() != null)
      return "(-" + inner + ")";
    return "";
  }

  @Override
  public String visitExprPrimary(ProjetoIParser.ExprPrimaryContext ctx) {
    if (ctx.ID() != null)
      return ctx.ID().getText();
    if (ctx.CTE() != null)
      return ctx.CTE().getText();
    if (ctx.TRUE() != null)
      return "true";
    if (ctx.FALSE() != null)
      return "false";
    if (ctx.expr() != null)
      return visit(ctx.expr());
    return "";
  }
}
