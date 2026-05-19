grammar ProjetoI;

prog: PROGRAM ID PVIG decls cmdComp PONTO EOF;

decls: VAR listDecl |;

listDecl: declTip+;

declTip: listId DPONTOS tip PVIG;

listId: ID (VIG ID)*;

tip: INTEGER | BOOLEAN | STRING;

cmdComp: BEGIN listCmd? END;

cmdBase: '{' listCmd? '}';

listCmd: cmd (PVIG cmd)*;

cmd: matchedCmd;

loops:
	WHILE expr DO matchedCmd
	| FOR ID ATRIB expr TO expr DO matchedCmd;

cmdsimple: IF expr THEN matchedCmd ELSE matchedCmd | loops;

matchedCmd: otherCmd | cmdsimple;

otherCmd: cmdBase | cmdBextra;

cmdBextra: cmdBadd | cmdRead;

cmdBadd: cmdWrite | cmdAtrib;

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

exprUnary:
	OPNEG exprUnary
	| OPAD exprUnary
	| OPSUB exprUnary
	| exprPrimary;

exprPrimary: ID | CTE | TRUE | FALSE | ABPAR expr FPAR;

PROGRAM: P R O G R A M;
INTEGER: I N T E G E R;
BOOLEAN: B O O L E A N;
STRING: S T R I N G;
BEGIN: B E G I N;
END: E N D;
WHILE: W H I L E;
FOR: F O R;
TO: T O;
DO: D O;
READ: R E A D;
VAR: V A R;
FALSE: F A L S E;
TRUE: T R U E;
WRITE: W R I T E;
IF: I F;
THEN: T H E N;
ELSE: E L S E;

OR: O R;
AND: A N D;

OPREL: '<=' | '>=';

OPMOE: '<' | '>';

OPDIF: '<>';

OPEQ: '==';

OPAD: '+';

OPSUB: '-';

OPMULT: '*';

OPDI: '/';

OPNEG: '~';

ATRIB: '=';
PVIG: ';';
PONTO: '.';
DPONTOS: ':';
VIG: ',';
ABPAR: '(';
FPAR: ')';

CTE: DIGITO+;

CADEIA: '"' (~["\r\n])* '"';

ID: LETRA (LETRA | DIGITO)*;

COMMENT: '/' ~[/\r\n]* '/' -> skip;

WS: [ \t\r\n]+ -> skip;

fragment LETRA: [a-zA-Z];
fragment DIGITO: [0-9];

fragment A: [aA];
fragment B: [bB];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment Y: [yY];
