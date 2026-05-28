// Generated from c:/Users/vpqmaynard/Desktop/compilados/linguagemSimples/grammar/ProjetoI.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ProjetoI extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, INTEGER=2, BOOLEAN=3, STRING=4, BEGIN=5, END=6, WHILE=7, FOR=8, 
		TO=9, DO=10, READ=11, VAR=12, FALSE=13, TRUE=14, WRITE=15, IF=16, THEN=17, 
		ELSE=18, OR=19, AND=20, OPREL=21, OPMOE=22, OPDIF=23, OPEQ=24, OPAD=25, 
		OPSUB=26, OPMULT=27, OPDI=28, OPNEG=29, ATRIB=30, PVIG=31, PONTO=32, DPONTOS=33, 
		VIG=34, ABPAR=35, FPAR=36, ABCHAVE=37, FCHAVE=38, CTE=39, ERRO_CTE_2_BYTES=40, 
		CADEIA=41, ID=42, COMMENT=43, WS=44, ERRO=45;
	public static final int
		RULE_prog = 0, RULE_decls = 1, RULE_listDecl = 2, RULE_declTip = 3, RULE_listId = 4, 
		RULE_tip = 5, RULE_cmdComp = 6, RULE_cmdBase = 7, RULE_listCmd = 8, RULE_cmd = 9, 
		RULE_cmdIf = 10, RULE_cmdWhile = 11, RULE_cmdFor = 12, RULE_otherCmd = 13, 
		RULE_cmdRead = 14, RULE_cmdWrite = 15, RULE_listW = 16, RULE_elemW = 17, 
		RULE_cmdAtrib = 18, RULE_expr = 19, RULE_exprOr = 20, RULE_exprAnd = 21, 
		RULE_exprRel = 22, RULE_exprAdd = 23, RULE_exprSub = 24, RULE_exprMul = 25, 
		RULE_exprDiv = 26, RULE_exprUnary = 27, RULE_exprPrimary = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decls", "listDecl", "declTip", "listId", "tip", "cmdComp", "cmdBase", 
			"listCmd", "cmd", "cmdIf", "cmdWhile", "cmdFor", "otherCmd", "cmdRead", 
			"cmdWrite", "listW", "elemW", "cmdAtrib", "expr", "exprOr", "exprAnd", 
			"exprRel", "exprAdd", "exprSub", "exprMul", "exprDiv", "exprUnary", "exprPrimary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'<>'", 
			"'=='", "'+'", "'-'", "'*'", "'/'", "'~'", "'='", "';'", "'.'", "':'", 
			"','", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "INTEGER", "BOOLEAN", "STRING", "BEGIN", "END", "WHILE", 
			"FOR", "TO", "DO", "READ", "VAR", "FALSE", "TRUE", "WRITE", "IF", "THEN", 
			"ELSE", "OR", "AND", "OPREL", "OPMOE", "OPDIF", "OPEQ", "OPAD", "OPSUB", 
			"OPMULT", "OPDI", "OPNEG", "ATRIB", "PVIG", "PONTO", "DPONTOS", "VIG", 
			"ABPAR", "FPAR", "ABCHAVE", "FCHAVE", "CTE", "ERRO_CTE_2_BYTES", "CADEIA", 
			"ID", "COMMENT", "WS", "ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ProjetoI.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProjetoI(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(ProjetoI.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(ProjetoI.ID, 0); }
		public TerminalNode PVIG() { return getToken(ProjetoI.PVIG, 0); }
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public TerminalNode PONTO() { return getToken(ProjetoI.PONTO, 0); }
		public TerminalNode EOF() { return getToken(ProjetoI.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(PROGRAM);
			setState(59);
			match(ID);
			setState(60);
			match(PVIG);
			setState(61);
			decls();
			setState(62);
			cmdComp();
			setState(63);
			match(PONTO);
			setState(64);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ProjetoI.VAR, 0); }
		public ListDeclContext listDecl() {
			return getRuleContext(ListDeclContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(VAR);
				setState(67);
				listDecl();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListDeclContext extends ParserRuleContext {
		public List<DeclTipContext> declTip() {
			return getRuleContexts(DeclTipContext.class);
		}
		public DeclTipContext declTip(int i) {
			return getRuleContext(DeclTipContext.class,i);
		}
		public ListDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDecl; }
	}

	public final ListDeclContext listDecl() throws RecognitionException {
		ListDeclContext _localctx = new ListDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				declTip();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclTipContext extends ParserRuleContext {
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode DPONTOS() { return getToken(ProjetoI.DPONTOS, 0); }
		public TipContext tip() {
			return getRuleContext(TipContext.class,0);
		}
		public TerminalNode PVIG() { return getToken(ProjetoI.PVIG, 0); }
		public DeclTipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declTip; }
	}

	public final DeclTipContext declTip() throws RecognitionException {
		DeclTipContext _localctx = new DeclTipContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declTip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			listId();
			setState(77);
			match(DPONTOS);
			setState(78);
			tip();
			setState(79);
			match(PVIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListIdContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProjetoI.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjetoI.ID, i);
		}
		public List<TerminalNode> VIG() { return getTokens(ProjetoI.VIG); }
		public TerminalNode VIG(int i) {
			return getToken(ProjetoI.VIG, i);
		}
		public ListIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listId; }
	}

	public final ListIdContext listId() throws RecognitionException {
		ListIdContext _localctx = new ListIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ID);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIG) {
				{
				{
				setState(82);
				match(VIG);
				setState(83);
				match(ID);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ProjetoI.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(ProjetoI.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(ProjetoI.STRING, 0); }
		public TipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tip; }
	}

	public final TipContext tip() throws RecognitionException {
		TipContext _localctx = new TipContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tip);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdCompContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(ProjetoI.BEGIN, 0); }
		public TerminalNode END() { return getToken(ProjetoI.END, 0); }
		public ListCmdContext listCmd() {
			return getRuleContext(ListCmdContext.class,0);
		}
		public CmdCompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdComp; }
	}

	public final CmdCompContext cmdComp() throws RecognitionException {
		CmdCompContext _localctx = new CmdCompContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdComp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(BEGIN);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4535485565312L) != 0)) {
				{
				setState(92);
				listCmd();
				}
			}

			setState(95);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdBaseContext extends ParserRuleContext {
		public TerminalNode ABCHAVE() { return getToken(ProjetoI.ABCHAVE, 0); }
		public TerminalNode FCHAVE() { return getToken(ProjetoI.FCHAVE, 0); }
		public ListCmdContext listCmd() {
			return getRuleContext(ListCmdContext.class,0);
		}
		public CmdBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdBase; }
	}

	public final CmdBaseContext cmdBase() throws RecognitionException {
		CmdBaseContext _localctx = new CmdBaseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdBase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ABCHAVE);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4535485565312L) != 0)) {
				{
				setState(98);
				listCmd();
				}
			}

			setState(101);
			match(FCHAVE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListCmdContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> PVIG() { return getTokens(ProjetoI.PVIG); }
		public TerminalNode PVIG(int i) {
			return getToken(ProjetoI.PVIG, i);
		}
		public ListCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCmd; }
	}

	public final ListCmdContext listCmd() throws RecognitionException {
		ListCmdContext _localctx = new ListCmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listCmd);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			cmd();
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					match(PVIG);
					setState(105);
					cmd();
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PVIG) {
				{
				setState(111);
				match(PVIG);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdForContext cmdFor() {
			return getRuleContext(CmdForContext.class,0);
		}
		public OtherCmdContext otherCmd() {
			return getRuleContext(OtherCmdContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmd);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				cmdIf();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				cmdWhile();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				cmdFor();
				}
				break;
			case READ:
			case WRITE:
			case ABCHAVE:
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				otherCmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ProjetoI.IF, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoI.ABPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoI.FPAR, 0); }
		public List<CmdBaseContext> cmdBase() {
			return getRuleContexts(CmdBaseContext.class);
		}
		public CmdBaseContext cmdBase(int i) {
			return getRuleContext(CmdBaseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ProjetoI.ELSE, 0); }
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdIf);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(IF);
				setState(121);
				match(ABPAR);
				setState(122);
				expr();
				setState(123);
				match(FPAR);
				setState(124);
				cmdBase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(IF);
				setState(127);
				match(ABPAR);
				setState(128);
				expr();
				setState(129);
				match(FPAR);
				setState(130);
				cmdBase();
				setState(131);
				match(ELSE);
				setState(132);
				cmdBase();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ProjetoI.WHILE, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoI.ABPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoI.FPAR, 0); }
		public CmdBaseContext cmdBase() {
			return getRuleContext(CmdBaseContext.class,0);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(WHILE);
			setState(137);
			match(ABPAR);
			setState(138);
			expr();
			setState(139);
			match(FPAR);
			setState(140);
			cmdBase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ProjetoI.FOR, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoI.ABPAR, 0); }
		public TerminalNode ID() { return getToken(ProjetoI.ID, 0); }
		public TerminalNode ATRIB() { return getToken(ProjetoI.ATRIB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TO() { return getToken(ProjetoI.TO, 0); }
		public TerminalNode FPAR() { return getToken(ProjetoI.FPAR, 0); }
		public CmdBaseContext cmdBase() {
			return getRuleContext(CmdBaseContext.class,0);
		}
		public CmdForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFor; }
	}

	public final CmdForContext cmdFor() throws RecognitionException {
		CmdForContext _localctx = new CmdForContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(FOR);
			setState(143);
			match(ABPAR);
			setState(144);
			match(ID);
			setState(145);
			match(ATRIB);
			setState(146);
			expr();
			setState(147);
			match(TO);
			setState(148);
			expr();
			setState(149);
			match(FPAR);
			setState(150);
			cmdBase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OtherCmdContext extends ParserRuleContext {
		public CmdBaseContext cmdBase() {
			return getRuleContext(CmdBaseContext.class,0);
		}
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAtribContext cmdAtrib() {
			return getRuleContext(CmdAtribContext.class,0);
		}
		public OtherCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherCmd; }
	}

	public final OtherCmdContext otherCmd() throws RecognitionException {
		OtherCmdContext _localctx = new OtherCmdContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_otherCmd);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABCHAVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				cmdBase();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				cmdRead();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				cmdWrite();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				cmdAtrib();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(ProjetoI.READ, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoI.ABPAR, 0); }
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoI.FPAR, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(READ);
			setState(159);
			match(ABPAR);
			setState(160);
			listId();
			setState(161);
			match(FPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(ProjetoI.WRITE, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoI.ABPAR, 0); }
		public ListWContext listW() {
			return getRuleContext(ListWContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoI.FPAR, 0); }
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(WRITE);
			setState(164);
			match(ABPAR);
			setState(165);
			listW();
			setState(166);
			match(FPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListWContext extends ParserRuleContext {
		public List<ElemWContext> elemW() {
			return getRuleContexts(ElemWContext.class);
		}
		public ElemWContext elemW(int i) {
			return getRuleContext(ElemWContext.class,i);
		}
		public List<TerminalNode> VIG() { return getTokens(ProjetoI.VIG); }
		public TerminalNode VIG(int i) {
			return getToken(ProjetoI.VIG, i);
		}
		public ListWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listW; }
	}

	public final ListWContext listW() throws RecognitionException {
		ListWContext _localctx = new ListWContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_listW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			elemW();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIG) {
				{
				{
				setState(169);
				match(VIG);
				setState(170);
				elemW();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElemWContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(ProjetoI.CADEIA, 0); }
		public ElemWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemW; }
	}

	public final ElemWContext elemW() throws RecognitionException {
		ElemWContext _localctx = new ElemWContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elemW);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
			case OPAD:
			case OPSUB:
			case OPNEG:
			case ABPAR:
			case CTE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				expr();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(CADEIA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjetoI.ID, 0); }
		public TerminalNode ATRIB() { return getToken(ProjetoI.ATRIB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdAtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtrib; }
	}

	public final CmdAtribContext cmdAtrib() throws RecognitionException {
		CmdAtribContext _localctx = new CmdAtribContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cmdAtrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ID);
			setState(181);
			match(ATRIB);
			setState(182);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprOrContext exprOr() {
			return getRuleContext(ExprOrContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			exprOr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ParserRuleContext {
		public List<ExprAndContext> exprAnd() {
			return getRuleContexts(ExprAndContext.class);
		}
		public ExprAndContext exprAnd(int i) {
			return getRuleContext(ExprAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ProjetoI.OR); }
		public TerminalNode OR(int i) {
			return getToken(ProjetoI.OR, i);
		}
		public ExprOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOr; }
	}

	public final ExprOrContext exprOr() throws RecognitionException {
		ExprOrContext _localctx = new ExprOrContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			exprAnd();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(187);
				match(OR);
				setState(188);
				exprAnd();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ParserRuleContext {
		public List<ExprRelContext> exprRel() {
			return getRuleContexts(ExprRelContext.class);
		}
		public ExprRelContext exprRel(int i) {
			return getRuleContext(ExprRelContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ProjetoI.AND); }
		public TerminalNode AND(int i) {
			return getToken(ProjetoI.AND, i);
		}
		public ExprAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAnd; }
	}

	public final ExprAndContext exprAnd() throws RecognitionException {
		ExprAndContext _localctx = new ExprAndContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exprAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			exprRel();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(195);
				match(AND);
				setState(196);
				exprRel();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelContext extends ParserRuleContext {
		public List<ExprAddContext> exprAdd() {
			return getRuleContexts(ExprAddContext.class);
		}
		public ExprAddContext exprAdd(int i) {
			return getRuleContext(ExprAddContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(ProjetoI.OPREL, 0); }
		public TerminalNode OPMOE() { return getToken(ProjetoI.OPMOE, 0); }
		public TerminalNode OPDIF() { return getToken(ProjetoI.OPDIF, 0); }
		public TerminalNode OPEQ() { return getToken(ProjetoI.OPEQ, 0); }
		public ExprRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRel; }
	}

	public final ExprRelContext exprRel() throws RecognitionException {
		ExprRelContext _localctx = new ExprRelContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exprRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			exprAdd();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) {
				{
				setState(203);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				exprAdd();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddContext extends ParserRuleContext {
		public List<ExprSubContext> exprSub() {
			return getRuleContexts(ExprSubContext.class);
		}
		public ExprSubContext exprSub(int i) {
			return getRuleContext(ExprSubContext.class,i);
		}
		public List<TerminalNode> OPAD() { return getTokens(ProjetoI.OPAD); }
		public TerminalNode OPAD(int i) {
			return getToken(ProjetoI.OPAD, i);
		}
		public ExprAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAdd; }
	}

	public final ExprAddContext exprAdd() throws RecognitionException {
		ExprAddContext _localctx = new ExprAddContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exprAdd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			exprSub();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPAD) {
				{
				{
				setState(208);
				match(OPAD);
				setState(209);
				exprSub();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprSubContext extends ParserRuleContext {
		public List<ExprMulContext> exprMul() {
			return getRuleContexts(ExprMulContext.class);
		}
		public ExprMulContext exprMul(int i) {
			return getRuleContext(ExprMulContext.class,i);
		}
		public List<TerminalNode> OPSUB() { return getTokens(ProjetoI.OPSUB); }
		public TerminalNode OPSUB(int i) {
			return getToken(ProjetoI.OPSUB, i);
		}
		public ExprSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSub; }
	}

	public final ExprSubContext exprSub() throws RecognitionException {
		ExprSubContext _localctx = new ExprSubContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exprSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			exprMul();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPSUB) {
				{
				{
				setState(216);
				match(OPSUB);
				setState(217);
				exprMul();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprMulContext extends ParserRuleContext {
		public List<ExprDivContext> exprDiv() {
			return getRuleContexts(ExprDivContext.class);
		}
		public ExprDivContext exprDiv(int i) {
			return getRuleContext(ExprDivContext.class,i);
		}
		public List<TerminalNode> OPMULT() { return getTokens(ProjetoI.OPMULT); }
		public TerminalNode OPMULT(int i) {
			return getToken(ProjetoI.OPMULT, i);
		}
		public ExprMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprMul; }
	}

	public final ExprMulContext exprMul() throws RecognitionException {
		ExprMulContext _localctx = new ExprMulContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_exprMul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			exprDiv();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPMULT) {
				{
				{
				setState(224);
				match(OPMULT);
				setState(225);
				exprDiv();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprDivContext extends ParserRuleContext {
		public List<ExprUnaryContext> exprUnary() {
			return getRuleContexts(ExprUnaryContext.class);
		}
		public ExprUnaryContext exprUnary(int i) {
			return getRuleContext(ExprUnaryContext.class,i);
		}
		public List<TerminalNode> OPDI() { return getTokens(ProjetoI.OPDI); }
		public TerminalNode OPDI(int i) {
			return getToken(ProjetoI.OPDI, i);
		}
		public ExprDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprDiv; }
	}

	public final ExprDivContext exprDiv() throws RecognitionException {
		ExprDivContext _localctx = new ExprDivContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_exprDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			exprUnary();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPDI) {
				{
				{
				setState(232);
				match(OPDI);
				setState(233);
				exprUnary();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnaryContext extends ParserRuleContext {
		public ExprUnaryContext exprUnary() {
			return getRuleContext(ExprUnaryContext.class,0);
		}
		public TerminalNode OPNEG() { return getToken(ProjetoI.OPNEG, 0); }
		public TerminalNode OPAD() { return getToken(ProjetoI.OPAD, 0); }
		public TerminalNode OPSUB() { return getToken(ProjetoI.OPSUB, 0); }
		public ExprPrimaryContext exprPrimary() {
			return getRuleContext(ExprPrimaryContext.class,0);
		}
		public ExprUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprUnary; }
	}

	public final ExprUnaryContext exprUnary() throws RecognitionException {
		ExprUnaryContext _localctx = new ExprUnaryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exprUnary);
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAD:
			case OPSUB:
			case OPNEG:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 637534208L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				exprUnary();
				}
				break;
			case FALSE:
			case TRUE:
			case ABPAR:
			case CTE:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				exprPrimary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprPrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjetoI.ID, 0); }
		public TerminalNode CTE() { return getToken(ProjetoI.CTE, 0); }
		public TerminalNode TRUE() { return getToken(ProjetoI.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ProjetoI.FALSE, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoI.ABPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoI.FPAR, 0); }
		public ExprPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprPrimary; }
	}

	public final ExprPrimaryContext exprPrimary() throws RecognitionException {
		ExprPrimaryContext _localctx = new ExprPrimaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_exprPrimary);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(ID);
				}
				break;
			case CTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(CTE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				match(FALSE);
				}
				break;
			case ABPAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(248);
				match(ABPAR);
				setState(249);
				expr();
				setState(250);
				match(FPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u00ff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001F\b\u0001\u0001\u0002\u0004\u0002I\b\u0002\u000b"+
		"\u0002\f\u0002J\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004U\b\u0004\n\u0004"+
		"\f\u0004X\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003"+
		"\u0006^\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007d\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005"+
		"\bk\b\b\n\b\f\bn\t\b\u0001\b\u0003\bq\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\tw\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0087"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u009d\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00ac\b\u0010\n\u0010\f\u0010\u00af\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00b3\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u00be\b\u0014\n\u0014\f\u0014\u00c1\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u00c6\b\u0015\n\u0015\f\u0015\u00c9\t\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00ce\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u00d3\b\u0017\n\u0017\f\u0017\u00d6"+
		"\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00db\b\u0018"+
		"\n\u0018\f\u0018\u00de\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005"+
		"\u0019\u00e3\b\u0019\n\u0019\f\u0019\u00e6\t\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u00eb\b\u001a\n\u001a\f\u001a\u00ee\t\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u00f3\b\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u00fd\b\u001c\u0001\u001c\u0000\u0000\u001d\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468\u0000\u0003\u0001\u0000\u0002\u0004\u0001\u0000\u0015\u0018"+
		"\u0002\u0000\u0019\u001a\u001d\u001d\u00fd\u0000:\u0001\u0000\u0000\u0000"+
		"\u0002E\u0001\u0000\u0000\u0000\u0004H\u0001\u0000\u0000\u0000\u0006L"+
		"\u0001\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nY\u0001\u0000\u0000"+
		"\u0000\f[\u0001\u0000\u0000\u0000\u000ea\u0001\u0000\u0000\u0000\u0010"+
		"g\u0001\u0000\u0000\u0000\u0012v\u0001\u0000\u0000\u0000\u0014\u0086\u0001"+
		"\u0000\u0000\u0000\u0016\u0088\u0001\u0000\u0000\u0000\u0018\u008e\u0001"+
		"\u0000\u0000\u0000\u001a\u009c\u0001\u0000\u0000\u0000\u001c\u009e\u0001"+
		"\u0000\u0000\u0000\u001e\u00a3\u0001\u0000\u0000\u0000 \u00a8\u0001\u0000"+
		"\u0000\u0000\"\u00b2\u0001\u0000\u0000\u0000$\u00b4\u0001\u0000\u0000"+
		"\u0000&\u00b8\u0001\u0000\u0000\u0000(\u00ba\u0001\u0000\u0000\u0000*"+
		"\u00c2\u0001\u0000\u0000\u0000,\u00ca\u0001\u0000\u0000\u0000.\u00cf\u0001"+
		"\u0000\u0000\u00000\u00d7\u0001\u0000\u0000\u00002\u00df\u0001\u0000\u0000"+
		"\u00004\u00e7\u0001\u0000\u0000\u00006\u00f2\u0001\u0000\u0000\u00008"+
		"\u00fc\u0001\u0000\u0000\u0000:;\u0005\u0001\u0000\u0000;<\u0005*\u0000"+
		"\u0000<=\u0005\u001f\u0000\u0000=>\u0003\u0002\u0001\u0000>?\u0003\f\u0006"+
		"\u0000?@\u0005 \u0000\u0000@A\u0005\u0000\u0000\u0001A\u0001\u0001\u0000"+
		"\u0000\u0000BC\u0005\f\u0000\u0000CF\u0003\u0004\u0002\u0000DF\u0001\u0000"+
		"\u0000\u0000EB\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000F\u0003"+
		"\u0001\u0000\u0000\u0000GI\u0003\u0006\u0003\u0000HG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000K\u0005\u0001\u0000\u0000\u0000LM\u0003\b\u0004\u0000MN\u0005"+
		"!\u0000\u0000NO\u0003\n\u0005\u0000OP\u0005\u001f\u0000\u0000P\u0007\u0001"+
		"\u0000\u0000\u0000QV\u0005*\u0000\u0000RS\u0005\"\u0000\u0000SU\u0005"+
		"*\u0000\u0000TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\t\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000YZ\u0007\u0000\u0000\u0000Z\u000b\u0001\u0000"+
		"\u0000\u0000[]\u0005\u0005\u0000\u0000\\^\u0003\u0010\b\u0000]\\\u0001"+
		"\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0005\u0006\u0000\u0000`\r\u0001\u0000\u0000\u0000ac\u0005%\u0000\u0000"+
		"bd\u0003\u0010\b\u0000cb\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ef\u0005&\u0000\u0000f\u000f\u0001\u0000\u0000"+
		"\u0000gl\u0003\u0012\t\u0000hi\u0005\u001f\u0000\u0000ik\u0003\u0012\t"+
		"\u0000jh\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000oq\u0005\u001f\u0000\u0000po\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000q\u0011\u0001\u0000\u0000\u0000rw\u0003\u0014"+
		"\n\u0000sw\u0003\u0016\u000b\u0000tw\u0003\u0018\f\u0000uw\u0003\u001a"+
		"\r\u0000vr\u0001\u0000\u0000\u0000vs\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000vu\u0001\u0000\u0000\u0000w\u0013\u0001\u0000\u0000\u0000"+
		"xy\u0005\u0010\u0000\u0000yz\u0005#\u0000\u0000z{\u0003&\u0013\u0000{"+
		"|\u0005$\u0000\u0000|}\u0003\u000e\u0007\u0000}\u0087\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005\u0010\u0000\u0000\u007f\u0080\u0005#\u0000\u0000\u0080"+
		"\u0081\u0003&\u0013\u0000\u0081\u0082\u0005$\u0000\u0000\u0082\u0083\u0003"+
		"\u000e\u0007\u0000\u0083\u0084\u0005\u0012\u0000\u0000\u0084\u0085\u0003"+
		"\u000e\u0007\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086x\u0001\u0000"+
		"\u0000\u0000\u0086~\u0001\u0000\u0000\u0000\u0087\u0015\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005\u0007\u0000\u0000\u0089\u008a\u0005#\u0000\u0000"+
		"\u008a\u008b\u0003&\u0013\u0000\u008b\u008c\u0005$\u0000\u0000\u008c\u008d"+
		"\u0003\u000e\u0007\u0000\u008d\u0017\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005\b\u0000\u0000\u008f\u0090\u0005#\u0000\u0000\u0090\u0091\u0005"+
		"*\u0000\u0000\u0091\u0092\u0005\u001e\u0000\u0000\u0092\u0093\u0003&\u0013"+
		"\u0000\u0093\u0094\u0005\t\u0000\u0000\u0094\u0095\u0003&\u0013\u0000"+
		"\u0095\u0096\u0005$\u0000\u0000\u0096\u0097\u0003\u000e\u0007\u0000\u0097"+
		"\u0019\u0001\u0000\u0000\u0000\u0098\u009d\u0003\u000e\u0007\u0000\u0099"+
		"\u009d\u0003\u001c\u000e\u0000\u009a\u009d\u0003\u001e\u000f\u0000\u009b"+
		"\u009d\u0003$\u0012\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u0099"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b"+
		"\u0001\u0000\u0000\u0000\u009d\u001b\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005\u000b\u0000\u0000\u009f\u00a0\u0005#\u0000\u0000\u00a0\u00a1\u0003"+
		"\b\u0004\u0000\u00a1\u00a2\u0005$\u0000\u0000\u00a2\u001d\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0005\u000f\u0000\u0000\u00a4\u00a5\u0005#\u0000"+
		"\u0000\u00a5\u00a6\u0003 \u0010\u0000\u00a6\u00a7\u0005$\u0000\u0000\u00a7"+
		"\u001f\u0001\u0000\u0000\u0000\u00a8\u00ad\u0003\"\u0011\u0000\u00a9\u00aa"+
		"\u0005\"\u0000\u0000\u00aa\u00ac\u0003\"\u0011\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae!\u0001\u0000"+
		"\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3\u0003&\u0013"+
		"\u0000\u00b1\u00b3\u0005)\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3#\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0005*\u0000\u0000\u00b5\u00b6\u0005\u001e\u0000\u0000\u00b6\u00b7"+
		"\u0003&\u0013\u0000\u00b7%\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003("+
		"\u0014\u0000\u00b9\'\u0001\u0000\u0000\u0000\u00ba\u00bf\u0003*\u0015"+
		"\u0000\u00bb\u00bc\u0005\u0013\u0000\u0000\u00bc\u00be\u0003*\u0015\u0000"+
		"\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000"+
		"\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c0)\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c7\u0003,\u0016\u0000\u00c3\u00c4\u0005\u0014\u0000\u0000\u00c4\u00c6"+
		"\u0003,\u0016\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8+\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cd\u0003.\u0017\u0000\u00cb\u00cc\u0007\u0001\u0000"+
		"\u0000\u00cc\u00ce\u0003.\u0017\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce-\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d4\u00030\u0018\u0000\u00d0\u00d1\u0005\u0019\u0000\u0000\u00d1\u00d3"+
		"\u00030\u0018\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d5/\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d7\u00dc\u00032\u0019\u0000\u00d8\u00d9\u0005\u001a\u0000"+
		"\u0000\u00d9\u00db\u00032\u0019\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd1\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df\u00e4\u00034\u001a\u0000\u00e0\u00e1"+
		"\u0005\u001b\u0000\u0000\u00e1\u00e3\u00034\u001a\u0000\u00e2\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e53\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00ec\u00036\u001b"+
		"\u0000\u00e8\u00e9\u0005\u001c\u0000\u0000\u00e9\u00eb\u00036\u001b\u0000"+
		"\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ed5\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0007\u0002\u0000\u0000\u00f0\u00f3\u00036\u001b\u0000\u00f1\u00f3"+
		"\u00038\u001c\u0000\u00f2\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f37\u0001\u0000\u0000\u0000\u00f4\u00fd\u0005*\u0000"+
		"\u0000\u00f5\u00fd\u0005\'\u0000\u0000\u00f6\u00fd\u0005\u000e\u0000\u0000"+
		"\u00f7\u00fd\u0005\r\u0000\u0000\u00f8\u00f9\u0005#\u0000\u0000\u00f9"+
		"\u00fa\u0003&\u0013\u0000\u00fa\u00fb\u0005$\u0000\u0000\u00fb\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fc\u00f4\u0001\u0000\u0000\u0000\u00fc\u00f5\u0001"+
		"\u0000\u0000\u0000\u00fc\u00f6\u0001\u0000\u0000\u0000\u00fc\u00f7\u0001"+
		"\u0000\u0000\u0000\u00fc\u00f8\u0001\u0000\u0000\u0000\u00fd9\u0001\u0000"+
		"\u0000\u0000\u0015EJV]clpv\u0086\u009c\u00ad\u00b2\u00bf\u00c7\u00cd\u00d4"+
		"\u00dc\u00e4\u00ec\u00f2\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}