// Generated from c:/Users/poluc/Documents/GitHub/Compilador-linguagem-simples/ProjetoI.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjetoIParser}.
 */
public interface ProjetoIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ProjetoIParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ProjetoIParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(ProjetoIParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(ProjetoIParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void enterListDecl(ProjetoIParser.ListDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void exitListDecl(ProjetoIParser.ListDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#declTip}.
	 * @param ctx the parse tree
	 */
	void enterDeclTip(ProjetoIParser.DeclTipContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#declTip}.
	 * @param ctx the parse tree
	 */
	void exitDeclTip(ProjetoIParser.DeclTipContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#listId}.
	 * @param ctx the parse tree
	 */
	void enterListId(ProjetoIParser.ListIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#listId}.
	 * @param ctx the parse tree
	 */
	void exitListId(ProjetoIParser.ListIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#tip}.
	 * @param ctx the parse tree
	 */
	void enterTip(ProjetoIParser.TipContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#tip}.
	 * @param ctx the parse tree
	 */
	void exitTip(ProjetoIParser.TipContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void enterCmdComp(ProjetoIParser.CmdCompContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void exitCmdComp(ProjetoIParser.CmdCompContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void enterListCmd(ProjetoIParser.ListCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void exitListCmd(ProjetoIParser.ListCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(ProjetoIParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(ProjetoIParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#matchedCmd}.
	 * @param ctx the parse tree
	 */
	void enterMatchedCmd(ProjetoIParser.MatchedCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#matchedCmd}.
	 * @param ctx the parse tree
	 */
	void exitMatchedCmd(ProjetoIParser.MatchedCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#unmatchedCmd}.
	 * @param ctx the parse tree
	 */
	void enterUnmatchedCmd(ProjetoIParser.UnmatchedCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#unmatchedCmd}.
	 * @param ctx the parse tree
	 */
	void exitUnmatchedCmd(ProjetoIParser.UnmatchedCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#otherCmd}.
	 * @param ctx the parse tree
	 */
	void enterOtherCmd(ProjetoIParser.OtherCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#otherCmd}.
	 * @param ctx the parse tree
	 */
	void exitOtherCmd(ProjetoIParser.OtherCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(ProjetoIParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(ProjetoIParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(ProjetoIParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(ProjetoIParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#listW}.
	 * @param ctx the parse tree
	 */
	void enterListW(ProjetoIParser.ListWContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#listW}.
	 * @param ctx the parse tree
	 */
	void exitListW(ProjetoIParser.ListWContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#elemW}.
	 * @param ctx the parse tree
	 */
	void enterElemW(ProjetoIParser.ElemWContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#elemW}.
	 * @param ctx the parse tree
	 */
	void exitElemW(ProjetoIParser.ElemWContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtrib(ProjetoIParser.CmdAtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtrib(ProjetoIParser.CmdAtribContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ProjetoIParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ProjetoIParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprOr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(ProjetoIParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprOr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(ProjetoIParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprAnd}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(ProjetoIParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprAnd}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(ProjetoIParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void enterExprRel(ProjetoIParser.ExprRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void exitExprRel(ProjetoIParser.ExprRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprAdd}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(ProjetoIParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprAdd}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(ProjetoIParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprMult}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(ProjetoIParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprMult}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(ProjetoIParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprUnary}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(ProjetoIParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprUnary}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(ProjetoIParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoIParser#exprPrimary}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimary(ProjetoIParser.ExprPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoIParser#exprPrimary}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimary(ProjetoIParser.ExprPrimaryContext ctx);
}