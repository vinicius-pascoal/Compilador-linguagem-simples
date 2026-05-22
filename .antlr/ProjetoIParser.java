// Generated from c:/Users/vpqmaynard/Desktop/compilados/linguagemSimples/ProjetoI.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ProjetoIParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, INTEGER=2, BOOLEAN=3, STRING=4, BEGIN=5, END=6, WHILE=7, FOR=8, 
		TO=9, DO=10, READ=11, VAR=12, FALSE=13, TRUE=14, WRITE=15, IF=16, THEN=17, 
		ELSE=18, OR=19, AND=20, OPREL=21, OPMOE=22, OPDIF=23, OPEQ=24, OPAD=25, 
		OPSUB=26, OPMULT=27, OPDI=28, OPNEG=29, ATRIB=30, PVIG=31, PONTO=32, DPONTOS=33, 
		VIG=34, ABPAR=35, FPAR=36, ABCHAVE=37, FCHAVE=38, CTE=39, CADEIA=40, ID=41, 
		COMMENT=42, WS=43, ERRO=44;
	public static final int
		RULE_prog = 0, RULE_decls = 1, RULE_listDecl = 2, RULE_declTip = 3, RULE_listId = 4, 
		RULE_tip = 5, RULE_cmdComp = 6, RULE_cmdBase = 7, RULE_listCmd = 8, RULE_cmd = 9, 
		RULE_loops = 10, RULE_loopsUnmatched = 11, RULE_cmdsimple = 12, RULE_unmatchedCmd = 13, 
		RULE_matchedCmd = 14, RULE_otherCmd = 15, RULE_cmdBextra = 16, RULE_cmdBadd = 17, 
		RULE_cmdRead = 18, RULE_cmdWrite = 19, RULE_listW = 20, RULE_elemW = 21, 
		RULE_cmdAtrib = 22, RULE_expr = 23, RULE_exprOr = 24, RULE_exprAnd = 25, 
		RULE_exprRel = 26, RULE_exprAdd = 27, RULE_exprSub = 28, RULE_exprMul = 29, 
		RULE_exprDiv = 30, RULE_exprUnary = 31, RULE_exprPrimary = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decls", "listDecl", "declTip", "listId", "tip", "cmdComp", "cmdBase", 
			"listCmd", "cmd", "loops", "loopsUnmatched", "cmdsimple", "unmatchedCmd", 
			"matchedCmd", "otherCmd", "cmdBextra", "cmdBadd", "cmdRead", "cmdWrite", 
			"listW", "elemW", "cmdAtrib", "expr", "exprOr", "exprAnd", "exprRel", 
			"exprAdd", "exprSub", "exprMul", "exprDiv", "exprUnary", "exprPrimary"
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
			"ABPAR", "FPAR", "ABCHAVE", "FCHAVE", "CTE", "CADEIA", "ID", "COMMENT", 
			"WS", "ERRO"
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

	public ProjetoIParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(ProjetoIParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(ProjetoIParser.ID, 0); }
		public TerminalNode PVIG() { return getToken(ProjetoIParser.PVIG, 0); }
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public TerminalNode PONTO() { return getToken(ProjetoIParser.PONTO, 0); }
		public TerminalNode EOF() { return getToken(ProjetoIParser.EOF, 0); }
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
			setState(66);
			match(PROGRAM);
			setState(67);
			match(ID);
			setState(68);
			match(PVIG);
			setState(69);
			decls();
			setState(70);
			cmdComp();
			setState(71);
			match(PONTO);
			setState(72);
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
		public TerminalNode VAR() { return getToken(ProjetoIParser.VAR, 0); }
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(VAR);
				setState(75);
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
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				declTip();
				}
				}
				setState(82); 
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
		public TerminalNode DPONTOS() { return getToken(ProjetoIParser.DPONTOS, 0); }
		public TipContext tip() {
			return getRuleContext(TipContext.class,0);
		}
		public TerminalNode PVIG() { return getToken(ProjetoIParser.PVIG, 0); }
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
			setState(84);
			listId();
			setState(85);
			match(DPONTOS);
			setState(86);
			tip();
			setState(87);
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
		public List<TerminalNode> ID() { return getTokens(ProjetoIParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjetoIParser.ID, i);
		}
		public List<TerminalNode> VIG() { return getTokens(ProjetoIParser.VIG); }
		public TerminalNode VIG(int i) {
			return getToken(ProjetoIParser.VIG, i);
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
			setState(89);
			match(ID);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIG) {
				{
				{
				setState(90);
				match(VIG);
				setState(91);
				match(ID);
				}
				}
				setState(96);
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
		public TerminalNode INTEGER() { return getToken(ProjetoIParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(ProjetoIParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(ProjetoIParser.STRING, 0); }
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
			setState(97);
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
		public TerminalNode BEGIN() { return getToken(ProjetoIParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(ProjetoIParser.END, 0); }
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
			setState(99);
			match(BEGIN);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2336462309760L) != 0)) {
				{
				setState(100);
				listCmd();
				}
			}

			setState(103);
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
		public TerminalNode ABCHAVE() { return getToken(ProjetoIParser.ABCHAVE, 0); }
		public TerminalNode FCHAVE() { return getToken(ProjetoIParser.FCHAVE, 0); }
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
			setState(105);
			match(ABCHAVE);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2336462309760L) != 0)) {
				{
				setState(106);
				listCmd();
				}
			}

			setState(109);
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
		public List<TerminalNode> PVIG() { return getTokens(ProjetoIParser.PVIG); }
		public TerminalNode PVIG(int i) {
			return getToken(ProjetoIParser.PVIG, i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			cmd();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PVIG) {
				{
				{
				setState(112);
				match(PVIG);
				setState(113);
				cmd();
				}
				}
				setState(118);
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
	public static class CmdContext extends ParserRuleContext {
		public MatchedCmdContext matchedCmd() {
			return getRuleContext(MatchedCmdContext.class,0);
		}
		public UnmatchedCmdContext unmatchedCmd() {
			return getRuleContext(UnmatchedCmdContext.class,0);
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
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				matchedCmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				unmatchedCmd();
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
	public static class LoopsContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ProjetoIParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DO() { return getToken(ProjetoIParser.DO, 0); }
		public MatchedCmdContext matchedCmd() {
			return getRuleContext(MatchedCmdContext.class,0);
		}
		public TerminalNode FOR() { return getToken(ProjetoIParser.FOR, 0); }
		public TerminalNode ID() { return getToken(ProjetoIParser.ID, 0); }
		public TerminalNode ATRIB() { return getToken(ProjetoIParser.ATRIB, 0); }
		public TerminalNode TO() { return getToken(ProjetoIParser.TO, 0); }
		public LoopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loops; }
	}

	public final LoopsContext loops() throws RecognitionException {
		LoopsContext _localctx = new LoopsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loops);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(WHILE);
				setState(124);
				expr();
				setState(125);
				match(DO);
				setState(126);
				matchedCmd();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(FOR);
				setState(129);
				match(ID);
				setState(130);
				match(ATRIB);
				setState(131);
				expr();
				setState(132);
				match(TO);
				setState(133);
				expr();
				setState(134);
				match(DO);
				setState(135);
				matchedCmd();
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
	public static class LoopsUnmatchedContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ProjetoIParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DO() { return getToken(ProjetoIParser.DO, 0); }
		public UnmatchedCmdContext unmatchedCmd() {
			return getRuleContext(UnmatchedCmdContext.class,0);
		}
		public TerminalNode FOR() { return getToken(ProjetoIParser.FOR, 0); }
		public TerminalNode ID() { return getToken(ProjetoIParser.ID, 0); }
		public TerminalNode ATRIB() { return getToken(ProjetoIParser.ATRIB, 0); }
		public TerminalNode TO() { return getToken(ProjetoIParser.TO, 0); }
		public LoopsUnmatchedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopsUnmatched; }
	}

	public final LoopsUnmatchedContext loopsUnmatched() throws RecognitionException {
		LoopsUnmatchedContext _localctx = new LoopsUnmatchedContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loopsUnmatched);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(WHILE);
				setState(140);
				expr();
				setState(141);
				match(DO);
				setState(142);
				unmatchedCmd();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(FOR);
				setState(145);
				match(ID);
				setState(146);
				match(ATRIB);
				setState(147);
				expr();
				setState(148);
				match(TO);
				setState(149);
				expr();
				setState(150);
				match(DO);
				setState(151);
				unmatchedCmd();
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
	public static class CmdsimpleContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ProjetoIParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(ProjetoIParser.THEN, 0); }
		public List<MatchedCmdContext> matchedCmd() {
			return getRuleContexts(MatchedCmdContext.class);
		}
		public MatchedCmdContext matchedCmd(int i) {
			return getRuleContext(MatchedCmdContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ProjetoIParser.ELSE, 0); }
		public LoopsContext loops() {
			return getRuleContext(LoopsContext.class,0);
		}
		public CmdsimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdsimple; }
	}

	public final CmdsimpleContext cmdsimple() throws RecognitionException {
		CmdsimpleContext _localctx = new CmdsimpleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdsimple);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(IF);
				setState(156);
				expr();
				setState(157);
				match(THEN);
				setState(158);
				matchedCmd();
				setState(159);
				match(ELSE);
				setState(160);
				matchedCmd();
				}
				break;
			case WHILE:
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				loops();
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
	public static class UnmatchedCmdContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ProjetoIParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(ProjetoIParser.THEN, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public MatchedCmdContext matchedCmd() {
			return getRuleContext(MatchedCmdContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ProjetoIParser.ELSE, 0); }
		public UnmatchedCmdContext unmatchedCmd() {
			return getRuleContext(UnmatchedCmdContext.class,0);
		}
		public LoopsUnmatchedContext loopsUnmatched() {
			return getRuleContext(LoopsUnmatchedContext.class,0);
		}
		public UnmatchedCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unmatchedCmd; }
	}

	public final UnmatchedCmdContext unmatchedCmd() throws RecognitionException {
		UnmatchedCmdContext _localctx = new UnmatchedCmdContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unmatchedCmd);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(IF);
				setState(166);
				expr();
				setState(167);
				match(THEN);
				setState(168);
				cmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(IF);
				setState(171);
				expr();
				setState(172);
				match(THEN);
				setState(173);
				matchedCmd();
				setState(174);
				match(ELSE);
				setState(175);
				unmatchedCmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				loopsUnmatched();
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
	public static class MatchedCmdContext extends ParserRuleContext {
		public OtherCmdContext otherCmd() {
			return getRuleContext(OtherCmdContext.class,0);
		}
		public CmdsimpleContext cmdsimple() {
			return getRuleContext(CmdsimpleContext.class,0);
		}
		public MatchedCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchedCmd; }
	}

	public final MatchedCmdContext matchedCmd() throws RecognitionException {
		MatchedCmdContext _localctx = new MatchedCmdContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_matchedCmd);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
			case WRITE:
			case ABCHAVE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				otherCmd();
				}
				break;
			case WHILE:
			case FOR:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				cmdsimple();
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
	public static class OtherCmdContext extends ParserRuleContext {
		public CmdBaseContext cmdBase() {
			return getRuleContext(CmdBaseContext.class,0);
		}
		public CmdBextraContext cmdBextra() {
			return getRuleContext(CmdBextraContext.class,0);
		}
		public OtherCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherCmd; }
	}

	public final OtherCmdContext otherCmd() throws RecognitionException {
		OtherCmdContext _localctx = new OtherCmdContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_otherCmd);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABCHAVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				cmdBase();
				}
				break;
			case READ:
			case WRITE:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				cmdBextra();
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
	public static class CmdBextraContext extends ParserRuleContext {
		public CmdBaddContext cmdBadd() {
			return getRuleContext(CmdBaddContext.class,0);
		}
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdBextraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdBextra; }
	}

	public final CmdBextraContext cmdBextra() throws RecognitionException {
		CmdBextraContext _localctx = new CmdBextraContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cmdBextra);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				cmdBadd();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				cmdRead();
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
	public static class CmdBaddContext extends ParserRuleContext {
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAtribContext cmdAtrib() {
			return getRuleContext(CmdAtribContext.class,0);
		}
		public CmdBaddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdBadd; }
	}

	public final CmdBaddContext cmdBadd() throws RecognitionException {
		CmdBaddContext _localctx = new CmdBaddContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_cmdBadd);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				cmdWrite();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
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
		public TerminalNode READ() { return getToken(ProjetoIParser.READ, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoIParser.ABPAR, 0); }
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoIParser.FPAR, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(READ);
			setState(197);
			match(ABPAR);
			setState(198);
			listId();
			setState(199);
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
		public TerminalNode WRITE() { return getToken(ProjetoIParser.WRITE, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoIParser.ABPAR, 0); }
		public ListWContext listW() {
			return getRuleContext(ListWContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoIParser.FPAR, 0); }
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(WRITE);
			setState(202);
			match(ABPAR);
			setState(203);
			listW();
			setState(204);
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
		public List<TerminalNode> VIG() { return getTokens(ProjetoIParser.VIG); }
		public TerminalNode VIG(int i) {
			return getToken(ProjetoIParser.VIG, i);
		}
		public ListWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listW; }
	}

	public final ListWContext listW() throws RecognitionException {
		ListWContext _localctx = new ListWContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_listW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			elemW();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIG) {
				{
				{
				setState(207);
				match(VIG);
				setState(208);
				elemW();
				}
				}
				setState(213);
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
		public TerminalNode CADEIA() { return getToken(ProjetoIParser.CADEIA, 0); }
		public ElemWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemW; }
	}

	public final ElemWContext elemW() throws RecognitionException {
		ElemWContext _localctx = new ElemWContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elemW);
		try {
			setState(216);
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
				setState(214);
				expr();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
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
		public TerminalNode ID() { return getToken(ProjetoIParser.ID, 0); }
		public TerminalNode ATRIB() { return getToken(ProjetoIParser.ATRIB, 0); }
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
		enterRule(_localctx, 44, RULE_cmdAtrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(ID);
			setState(219);
			match(ATRIB);
			setState(220);
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
		enterRule(_localctx, 46, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
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
		public List<TerminalNode> OR() { return getTokens(ProjetoIParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ProjetoIParser.OR, i);
		}
		public ExprOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOr; }
	}

	public final ExprOrContext exprOr() throws RecognitionException {
		ExprOrContext _localctx = new ExprOrContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exprOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			exprAnd();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(225);
				match(OR);
				setState(226);
				exprAnd();
				}
				}
				setState(231);
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
		public List<TerminalNode> AND() { return getTokens(ProjetoIParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ProjetoIParser.AND, i);
		}
		public ExprAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAnd; }
	}

	public final ExprAndContext exprAnd() throws RecognitionException {
		ExprAndContext _localctx = new ExprAndContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_exprAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			exprRel();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(233);
				match(AND);
				setState(234);
				exprRel();
				}
				}
				setState(239);
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
		public TerminalNode OPREL() { return getToken(ProjetoIParser.OPREL, 0); }
		public TerminalNode OPMOE() { return getToken(ProjetoIParser.OPMOE, 0); }
		public TerminalNode OPDIF() { return getToken(ProjetoIParser.OPDIF, 0); }
		public TerminalNode OPEQ() { return getToken(ProjetoIParser.OPEQ, 0); }
		public ExprRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRel; }
	}

	public final ExprRelContext exprRel() throws RecognitionException {
		ExprRelContext _localctx = new ExprRelContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_exprRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			exprAdd();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) {
				{
				setState(241);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(242);
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
		public List<TerminalNode> OPAD() { return getTokens(ProjetoIParser.OPAD); }
		public TerminalNode OPAD(int i) {
			return getToken(ProjetoIParser.OPAD, i);
		}
		public ExprAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAdd; }
	}

	public final ExprAddContext exprAdd() throws RecognitionException {
		ExprAddContext _localctx = new ExprAddContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exprAdd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			exprSub();
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPAD) {
				{
				{
				setState(246);
				match(OPAD);
				setState(247);
				exprSub();
				}
				}
				setState(252);
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
		public List<TerminalNode> OPSUB() { return getTokens(ProjetoIParser.OPSUB); }
		public TerminalNode OPSUB(int i) {
			return getToken(ProjetoIParser.OPSUB, i);
		}
		public ExprSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSub; }
	}

	public final ExprSubContext exprSub() throws RecognitionException {
		ExprSubContext _localctx = new ExprSubContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_exprSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			exprMul();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPSUB) {
				{
				{
				setState(254);
				match(OPSUB);
				setState(255);
				exprMul();
				}
				}
				setState(260);
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
		public List<TerminalNode> OPMULT() { return getTokens(ProjetoIParser.OPMULT); }
		public TerminalNode OPMULT(int i) {
			return getToken(ProjetoIParser.OPMULT, i);
		}
		public ExprMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprMul; }
	}

	public final ExprMulContext exprMul() throws RecognitionException {
		ExprMulContext _localctx = new ExprMulContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_exprMul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			exprDiv();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPMULT) {
				{
				{
				setState(262);
				match(OPMULT);
				setState(263);
				exprDiv();
				}
				}
				setState(268);
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
		public List<TerminalNode> OPDI() { return getTokens(ProjetoIParser.OPDI); }
		public TerminalNode OPDI(int i) {
			return getToken(ProjetoIParser.OPDI, i);
		}
		public ExprDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprDiv; }
	}

	public final ExprDivContext exprDiv() throws RecognitionException {
		ExprDivContext _localctx = new ExprDivContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_exprDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			exprUnary();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPDI) {
				{
				{
				setState(270);
				match(OPDI);
				setState(271);
				exprUnary();
				}
				}
				setState(276);
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
		public TerminalNode OPNEG() { return getToken(ProjetoIParser.OPNEG, 0); }
		public TerminalNode OPAD() { return getToken(ProjetoIParser.OPAD, 0); }
		public TerminalNode OPSUB() { return getToken(ProjetoIParser.OPSUB, 0); }
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
		enterRule(_localctx, 62, RULE_exprUnary);
		int _la;
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAD:
			case OPSUB:
			case OPNEG:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 637534208L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(278);
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
				setState(279);
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
		public TerminalNode ID() { return getToken(ProjetoIParser.ID, 0); }
		public TerminalNode CTE() { return getToken(ProjetoIParser.CTE, 0); }
		public TerminalNode TRUE() { return getToken(ProjetoIParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ProjetoIParser.FALSE, 0); }
		public TerminalNode ABPAR() { return getToken(ProjetoIParser.ABPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ProjetoIParser.FPAR, 0); }
		public ExprPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprPrimary; }
	}

	public final ExprPrimaryContext exprPrimary() throws RecognitionException {
		ExprPrimaryContext _localctx = new ExprPrimaryContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exprPrimary);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				match(ID);
				}
				break;
			case CTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				match(CTE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(285);
				match(FALSE);
				}
				break;
			case ABPAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(286);
				match(ABPAR);
				setState(287);
				expr();
				setState(288);
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
		"\u0004\u0001,\u0125\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0002\u0004\u0002"+
		"Q\b\u0002\u000b\u0002\f\u0002R\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004]\b"+
		"\u0004\n\u0004\f\u0004`\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0003\u0006f\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0003\u0007l\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0005\bs\b\b\n\b\f\bv\t\b\u0001\t\u0001\t\u0003\tz\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u008a\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u009a\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00a4\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00b3"+
		"\b\r\u0001\u000e\u0001\u000e\u0003\u000e\u00b7\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00bb\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00bf"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00c3\b\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u00d2\b\u0014\n\u0014\f\u0014\u00d5\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00d9\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u00e4\b\u0018\n\u0018\f\u0018\u00e7\t\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u00ec\b\u0019\n\u0019\f\u0019\u00ef\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00f4\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u00f9\b\u001b\n\u001b\f\u001b\u00fc\t\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0101\b\u001c\n\u001c"+
		"\f\u001c\u0104\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u0109\b\u001d\n\u001d\f\u001d\u010c\t\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0005\u001e\u0111\b\u001e\n\u001e\f\u001e\u0114\t\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u0119\b\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0123\b \u0001 \u0000\u0000"+
		"!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@\u0000\u0003\u0001\u0000\u0002\u0004\u0001"+
		"\u0000\u0015\u0018\u0002\u0000\u0019\u001a\u001d\u001d\u0121\u0000B\u0001"+
		"\u0000\u0000\u0000\u0002M\u0001\u0000\u0000\u0000\u0004P\u0001\u0000\u0000"+
		"\u0000\u0006T\u0001\u0000\u0000\u0000\bY\u0001\u0000\u0000\u0000\na\u0001"+
		"\u0000\u0000\u0000\fc\u0001\u0000\u0000\u0000\u000ei\u0001\u0000\u0000"+
		"\u0000\u0010o\u0001\u0000\u0000\u0000\u0012y\u0001\u0000\u0000\u0000\u0014"+
		"\u0089\u0001\u0000\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000\u0018"+
		"\u00a3\u0001\u0000\u0000\u0000\u001a\u00b2\u0001\u0000\u0000\u0000\u001c"+
		"\u00b6\u0001\u0000\u0000\u0000\u001e\u00ba\u0001\u0000\u0000\u0000 \u00be"+
		"\u0001\u0000\u0000\u0000\"\u00c2\u0001\u0000\u0000\u0000$\u00c4\u0001"+
		"\u0000\u0000\u0000&\u00c9\u0001\u0000\u0000\u0000(\u00ce\u0001\u0000\u0000"+
		"\u0000*\u00d8\u0001\u0000\u0000\u0000,\u00da\u0001\u0000\u0000\u0000."+
		"\u00de\u0001\u0000\u0000\u00000\u00e0\u0001\u0000\u0000\u00002\u00e8\u0001"+
		"\u0000\u0000\u00004\u00f0\u0001\u0000\u0000\u00006\u00f5\u0001\u0000\u0000"+
		"\u00008\u00fd\u0001\u0000\u0000\u0000:\u0105\u0001\u0000\u0000\u0000<"+
		"\u010d\u0001\u0000\u0000\u0000>\u0118\u0001\u0000\u0000\u0000@\u0122\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0001\u0000\u0000CD\u0005)\u0000\u0000DE\u0005"+
		"\u001f\u0000\u0000EF\u0003\u0002\u0001\u0000FG\u0003\f\u0006\u0000GH\u0005"+
		" \u0000\u0000HI\u0005\u0000\u0000\u0001I\u0001\u0001\u0000\u0000\u0000"+
		"JK\u0005\f\u0000\u0000KN\u0003\u0004\u0002\u0000LN\u0001\u0000\u0000\u0000"+
		"MJ\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000N\u0003\u0001\u0000"+
		"\u0000\u0000OQ\u0003\u0006\u0003\u0000PO\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"S\u0005\u0001\u0000\u0000\u0000TU\u0003\b\u0004\u0000UV\u0005!\u0000\u0000"+
		"VW\u0003\n\u0005\u0000WX\u0005\u001f\u0000\u0000X\u0007\u0001\u0000\u0000"+
		"\u0000Y^\u0005)\u0000\u0000Z[\u0005\"\u0000\u0000[]\u0005)\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_\t\u0001\u0000\u0000\u0000`^\u0001\u0000"+
		"\u0000\u0000ab\u0007\u0000\u0000\u0000b\u000b\u0001\u0000\u0000\u0000"+
		"ce\u0005\u0005\u0000\u0000df\u0003\u0010\b\u0000ed\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0005\u0006\u0000"+
		"\u0000h\r\u0001\u0000\u0000\u0000ik\u0005%\u0000\u0000jl\u0003\u0010\b"+
		"\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0005&\u0000\u0000n\u000f\u0001\u0000\u0000\u0000ot\u0003"+
		"\u0012\t\u0000pq\u0005\u001f\u0000\u0000qs\u0003\u0012\t\u0000rp\u0001"+
		"\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u\u0011\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000wz\u0003\u001c\u000e\u0000xz\u0003\u001a\r\u0000yw\u0001\u0000"+
		"\u0000\u0000yx\u0001\u0000\u0000\u0000z\u0013\u0001\u0000\u0000\u0000"+
		"{|\u0005\u0007\u0000\u0000|}\u0003.\u0017\u0000}~\u0005\n\u0000\u0000"+
		"~\u007f\u0003\u001c\u000e\u0000\u007f\u008a\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005\b\u0000\u0000\u0081\u0082\u0005)\u0000\u0000\u0082\u0083"+
		"\u0005\u001e\u0000\u0000\u0083\u0084\u0003.\u0017\u0000\u0084\u0085\u0005"+
		"\t\u0000\u0000\u0085\u0086\u0003.\u0017\u0000\u0086\u0087\u0005\n\u0000"+
		"\u0000\u0087\u0088\u0003\u001c\u000e\u0000\u0088\u008a\u0001\u0000\u0000"+
		"\u0000\u0089{\u0001\u0000\u0000\u0000\u0089\u0080\u0001\u0000\u0000\u0000"+
		"\u008a\u0015\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0007\u0000\u0000"+
		"\u008c\u008d\u0003.\u0017\u0000\u008d\u008e\u0005\n\u0000\u0000\u008e"+
		"\u008f\u0003\u001a\r\u0000\u008f\u009a\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005\b\u0000\u0000\u0091\u0092\u0005)\u0000\u0000\u0092\u0093\u0005"+
		"\u001e\u0000\u0000\u0093\u0094\u0003.\u0017\u0000\u0094\u0095\u0005\t"+
		"\u0000\u0000\u0095\u0096\u0003.\u0017\u0000\u0096\u0097\u0005\n\u0000"+
		"\u0000\u0097\u0098\u0003\u001a\r\u0000\u0098\u009a\u0001\u0000\u0000\u0000"+
		"\u0099\u008b\u0001\u0000\u0000\u0000\u0099\u0090\u0001\u0000\u0000\u0000"+
		"\u009a\u0017\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0010\u0000\u0000"+
		"\u009c\u009d\u0003.\u0017\u0000\u009d\u009e\u0005\u0011\u0000\u0000\u009e"+
		"\u009f\u0003\u001c\u000e\u0000\u009f\u00a0\u0005\u0012\u0000\u0000\u00a0"+
		"\u00a1\u0003\u001c\u000e\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a4\u0003\u0014\n\u0000\u00a3\u009b\u0001\u0000\u0000\u0000\u00a3\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a4\u0019\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0005\u0010\u0000\u0000\u00a6\u00a7\u0003.\u0017\u0000\u00a7\u00a8\u0005"+
		"\u0011\u0000\u0000\u00a8\u00a9\u0003\u0012\t\u0000\u00a9\u00b3\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005\u0010\u0000\u0000\u00ab\u00ac\u0003.\u0017"+
		"\u0000\u00ac\u00ad\u0005\u0011\u0000\u0000\u00ad\u00ae\u0003\u001c\u000e"+
		"\u0000\u00ae\u00af\u0005\u0012\u0000\u0000\u00af\u00b0\u0003\u001a\r\u0000"+
		"\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00b3\u0003\u0016\u000b\u0000"+
		"\u00b2\u00a5\u0001\u0000\u0000\u0000\u00b2\u00aa\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u001b\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b7\u0003\u001e\u000f\u0000\u00b5\u00b7\u0003\u0018\f\u0000\u00b6"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7"+
		"\u001d\u0001\u0000\u0000\u0000\u00b8\u00bb\u0003\u000e\u0007\u0000\u00b9"+
		"\u00bb\u0003 \u0010\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u001f\u0001\u0000\u0000\u0000\u00bc\u00bf"+
		"\u0003\"\u0011\u0000\u00bd\u00bf\u0003$\u0012\u0000\u00be\u00bc\u0001"+
		"\u0000\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf!\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c3\u0003&\u0013\u0000\u00c1\u00c3\u0003,\u0016\u0000"+
		"\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c3#\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u000b\u0000\u0000\u00c5"+
		"\u00c6\u0005#\u0000\u0000\u00c6\u00c7\u0003\b\u0004\u0000\u00c7\u00c8"+
		"\u0005$\u0000\u0000\u00c8%\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u000f"+
		"\u0000\u0000\u00ca\u00cb\u0005#\u0000\u0000\u00cb\u00cc\u0003(\u0014\u0000"+
		"\u00cc\u00cd\u0005$\u0000\u0000\u00cd\'\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d3\u0003*\u0015\u0000\u00cf\u00d0\u0005\"\u0000\u0000\u00d0\u00d2"+
		"\u0003*\u0015\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4)\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d9\u0003.\u0017\u0000\u00d7\u00d9\u0005(\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d9+\u0001\u0000\u0000\u0000\u00da\u00db\u0005)\u0000\u0000\u00db\u00dc"+
		"\u0005\u001e\u0000\u0000\u00dc\u00dd\u0003.\u0017\u0000\u00dd-\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u00030\u0018\u0000\u00df/\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e5\u00032\u0019\u0000\u00e1\u00e2\u0005\u0013\u0000\u0000\u00e2"+
		"\u00e4\u00032\u0019\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e61\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e8\u00ed\u00034\u001a\u0000\u00e9\u00ea\u0005\u0014"+
		"\u0000\u0000\u00ea\u00ec\u00034\u001a\u0000\u00eb\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee3\u0001\u0000\u0000\u0000"+
		"\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f3\u00036\u001b\u0000\u00f1"+
		"\u00f2\u0007\u0001\u0000\u0000\u00f2\u00f4\u00036\u001b\u0000\u00f3\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f45\u0001"+
		"\u0000\u0000\u0000\u00f5\u00fa\u00038\u001c\u0000\u00f6\u00f7\u0005\u0019"+
		"\u0000\u0000\u00f7\u00f9\u00038\u001c\u0000\u00f8\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb7\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u0102\u0003:\u001d\u0000\u00fe"+
		"\u00ff\u0005\u001a\u0000\u0000\u00ff\u0101\u0003:\u001d\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u01039\u0001"+
		"\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u010a\u0003"+
		"<\u001e\u0000\u0106\u0107\u0005\u001b\u0000\u0000\u0107\u0109\u0003<\u001e"+
		"\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000\u0000"+
		"\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000"+
		"\u0000\u010b;\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000"+
		"\u010d\u0112\u0003>\u001f\u0000\u010e\u010f\u0005\u001c\u0000\u0000\u010f"+
		"\u0111\u0003>\u001f\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0114"+
		"\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113=\u0001\u0000\u0000\u0000\u0114\u0112\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0007\u0002\u0000\u0000\u0116\u0119\u0003"+
		">\u001f\u0000\u0117\u0119\u0003@ \u0000\u0118\u0115\u0001\u0000\u0000"+
		"\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119?\u0001\u0000\u0000\u0000"+
		"\u011a\u0123\u0005)\u0000\u0000\u011b\u0123\u0005\'\u0000\u0000\u011c"+
		"\u0123\u0005\u000e\u0000\u0000\u011d\u0123\u0005\r\u0000\u0000\u011e\u011f"+
		"\u0005#\u0000\u0000\u011f\u0120\u0003.\u0017\u0000\u0120\u0121\u0005$"+
		"\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u011a\u0001\u0000"+
		"\u0000\u0000\u0122\u011b\u0001\u0000\u0000\u0000\u0122\u011c\u0001\u0000"+
		"\u0000\u0000\u0122\u011d\u0001\u0000\u0000\u0000\u0122\u011e\u0001\u0000"+
		"\u0000\u0000\u0123A\u0001\u0000\u0000\u0000\u001aMR^ekty\u0089\u0099\u00a3"+
		"\u00b2\u00b6\u00ba\u00be\u00c2\u00d3\u00d8\u00e5\u00ed\u00f3\u00fa\u0102"+
		"\u010a\u0112\u0118\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}