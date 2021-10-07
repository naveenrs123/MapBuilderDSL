// Generated from /Users/kaicycle/bike-boy-does-school/CS410/Project1Group8/ProjectFiles/src/parser/MapParser.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, MAP_SECTION_START=2, MAP_CREATE_START=3, MAP_OR_REGION_DIMENSIONS=4, 
		MAP_CREATE_COLOUR=5, MAP_SECTION_END=6, DEF_SECTION_START=7, DEF_SECTION_END=8, 
		FUNCTION_SIGNATURE_START=9, FUNCTION_PARAM_START=10, FUNCTION_PARAM_SEP=11, 
		FUNCTION_PARAM_END=12, DEFINE_FEATURE_START=13, DEFINE_FEATURE_ICON=14, 
		DEFINE_FEATURE_SIZE=15, PLACE_AND_CALL_START=16, PLACE_AND_CALL_END=17, 
		PLACE_FEATURE_START=18, FEATURE_OR_REGION_NAME=19, FEATURE_OR_REGION_LOCATION=20, 
		PLACE_FEATURE_ON=21, FEATURE_OR_REGION_DISPLAY=22, PLACE_REGION_START=23, 
		FUNCTION_CALL_START=24, FUNCITON_CALL_PARAM_END=25, TEXT=26, WS_TEXT=27, 
		OPENING_QUOTE=28, QUOTED_TEXT=29, CLOSING_QUOTE=30, NUM=31, WS_NUM=32, 
		WS_TUPLE=33, OPENING_BRACKET=34, TUPLE_TEXT=35, TUPLE_SEP=36, CLOSING_BRACKET=37, 
		COLOR_START=38, COLOR_CODE=39, COLOR_END=40, WS_COLOR=41, REGION=42, WS_REGION=43, 
		AREA_MAP=44, AREA_REGION=45, WS_AREA=46, WS_BOOLEAN=47, BOOLEAN_START=48, 
		BOOLEAN_TRUE=49, BOOLEAN_FALSE=50, WS_FUNCTION_STATEMENT=51, FUNCTION_STATEMENT_NUM=52, 
		SIGNATURE_END=53, FUNCTION_STATEMENT_END_OF_LINE=54, FUNCTION_SIGNATURE_END=55, 
		LOOP_START=56, LOOP_END=57, LOOP_TEXT_SEP=58, LOOP_FROM=59, LOOP_TO=60, 
		LOOP_INCREMENT=61, LOOP_DECREMENT=62, IF_SIGNATURE_START=63, IF_END=64, 
		ELSE_START=65, ELSE_END=66, PLACE_FEATURE_START_FROM_FUNC=67, FEATURE_OR_REGION_NAME_FROM_FUNC=68, 
		FEATURE_OR_REGION_LOCATION_FROM_FUNC=69, PLACE_FEATURE_ON_FROM_FUNC=70, 
		FEATURE_OR_REGION_DISPLAY_FROM_FUNC=71, PLACE_REGION_START_FROM_FUNC=72, 
		PLACE_REGION_DIMENSIONS=73, ASSIGNMENT_START=74, ASSIGNMENT_EQUALS=75, 
		WS_FUNCTION_STATEMENT_TEXT=76, FUNCTION_STATEMENT_TEXT_TEXT=77, FROM_FUNC_OPENING_QUOTE=78, 
		FROM_FUNC_QUOTED_TEXT=79, FROM_FUNC_CLOSING_QUOTE=80, WS_FROM_FUNC_TUPLE=81, 
		FROM_FUNC_OPENING_BRACKET=82, FROM_FUNC_TUPLE_TEXT=83, FROM_FUNC_TUPLE_SEP=84, 
		FROM_FUNC_CLOSING_BRACKET=85, WS_AREA_FROM_FUNC=86, AREA_FROM_FUNC_MAP=87, 
		AREA_FRM_FUNC_REGION=88, WS_BOOLEAN_FROM_FUNC=89, BOOLEAN_FROM_FUNC_START=90, 
		BOOLEAN_FROM_FUNC_TRUE=91, BOOLEAN_FROM_FUNC_FALSE=92, WS_PLACE_REGION_FROM_FUNC=93, 
		REGION_FROM_FUNC=94, WS_EXPRESSION=95, EXPRESSION_END=96, MATH_COMPARE_START=97, 
		MATH_COMPARE_COMPARISON_OP=98, QUOTE_COMPARE_START=99, MATH_START=100, 
		QUOTE_TEXT_START=101, EXPRESSION_TEXT=102, BOOLEAN_FROM_EXPRESSION_START=103, 
		WS_EXPRESSION_QUOTED_TEXT=104, EXPRESSION_OPENING_QUOTE=105, EXPRESSION_QUOTED_TEXT=106, 
		EXPRESSION_CLOSING_QUOTE=107, WS_MATH_FROM_EXPRESSION=108, MATH_FROM_EXPRESSION_START=109, 
		MATH_FROM_EXPRESSION_TEXT=110, MATH_FROM_EXPRESSION_OPERATORS=111, MATH_FROM_EXPRESSION_END=112, 
		WS_QUOTE_COMPARE_FROM_EXPRESSION=113, QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT=114, 
		QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE=115, WS_SECOND_QUOTE_COMPARE_FROM_EXPRESSION=116, 
		QUOTE_COMPARISON_OP_FROM_EXPRESSION=117, SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE=118, 
		SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT=119, SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE=120, 
		WS_BOOLEAN_FROM_EXPRESSION=121, BOOLEAN_FROM_EXPRESSION_TRUE=122, BOOLEAN_FROM_EXPRESSION_FALSE=123, 
		WS_COMPARISON=124, MATH_COMPARE_FROM_IF_START=125, MATH_COMPARE_FROM_IF_COMPARISON_OP=126, 
		QUOTE_COMPARE_FROM_IF_START=127, COMPARISON_FROM_IF_END=128, WS_MATH_FROM_IF=129, 
		MATH_FROM_IF_START=130, MATH_FROM_IF_TEXT=131, MATH_FROM_IF_OPERATORS=132, 
		MATH_FROM_IF_END=133, WS_QUOTE_COMPARE_FROM_IF=134, QUOTE_COMPARE_FROM_IF_QUOTED_TEXT=135, 
		QUOTE_COMPARE_FROM_IF_CLOSING_QUOTE=136, WS_SECOND_QUOTE_COMPARE_FROM_IF=137, 
		QUOTE_COMPARISON_OP_FROM_IF=138, SECOND_QUOTE_COMPARE_FROM_IF_OPENING_QUOTE=139, 
		SECOND_QUOTE_COMPARE_FROM_IF_QUOTED_TEXT=140, SECOND_QUOTE_COMPARE_FROM_IF_CLOSING_QUOTE=141;
	public static final int
		RULE_program = 0, RULE_map = 1, RULE_def = 2, RULE_place_and_call = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "map", "def", "place_and_call"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'#start map'", "'CREATE MAP'", null, "'WITH COLOR'", "'#end map'", 
			"'#start definitions'", "'#end definitions'", "'DEFINE FUNCTION'", "'('", 
			null, "'):'", "'DEFINE FEATURE'", "'WITH ICON'", "'WITH SIZE'", "'#start place and call'", 
			"'#end place and call'", null, null, null, null, null, null, "'CALL FUNCTION'", 
			"')'", null, null, null, null, null, null, null, null, null, null, null, 
			null, "'#'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'END FUNCTION;'", "'START LOOP'", 
			"'END LOOP'", null, "'FROM'", "'TO'", "'INCREMENT BY'", "'DECREMENT BY'", 
			"'$IF'", "'$END IF;'", "'$ELSE:'", "'$END ELSE;'", null, null, null, 
			null, null, null, null, "'%assign'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "MAP_SECTION_START", "MAP_CREATE_START", "MAP_OR_REGION_DIMENSIONS", 
			"MAP_CREATE_COLOUR", "MAP_SECTION_END", "DEF_SECTION_START", "DEF_SECTION_END", 
			"FUNCTION_SIGNATURE_START", "FUNCTION_PARAM_START", "FUNCTION_PARAM_SEP", 
			"FUNCTION_PARAM_END", "DEFINE_FEATURE_START", "DEFINE_FEATURE_ICON", 
			"DEFINE_FEATURE_SIZE", "PLACE_AND_CALL_START", "PLACE_AND_CALL_END", 
			"PLACE_FEATURE_START", "FEATURE_OR_REGION_NAME", "FEATURE_OR_REGION_LOCATION", 
			"PLACE_FEATURE_ON", "FEATURE_OR_REGION_DISPLAY", "PLACE_REGION_START", 
			"FUNCTION_CALL_START", "FUNCITON_CALL_PARAM_END", "TEXT", "WS_TEXT", 
			"OPENING_QUOTE", "QUOTED_TEXT", "CLOSING_QUOTE", "NUM", "WS_NUM", "WS_TUPLE", 
			"OPENING_BRACKET", "TUPLE_TEXT", "TUPLE_SEP", "CLOSING_BRACKET", "COLOR_START", 
			"COLOR_CODE", "COLOR_END", "WS_COLOR", "REGION", "WS_REGION", "AREA_MAP", 
			"AREA_REGION", "WS_AREA", "WS_BOOLEAN", "BOOLEAN_START", "BOOLEAN_TRUE", 
			"BOOLEAN_FALSE", "WS_FUNCTION_STATEMENT", "FUNCTION_STATEMENT_NUM", "SIGNATURE_END", 
			"FUNCTION_STATEMENT_END_OF_LINE", "FUNCTION_SIGNATURE_END", "LOOP_START", 
			"LOOP_END", "LOOP_TEXT_SEP", "LOOP_FROM", "LOOP_TO", "LOOP_INCREMENT", 
			"LOOP_DECREMENT", "IF_SIGNATURE_START", "IF_END", "ELSE_START", "ELSE_END", 
			"PLACE_FEATURE_START_FROM_FUNC", "FEATURE_OR_REGION_NAME_FROM_FUNC", 
			"FEATURE_OR_REGION_LOCATION_FROM_FUNC", "PLACE_FEATURE_ON_FROM_FUNC", 
			"FEATURE_OR_REGION_DISPLAY_FROM_FUNC", "PLACE_REGION_START_FROM_FUNC", 
			"PLACE_REGION_DIMENSIONS", "ASSIGNMENT_START", "ASSIGNMENT_EQUALS", "WS_FUNCTION_STATEMENT_TEXT", 
			"FUNCTION_STATEMENT_TEXT_TEXT", "FROM_FUNC_OPENING_QUOTE", "FROM_FUNC_QUOTED_TEXT", 
			"FROM_FUNC_CLOSING_QUOTE", "WS_FROM_FUNC_TUPLE", "FROM_FUNC_OPENING_BRACKET", 
			"FROM_FUNC_TUPLE_TEXT", "FROM_FUNC_TUPLE_SEP", "FROM_FUNC_CLOSING_BRACKET", 
			"WS_AREA_FROM_FUNC", "AREA_FROM_FUNC_MAP", "AREA_FRM_FUNC_REGION", "WS_BOOLEAN_FROM_FUNC", 
			"BOOLEAN_FROM_FUNC_START", "BOOLEAN_FROM_FUNC_TRUE", "BOOLEAN_FROM_FUNC_FALSE", 
			"WS_PLACE_REGION_FROM_FUNC", "REGION_FROM_FUNC", "WS_EXPRESSION", "EXPRESSION_END", 
			"MATH_COMPARE_START", "MATH_COMPARE_COMPARISON_OP", "QUOTE_COMPARE_START", 
			"MATH_START", "QUOTE_TEXT_START", "EXPRESSION_TEXT", "BOOLEAN_FROM_EXPRESSION_START", 
			"WS_EXPRESSION_QUOTED_TEXT", "EXPRESSION_OPENING_QUOTE", "EXPRESSION_QUOTED_TEXT", 
			"EXPRESSION_CLOSING_QUOTE", "WS_MATH_FROM_EXPRESSION", "MATH_FROM_EXPRESSION_START", 
			"MATH_FROM_EXPRESSION_TEXT", "MATH_FROM_EXPRESSION_OPERATORS", "MATH_FROM_EXPRESSION_END", 
			"WS_QUOTE_COMPARE_FROM_EXPRESSION", "QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT", 
			"QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE", "WS_SECOND_QUOTE_COMPARE_FROM_EXPRESSION", 
			"QUOTE_COMPARISON_OP_FROM_EXPRESSION", "SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE", 
			"SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT", "SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE", 
			"WS_BOOLEAN_FROM_EXPRESSION", "BOOLEAN_FROM_EXPRESSION_TRUE", "BOOLEAN_FROM_EXPRESSION_FALSE", 
			"WS_COMPARISON", "MATH_COMPARE_FROM_IF_START", "MATH_COMPARE_FROM_IF_COMPARISON_OP", 
			"QUOTE_COMPARE_FROM_IF_START", "COMPARISON_FROM_IF_END", "WS_MATH_FROM_IF", 
			"MATH_FROM_IF_START", "MATH_FROM_IF_TEXT", "MATH_FROM_IF_OPERATORS", 
			"MATH_FROM_IF_END", "WS_QUOTE_COMPARE_FROM_IF", "QUOTE_COMPARE_FROM_IF_QUOTED_TEXT", 
			"QUOTE_COMPARE_FROM_IF_CLOSING_QUOTE", "WS_SECOND_QUOTE_COMPARE_FROM_IF", 
			"QUOTE_COMPARISON_OP_FROM_IF", "SECOND_QUOTE_COMPARE_FROM_IF_OPENING_QUOTE", 
			"SECOND_QUOTE_COMPARE_FROM_IF_QUOTED_TEXT", "SECOND_QUOTE_COMPARE_FROM_IF_CLOSING_QUOTE"
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
	public String getGrammarFileName() { return "MapParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public Place_and_callContext place_and_call() {
			return getRuleContext(Place_and_callContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			map();
			setState(10);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(9);
				def();
				}
				break;
			}
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEXT) {
				{
				setState(12);
				place_and_call();
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

	public static class MapContext extends ParserRuleContext {
		public TerminalNode MAP_SECTION_START() { return getToken(MapParser.MAP_SECTION_START, 0); }
		public TerminalNode MAP_CREATE_START() { return getToken(MapParser.MAP_CREATE_START, 0); }
		public TerminalNode MAP_OR_REGION_DIMENSIONS() { return getToken(MapParser.MAP_OR_REGION_DIMENSIONS, 0); }
		public TerminalNode MAP_CREATE_COLOUR() { return getToken(MapParser.MAP_CREATE_COLOUR, 0); }
		public TerminalNode MAP_SECTION_END() { return getToken(MapParser.MAP_SECTION_END, 0); }
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_map);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(MAP_SECTION_START);
			setState(16);
			match(MAP_CREATE_START);
			setState(17);
			match(MAP_OR_REGION_DIMENSIONS);
			setState(18);
			match(MAP_CREATE_COLOUR);
			setState(19);
			match(MAP_SECTION_END);
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

	public static class DefContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(MapParser.TEXT, 0); }
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(TEXT);
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

	public static class Place_and_callContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(MapParser.TEXT, 0); }
		public Place_and_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_and_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterPlace_and_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitPlace_and_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitPlace_and_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_and_callContext place_and_call() throws RecognitionException {
		Place_and_callContext _localctx = new Place_and_callContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_place_and_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(TEXT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008f\34\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\5\2\r\n\2\3\2\5\2\20\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2\2\31\2\n\3\2\2\2\4"+
		"\21\3\2\2\2\6\27\3\2\2\2\b\31\3\2\2\2\n\f\5\4\3\2\13\r\5\6\4\2\f\13\3"+
		"\2\2\2\f\r\3\2\2\2\r\17\3\2\2\2\16\20\5\b\5\2\17\16\3\2\2\2\17\20\3\2"+
		"\2\2\20\3\3\2\2\2\21\22\7\4\2\2\22\23\7\5\2\2\23\24\7\6\2\2\24\25\7\7"+
		"\2\2\25\26\7\b\2\2\26\5\3\2\2\2\27\30\7\34\2\2\30\7\3\2\2\2\31\32\7\34"+
		"\2\2\32\t\3\2\2\2\4\f\17";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}