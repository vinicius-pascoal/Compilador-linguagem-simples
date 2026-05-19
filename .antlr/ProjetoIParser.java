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
		PROGRAM=1, INTEGER=2, BOOLEAN=3, STRING=4, BEGIN=5, END=6, WHILE=7, DO=8, 
		READ=9, VAR=10, FALSE=11, TRUE=12, WRITE=13, IF=14, THEN=15, ELSE=16, 
		OR=17, AND=18, OPREL=19, OPMOE=20, OPDIF=21, OPEQ=22, OPAD=23, OPSUB=24, 
		OPMULT=25, OPDI=26, OPNEG=27, ATRIB=28, PVIG=29, PONTO=30, DPONTOS=31, 
		VIG=32, ABPAR=33, FPAR=34, CTE=35, CADEIA=36, ID=37, COMMENT=38, WS=39;
	public static final int
		RULE_prog = 0, RULE_decls = 1, RULE_listDecl = 2, RULE_declTip = 3, RULE_listId = 4, 
		RULE_tip = 5, RULE_cmdComp = 6, RULE_listCmd = 7, RULE_cmd = 8, RULE_matchedCmd = 9, 
		RULE_unmatchedCmd = 10, RULE_otherCmd = 11, RULE_cmdRead = 12, RULE_cmdWrite = 13, 
		RULE_listW = 14, RULE_elemW = 15, RULE_cmdAtrib = 16, RULE_expr = 17, 
		RULE_exprOr = 18, RULE_exprAnd = 19, RULE_exprRel = 20, RULE_exprAdd = 21, 
		RULE_exprSub = 22, RULE_exprMul = 23, RULE_exprDiv = 24, RULE_exprUnary = 25, 
		RULE_exprPrimary = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decls", "listDecl", "declTip", "listId", "tip", "cmdComp", "listCmd", 
			"cmd", "matchedCmd", "unmatchedCmd", "otherCmd", "cmdRead", "cmdWrite", 
			"listW", "elemW", "cmdAtrib", "expr", "exprOr", "exprAnd", "exprRel", 
			"exprAdd", "exprSub", "exprMul", "exprDiv", "exprUnary", "exprPrimary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "'<>'", "'=='", 
			"'+'", "'-'", "'*'", "'/'", "'~'", "'='", "';'", "'.'", "':'", "','", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "INTEGER", "BOOLEAN", "STRING", "BEGIN", "END", "WHILE", 
			"DO", "READ", "VAR", "FALSE", "TRUE", "WRITE", "IF", "THEN", "ELSE", 
			"OR", "AND", "OPREL", "OPMOE", "OPDIF", "OPEQ", "OPAD", "OPSUB", "OPMULT", 
			"OPDI", "OPNEG", "ATRIB", "PVIG", "PONTO", "DPONTOS", "VIG", "ABPAR", 
			"FPAR", "CTE", "CADEIA", "ID", "COMMENT", "WS"
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
			setState(54);
			match(PROGRAM);
			setState(55);
			match(ID);
			setState(56);
			match(PVIG);
			setState(57);
			decls();
			setState(58);
			cmdComp();
			setState(59);
			match(PONTO);
			setState(60);
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
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(VAR);
				setState(63);
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
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				declTip();
				}
				}
				setState(70); 
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
			setState(72);
			listId();
			setState(73);
			match(DPONTOS);
			setState(74);
			tip();
			setState(75);
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
			setState(77);
			match(ID);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIG) {
				{
				{
				setState(78);
				match(VIG);
				setState(79);
				match(ID);
				}
				}
				setState(84);
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
			setState(85);
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
			setState(87);
			match(BEGIN);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137438978720L) != 0)) {
				{
				setState(88);
				listCmd();
				}
			}

			setState(91);
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
		enterRule(_localctx, 14, RULE_listCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			cmd();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PVIG) {
				{
				{
				setState(94);
				match(PVIG);
				setState(95);
				cmd();
				}
				}
				setState(100);
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
		enterRule(_localctx, 16, RULE_cmd);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				matchedCmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
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
	public static class MatchedCmdContext extends ParserRuleContext {
		public OtherCmdContext otherCmd() {
			return getRuleContext(OtherCmdContext.class,0);
		}
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
		public TerminalNode WHILE() { return getToken(ProjetoIParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(ProjetoIParser.DO, 0); }
		public MatchedCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchedCmd; }
	}

	public final MatchedCmdContext matchedCmd() throws RecognitionException {
		MatchedCmdContext _localctx = new MatchedCmdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_matchedCmd);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
			case READ:
			case WRITE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				otherCmd();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(IF);
				setState(107);
				expr();
				setState(108);
				match(THEN);
				setState(109);
				matchedCmd();
				setState(110);
				match(ELSE);
				setState(111);
				matchedCmd();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(WHILE);
				setState(114);
				expr();
				setState(115);
				match(DO);
				setState(116);
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
		public TerminalNode WHILE() { return getToken(ProjetoIParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(ProjetoIParser.DO, 0); }
		public UnmatchedCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unmatchedCmd; }
	}

	public final UnmatchedCmdContext unmatchedCmd() throws RecognitionException {
		UnmatchedCmdContext _localctx = new UnmatchedCmdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unmatchedCmd);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(IF);
				setState(121);
				expr();
				setState(122);
				match(THEN);
				setState(123);
				cmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(IF);
				setState(126);
				expr();
				setState(127);
				match(THEN);
				setState(128);
				matchedCmd();
				setState(129);
				match(ELSE);
				setState(130);
				unmatchedCmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(WHILE);
				setState(133);
				expr();
				setState(134);
				match(DO);
				setState(135);
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
	public static class OtherCmdContext extends ParserRuleContext {
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAtribContext cmdAtrib() {
			return getRuleContext(CmdAtribContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public OtherCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherCmd; }
	}

	public final OtherCmdContext otherCmd() throws RecognitionException {
		OtherCmdContext _localctx = new OtherCmdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_otherCmd);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				cmdRead();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				cmdWrite();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				cmdAtrib();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				cmdComp();
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
		enterRule(_localctx, 24, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(READ);
			setState(146);
			match(ABPAR);
			setState(147);
			listId();
			setState(148);
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
		enterRule(_localctx, 26, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(WRITE);
			setState(151);
			match(ABPAR);
			setState(152);
			listW();
			setState(153);
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
		enterRule(_localctx, 28, RULE_listW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			elemW();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIG) {
				{
				{
				setState(156);
				match(VIG);
				setState(157);
				elemW();
				}
				}
				setState(162);
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
		enterRule(_localctx, 30, RULE_elemW);
		try {
			setState(165);
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
				setState(163);
				expr();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
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
		enterRule(_localctx, 32, RULE_cmdAtrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(ID);
			setState(168);
			match(ATRIB);
			setState(169);
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
		enterRule(_localctx, 34, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
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
		enterRule(_localctx, 36, RULE_exprOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			exprAnd();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(174);
				match(OR);
				setState(175);
				exprAnd();
				}
				}
				setState(180);
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
		enterRule(_localctx, 38, RULE_exprAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			exprRel();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(182);
				match(AND);
				setState(183);
				exprRel();
				}
				}
				setState(188);
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
		enterRule(_localctx, 40, RULE_exprRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			exprAdd();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) {
				{
				setState(190);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
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
		enterRule(_localctx, 42, RULE_exprAdd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			exprSub();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPAD) {
				{
				{
				setState(195);
				match(OPAD);
				setState(196);
				exprSub();
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
		enterRule(_localctx, 44, RULE_exprSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			exprMul();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPSUB) {
				{
				{
				setState(203);
				match(OPSUB);
				setState(204);
				exprMul();
				}
				}
				setState(209);
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
		enterRule(_localctx, 46, RULE_exprMul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			exprDiv();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPMULT) {
				{
				{
				setState(211);
				match(OPMULT);
				setState(212);
				exprDiv();
				}
				}
				setState(217);
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
		enterRule(_localctx, 48, RULE_exprDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			exprUnary();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPDI) {
				{
				{
				setState(219);
				match(OPDI);
				setState(220);
				exprUnary();
				}
				}
				setState(225);
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
		public TerminalNode OPNEG() { return getToken(ProjetoIParser.OPNEG, 0); }
		public ExprUnaryContext exprUnary() {
			return getRuleContext(ExprUnaryContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_exprUnary);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPNEG:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(OPNEG);
				setState(227);
				exprUnary();
				}
				break;
			case OPAD:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(OPAD);
				setState(229);
				exprUnary();
				}
				break;
			case OPSUB:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				match(OPSUB);
				setState(231);
				exprUnary();
				}
				break;
			case FALSE:
			case TRUE:
			case ABPAR:
			case CTE:
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
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
		enterRule(_localctx, 52, RULE_exprPrimary);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(ID);
				}
				break;
			case CTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(CTE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				match(FALSE);
				}
				break;
			case ABPAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				match(ABPAR);
				setState(240);
				expr();
				setState(241);
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
		"\u0004\u0001\'\u00f6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001B\b\u0001\u0001\u0002"+
		"\u0004\u0002E\b\u0002\u000b\u0002\f\u0002F\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007a\b\u0007\n\u0007\f\u0007d\t"+
		"\u0007\u0001\b\u0001\b\u0003\bh\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\tw\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u008a\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0090\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u009f\b\u000e\n\u000e\f\u000e\u00a2\t\u000e\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00a6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00b1"+
		"\b\u0012\n\u0012\f\u0012\u00b4\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00b9\b\u0013\n\u0013\f\u0013\u00bc\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u00c1\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u00c6\b\u0015\n\u0015\f\u0015\u00c9\t\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u00ce\b\u0016\n\u0016\f\u0016\u00d1"+
		"\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u00d6\b\u0017"+
		"\n\u0017\f\u0017\u00d9\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u00de\b\u0018\n\u0018\f\u0018\u00e1\t\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u00ea\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00f4\b\u001a\u0001\u001a"+
		"\u0000\u0000\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0002\u0001\u0000\u0002"+
		"\u0004\u0001\u0000\u0013\u0016\u00f7\u00006\u0001\u0000\u0000\u0000\u0002"+
		"A\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006H\u0001"+
		"\u0000\u0000\u0000\bM\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000\u0000"+
		"\fW\u0001\u0000\u0000\u0000\u000e]\u0001\u0000\u0000\u0000\u0010g\u0001"+
		"\u0000\u0000\u0000\u0012v\u0001\u0000\u0000\u0000\u0014\u0089\u0001\u0000"+
		"\u0000\u0000\u0016\u008f\u0001\u0000\u0000\u0000\u0018\u0091\u0001\u0000"+
		"\u0000\u0000\u001a\u0096\u0001\u0000\u0000\u0000\u001c\u009b\u0001\u0000"+
		"\u0000\u0000\u001e\u00a5\u0001\u0000\u0000\u0000 \u00a7\u0001\u0000\u0000"+
		"\u0000\"\u00ab\u0001\u0000\u0000\u0000$\u00ad\u0001\u0000\u0000\u0000"+
		"&\u00b5\u0001\u0000\u0000\u0000(\u00bd\u0001\u0000\u0000\u0000*\u00c2"+
		"\u0001\u0000\u0000\u0000,\u00ca\u0001\u0000\u0000\u0000.\u00d2\u0001\u0000"+
		"\u0000\u00000\u00da\u0001\u0000\u0000\u00002\u00e9\u0001\u0000\u0000\u0000"+
		"4\u00f3\u0001\u0000\u0000\u000067\u0005\u0001\u0000\u000078\u0005%\u0000"+
		"\u000089\u0005\u001d\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0003\f\u0006"+
		"\u0000;<\u0005\u001e\u0000\u0000<=\u0005\u0000\u0000\u0001=\u0001\u0001"+
		"\u0000\u0000\u0000>?\u0005\n\u0000\u0000?B\u0003\u0004\u0002\u0000@B\u0001"+
		"\u0000\u0000\u0000A>\u0001\u0000\u0000\u0000A@\u0001\u0000\u0000\u0000"+
		"B\u0003\u0001\u0000\u0000\u0000CE\u0003\u0006\u0003\u0000DC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000G\u0005\u0001\u0000\u0000\u0000HI\u0003\b\u0004\u0000"+
		"IJ\u0005\u001f\u0000\u0000JK\u0003\n\u0005\u0000KL\u0005\u001d\u0000\u0000"+
		"L\u0007\u0001\u0000\u0000\u0000MR\u0005%\u0000\u0000NO\u0005 \u0000\u0000"+
		"OQ\u0005%\u0000\u0000PN\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\t\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000UV\u0007\u0000\u0000\u0000V\u000b\u0001"+
		"\u0000\u0000\u0000WY\u0005\u0005\u0000\u0000XZ\u0003\u000e\u0007\u0000"+
		"YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u0006\u0000\u0000\\\r\u0001\u0000\u0000\u0000]b\u0003"+
		"\u0010\b\u0000^_\u0005\u001d\u0000\u0000_a\u0003\u0010\b\u0000`^\u0001"+
		"\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u000f\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000eh\u0003\u0012\t\u0000fh\u0003\u0014\n\u0000ge\u0001\u0000"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000h\u0011\u0001\u0000\u0000\u0000"+
		"iw\u0003\u0016\u000b\u0000jk\u0005\u000e\u0000\u0000kl\u0003\"\u0011\u0000"+
		"lm\u0005\u000f\u0000\u0000mn\u0003\u0012\t\u0000no\u0005\u0010\u0000\u0000"+
		"op\u0003\u0012\t\u0000pw\u0001\u0000\u0000\u0000qr\u0005\u0007\u0000\u0000"+
		"rs\u0003\"\u0011\u0000st\u0005\b\u0000\u0000tu\u0003\u0012\t\u0000uw\u0001"+
		"\u0000\u0000\u0000vi\u0001\u0000\u0000\u0000vj\u0001\u0000\u0000\u0000"+
		"vq\u0001\u0000\u0000\u0000w\u0013\u0001\u0000\u0000\u0000xy\u0005\u000e"+
		"\u0000\u0000yz\u0003\"\u0011\u0000z{\u0005\u000f\u0000\u0000{|\u0003\u0010"+
		"\b\u0000|\u008a\u0001\u0000\u0000\u0000}~\u0005\u000e\u0000\u0000~\u007f"+
		"\u0003\"\u0011\u0000\u007f\u0080\u0005\u000f\u0000\u0000\u0080\u0081\u0003"+
		"\u0012\t\u0000\u0081\u0082\u0005\u0010\u0000\u0000\u0082\u0083\u0003\u0014"+
		"\n\u0000\u0083\u008a\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0007\u0000"+
		"\u0000\u0085\u0086\u0003\"\u0011\u0000\u0086\u0087\u0005\b\u0000\u0000"+
		"\u0087\u0088\u0003\u0014\n\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089"+
		"x\u0001\u0000\u0000\u0000\u0089}\u0001\u0000\u0000\u0000\u0089\u0084\u0001"+
		"\u0000\u0000\u0000\u008a\u0015\u0001\u0000\u0000\u0000\u008b\u0090\u0003"+
		"\u0018\f\u0000\u008c\u0090\u0003\u001a\r\u0000\u008d\u0090\u0003 \u0010"+
		"\u0000\u008e\u0090\u0003\f\u0006\u0000\u008f\u008b\u0001\u0000\u0000\u0000"+
		"\u008f\u008c\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0017\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005\t\u0000\u0000\u0092\u0093\u0005!\u0000\u0000\u0093"+
		"\u0094\u0003\b\u0004\u0000\u0094\u0095\u0005\"\u0000\u0000\u0095\u0019"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\r\u0000\u0000\u0097\u0098\u0005"+
		"!\u0000\u0000\u0098\u0099\u0003\u001c\u000e\u0000\u0099\u009a\u0005\""+
		"\u0000\u0000\u009a\u001b\u0001\u0000\u0000\u0000\u009b\u00a0\u0003\u001e"+
		"\u000f\u0000\u009c\u009d\u0005 \u0000\u0000\u009d\u009f\u0003\u001e\u000f"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u001d\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a6\u0003\"\u0011\u0000\u00a4\u00a6\u0005$\u0000\u0000"+
		"\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u001f\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005%\u0000\u0000\u00a8"+
		"\u00a9\u0005\u001c\u0000\u0000\u00a9\u00aa\u0003\"\u0011\u0000\u00aa!"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003$\u0012\u0000\u00ac#\u0001\u0000"+
		"\u0000\u0000\u00ad\u00b2\u0003&\u0013\u0000\u00ae\u00af\u0005\u0011\u0000"+
		"\u0000\u00af\u00b1\u0003&\u0013\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3%\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b5\u00ba\u0003(\u0014\u0000\u00b6\u00b7"+
		"\u0005\u0012\u0000\u0000\u00b7\u00b9\u0003(\u0014\u0000\u00b8\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\'\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c0\u0003*\u0015"+
		"\u0000\u00be\u00bf\u0007\u0001\u0000\u0000\u00bf\u00c1\u0003*\u0015\u0000"+
		"\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1)\u0001\u0000\u0000\u0000\u00c2\u00c7\u0003,\u0016\u0000\u00c3\u00c4"+
		"\u0005\u0017\u0000\u0000\u00c4\u00c6\u0003,\u0016\u0000\u00c5\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8+\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00cf\u0003.\u0017"+
		"\u0000\u00cb\u00cc\u0005\u0018\u0000\u0000\u00cc\u00ce\u0003.\u0017\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0-\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d7\u00030\u0018\u0000\u00d3\u00d4\u0005\u0019\u0000\u0000\u00d4\u00d6"+
		"\u00030\u0018\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8/\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00da\u00df\u00032\u0019\u0000\u00db\u00dc\u0005\u001a\u0000"+
		"\u0000\u00dc\u00de\u00032\u0019\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0001\u0000\u0000\u0000\u00e01\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u001b\u0000\u0000\u00e3"+
		"\u00ea\u00032\u0019\u0000\u00e4\u00e5\u0005\u0017\u0000\u0000\u00e5\u00ea"+
		"\u00032\u0019\u0000\u00e6\u00e7\u0005\u0018\u0000\u0000\u00e7\u00ea\u0003"+
		"2\u0019\u0000\u00e8\u00ea\u00034\u001a\u0000\u00e9\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e4\u0001\u0000\u0000\u0000\u00e9\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea3\u0001\u0000\u0000\u0000"+
		"\u00eb\u00f4\u0005%\u0000\u0000\u00ec\u00f4\u0005#\u0000\u0000\u00ed\u00f4"+
		"\u0005\f\u0000\u0000\u00ee\u00f4\u0005\u000b\u0000\u0000\u00ef\u00f0\u0005"+
		"!\u0000\u0000\u00f0\u00f1\u0003\"\u0011\u0000\u00f1\u00f2\u0005\"\u0000"+
		"\u0000\u00f2\u00f4\u0001\u0000\u0000\u0000\u00f3\u00eb\u0001\u0000\u0000"+
		"\u0000\u00f3\u00ec\u0001\u0000\u0000\u0000\u00f3\u00ed\u0001\u0000\u0000"+
		"\u0000\u00f3\u00ee\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f45\u0001\u0000\u0000\u0000\u0014AFRYbgv\u0089\u008f\u00a0\u00a5"+
		"\u00b2\u00ba\u00c0\u00c7\u00cf\u00d7\u00df\u00e9\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}