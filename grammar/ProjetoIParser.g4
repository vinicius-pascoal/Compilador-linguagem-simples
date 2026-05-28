parser grammar ProjetoIParser;

options {
	tokenVocab = ProjetoILexer;
}

prog: PROGRAM ID PVIG decls cmdComp PONTO EOF;

decls: VAR listDecl |;

listDecl: declTip+;

declTip: listId DPONTOS tip PVIG;

listId: ID (VIG ID)*;

tip: INTEGER | BOOLEAN | STRING;

cmdComp: BEGIN listCmd? END;

cmdBase: ABCHAVE listCmd? FCHAVE;

listCmd: cmd (PVIG cmd)* PVIG?;

cmd: cmdIf | cmdWhile | cmdFor | otherCmd;

cmdIf:
	IF ABPAR expr FPAR cmdBase
	| IF ABPAR expr FPAR cmdBase ELSE cmdBase;

cmdWhile: WHILE ABPAR expr FPAR cmdBase;

cmdFor: FOR ABPAR ID ATRIB expr TO expr FPAR cmdBase;

otherCmd: cmdBase | cmdRead | cmdWrite | cmdAtrib;

cmdRead: READ ABPAR listId FPAR;

cmdWrite: WRITE ABPAR listW FPAR;

listW: elemW (VIG elemW)*;

elemW: expr | CADEIA;

cmdAtrib: ID ATRIB expr;

expr: exprOr;

exprOr: exprAnd (OR exprAnd)*;

exprAnd: exprRel (AND exprRel)*;

exprRel: exprAdd ((OPREL | OPMOE | OPDIF | OPEQ) exprAdd)?;

exprAdd: exprSub (OPAD exprSub)*;

exprSub: exprMul (OPSUB exprMul)*;

exprMul: exprDiv (OPMULT exprDiv)*;

exprDiv: exprUnary (OPDI exprUnary)*;

exprUnary: (OPNEG | OPAD | OPSUB) exprUnary | exprPrimary;

exprPrimary: ID | CTE | TRUE | FALSE | ABPAR expr FPAR;
