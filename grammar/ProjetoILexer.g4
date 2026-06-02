lexer grammar ProjetoILexer;

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
ABCHAVE: '{';
FCHAVE: '}';

CTE: NUM_1_32767 | '0';

ERRO_CTE_2_BYTES: DIGITO+;

CADEIA: '"' ( '\\' . | ~["\\\r\n])* '"';

ID:
	LETRA (LETRA | DIGITO)* {
	if (getText().length() > 16) setText(getText().substring(0,16));
};

COMMENT: '/*' ( . | '\r' | '\n')*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;

ERRO: .;

fragment NUM_1_32767:
	[1-9]
	| [1-9] DIGITO
	| [1-9] DIGITO DIGITO
	| [1-9] DIGITO DIGITO DIGITO
	| [1-2] DIGITO DIGITO DIGITO DIGITO
	| '3' [0-1] DIGITO DIGITO DIGITO
	| '32' [0-6] DIGITO DIGITO
	| '327' [0-5] DIGITO
	| '3276' [0-7];

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
