// Generated from /Users/kaicycle/bike-boy-does-school/CS410/Project1Group8/ProjectFiles/out/production/ProjectFiles/parser/MapParser.g4 by ANTLR 4.9.1
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
		FUNCTION_CALL_START=24, FUNCITON_CALL_PARAM_END=25, PLACE_STATEMENT_END=26, 
		TEXT=27, WS_TEXT=28, WS_TEXT_QUOTED_TEXT_MODE=29, OPENING_QUOTE=30, QUOTED_TEXT=31, 
		CLOSING_QUOTE=32, NUM=33, WS_NUM=34, WS_TUPLE=35, OPENING_BRACKET=36, 
		TUPLE_TEXT=37, TUPLE_SEP=38, CLOSING_BRACKET=39, COLOR_START=40, COLOR_CODE=41, 
		COLOR_END=42, WS_COLOR=43, REGION=44, WS_REGION=45, AREA_MAP=46, AREA_REGION=47, 
		WS_AREA=48, WS_BOOLEAN=49, BOOLEAN_START=50, BOOLEAN_TRUE=51, BOOLEAN_FALSE=52, 
		WS_FUNCTION_STATEMENT=53, FUNCTION_STATEMENT_NUM=54, SIGNATURE_END=55, 
		FUNCTION_STATEMENT_END_OF_LINE=56, FUNCTION_SIGNATURE_END=57, LOOP_START=58, 
		LOOP_END=59, LOOP_TEXT_SEP=60, LOOP_FROM=61, LOOP_TO=62, LOOP_INCREMENT=63, 
		LOOP_DECREMENT=64, IF_SIGNATURE_START=65, IF_END=66, ELSE_START=67, ELSE_END=68, 
		PLACE_FEATURE_START_FROM_FUNC=69, FEATURE_OR_REGION_NAME_FROM_FUNC=70, 
		FEATURE_OR_REGION_LOCATION_FROM_FUNC=71, PLACE_FEATURE_ON_FROM_FUNC=72, 
		FEATURE_OR_REGION_DISPLAY_FROM_FUNC=73, PLACE_REGION_START_FROM_FUNC=74, 
		PLACE_REGION_DIMENSIONS=75, ASSIGNMENT_START=76, ASSIGNMENT_EQUALS=77, 
		WS_FUNCTION_STATEMENT_TEXT=78, FUNCTION_STATEMENT_TEXT_TEXT=79, WS_FROM_FUNC_QUOTED_TEXT_MODE=80, 
		FROM_FUNC_OPENING_QUOTE=81, FROM_FUNC_QUOTED_TEXT=82, FROM_FUNC_CLOSING_QUOTE=83, 
		WS_FROM_FUNC_TUPLE=84, FROM_FUNC_OPENING_BRACKET=85, FROM_FUNC_TUPLE_TEXT=86, 
		FROM_FUNC_TUPLE_SEP=87, FROM_FUNC_CLOSING_BRACKET=88, WS_AREA_FROM_FUNC=89, 
		AREA_FROM_FUNC_MAP=90, AREA_FRM_FUNC_REGION=91, WS_BOOLEAN_FROM_FUNC=92, 
		BOOLEAN_FROM_FUNC_START=93, BOOLEAN_FROM_FUNC_TRUE=94, BOOLEAN_FROM_FUNC_FALSE=95, 
		WS_PLACE_REGION_FROM_FUNC=96, REGION_FROM_FUNC=97, WS_EXPRESSION=98, EXPRESSION_END=99, 
		MATH_COMPARE_START=100, MATH_COMPARE_COMPARISON_OP=101, QUOTE_COMPARE_START=102, 
		MATH_START=103, QUOTE_TEXT_START=104, EXPRESSION_TEXT=105, BOOLEAN_FROM_EXPRESSION_START=106, 
		WS_EXPRESSION_QUOTED_TEXT_FOR_VAR=107, EXPRESSION_OPENING_QUOTE_FOR_VAR=108, 
		EXPRESSION_QUOTED_TEXT_FOR_VAR=109, EXPRESSION_CLOSING_QUOTE_FOR_VAR=110, 
		WS_EXPRESSION_QUOTED_TEXT=111, EXPRESSION_OPENING_QUOTE=112, EXPRESSION_QUOTED_TEXT=113, 
		EXPRESSION_CLOSING_QUOTE=114, WS_MATH_FROM_EXPRESSION=115, MATH_FROM_EXPRESSION_START=116, 
		MATH_FROM_EXPRESSION_TEXT=117, MATH_FROM_EXPRESSION_OPERATORS=118, MATH_FROM_EXPRESSION_END=119, 
		WS_QUOTE_COMPARE_FROM_EXPRESSION=120, QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT=121, 
		QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE=122, WS_SECOND_QUOTE_COMPARE_FROM_EXPRESSION=123, 
		QUOTE_COMPARISON_OP_FROM_EXPRESSION=124, SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE=125, 
		SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT=126, SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE=127, 
		WS_BOOLEAN_FROM_EXPRESSION=128, BOOLEAN_FROM_EXPRESSION_TRUE=129, BOOLEAN_FROM_EXPRESSION_FALSE=130, 
		WS_COMPARISON=131, MATH_COMPARE_FROM_IF_START=132, MATH_COMPARE_FROM_IF_COMPARISON_OP=133, 
		QUOTE_COMPARE_FROM_IF_START=134, COMPARISON_FROM_IF_END=135, WS_MATH_FROM_IF=136, 
		MATH_FROM_IF_START=137, MATH_FROM_IF_TEXT=138, MATH_FROM_IF_OPERATORS=139, 
		MATH_FROM_IF_END=140, WS_QUOTE_COMPARE_FROM_IF=141, QUOTE_COMPARE_FROM_IF_QUOTED_TEXT=142, 
		QUOTE_COMPARE_FROM_IF_CLOSING_QUOTE=143, WS_SECOND_QUOTE_COMPARE_FROM_IF=144, 
		QUOTE_COMPARISON_OP_FROM_IF=145, SECOND_QUOTE_COMPARE_FROM_IF_OPENING_QUOTE=146, 
		SECOND_QUOTE_COMPARE_FROM_IF_QUOTED_TEXT=147, SECOND_QUOTE_COMPARE_FROM_IF_CLOSING_QUOTE=148;
	public static final int
		RULE_program = 0, RULE_map = 1, RULE_def = 2, RULE_place_and_call = 3, 
		RULE_function = 4, RULE_function_start = 5, RULE_function_end = 6, RULE_loop = 7, 
		RULE_loop_start = 8, RULE_loop_end = 9, RULE_conditional = 10, RULE_if_start = 11, 
		RULE_else_start = 12, RULE_else_end = 13, RULE_if_end = 14, RULE_comparison_if = 15, 
		RULE_math_compare_if = 16, RULE_quote_compare_if = 17, RULE_math_if = 18, 
		RULE_math_op_if = 19, RULE_function_statement = 20, RULE_place_statement = 21, 
		RULE_create_map = 22, RULE_place_region = 23, RULE_define_feature = 24, 
		RULE_place_feature = 25, RULE_function_call = 26, RULE_assignment = 27, 
		RULE_place_feature_from_func = 28, RULE_xytuple_func = 29, RULE_quoted_text_func = 30, 
		RULE_area_func = 31, RULE_expression = 32, RULE_comparison_expressions = 33, 
		RULE_math_expression = 34, RULE_quoted_text_from_expression = 35, RULE_quoted_text_from_expression_second = 36, 
		RULE_quoted_text_for_var = 37, RULE_math_compare = 38, RULE_quote_compare = 39, 
		RULE_comparison_op = 40, RULE_math_comparison_op = 41, RULE_quote_comparison_op = 42, 
		RULE_math = 43, RULE_math_op = 44, RULE_area = 45, RULE_xytuple = 46, 
		RULE_quoted_text = 47, RULE_color = 48, RULE_boolean_antlr = 49, RULE_boolean_antlr_red = 50, 
		RULE_boolean_antlr_expression = 51;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "map", "def", "place_and_call", "function", "function_start", 
			"function_end", "loop", "loop_start", "loop_end", "conditional", "if_start", 
			"else_start", "else_end", "if_end", "comparison_if", "math_compare_if", 
			"quote_compare_if", "math_if", "math_op_if", "function_statement", "place_statement", 
			"create_map", "place_region", "define_feature", "place_feature", "function_call", 
			"assignment", "place_feature_from_func", "xytuple_func", "quoted_text_func", 
			"area_func", "expression", "comparison_expressions", "math_expression", 
			"quoted_text_from_expression", "quoted_text_from_expression_second", 
			"quoted_text_for_var", "math_compare", "quote_compare", "comparison_op", 
			"math_comparison_op", "quote_comparison_op", "math", "math_op", "area", 
			"xytuple", "quoted_text", "color", "boolean_antlr", "boolean_antlr_red", 
			"boolean_antlr_expression"
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
			null, null, null, "'#'", null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'END FUNCTION;'", "'START LOOP'", 
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
			"FUNCTION_CALL_START", "FUNCITON_CALL_PARAM_END", "PLACE_STATEMENT_END", 
			"TEXT", "WS_TEXT", "WS_TEXT_QUOTED_TEXT_MODE", "OPENING_QUOTE", "QUOTED_TEXT", 
			"CLOSING_QUOTE", "NUM", "WS_NUM", "WS_TUPLE", "OPENING_BRACKET", "TUPLE_TEXT", 
			"TUPLE_SEP", "CLOSING_BRACKET", "COLOR_START", "COLOR_CODE", "COLOR_END", 
			"WS_COLOR", "REGION", "WS_REGION", "AREA_MAP", "AREA_REGION", "WS_AREA", 
			"WS_BOOLEAN", "BOOLEAN_START", "BOOLEAN_TRUE", "BOOLEAN_FALSE", "WS_FUNCTION_STATEMENT", 
			"FUNCTION_STATEMENT_NUM", "SIGNATURE_END", "FUNCTION_STATEMENT_END_OF_LINE", 
			"FUNCTION_SIGNATURE_END", "LOOP_START", "LOOP_END", "LOOP_TEXT_SEP", 
			"LOOP_FROM", "LOOP_TO", "LOOP_INCREMENT", "LOOP_DECREMENT", "IF_SIGNATURE_START", 
			"IF_END", "ELSE_START", "ELSE_END", "PLACE_FEATURE_START_FROM_FUNC", 
			"FEATURE_OR_REGION_NAME_FROM_FUNC", "FEATURE_OR_REGION_LOCATION_FROM_FUNC", 
			"PLACE_FEATURE_ON_FROM_FUNC", "FEATURE_OR_REGION_DISPLAY_FROM_FUNC", 
			"PLACE_REGION_START_FROM_FUNC", "PLACE_REGION_DIMENSIONS", "ASSIGNMENT_START", 
			"ASSIGNMENT_EQUALS", "WS_FUNCTION_STATEMENT_TEXT", "FUNCTION_STATEMENT_TEXT_TEXT", 
			"WS_FROM_FUNC_QUOTED_TEXT_MODE", "FROM_FUNC_OPENING_QUOTE", "FROM_FUNC_QUOTED_TEXT", 
			"FROM_FUNC_CLOSING_QUOTE", "WS_FROM_FUNC_TUPLE", "FROM_FUNC_OPENING_BRACKET", 
			"FROM_FUNC_TUPLE_TEXT", "FROM_FUNC_TUPLE_SEP", "FROM_FUNC_CLOSING_BRACKET", 
			"WS_AREA_FROM_FUNC", "AREA_FROM_FUNC_MAP", "AREA_FRM_FUNC_REGION", "WS_BOOLEAN_FROM_FUNC", 
			"BOOLEAN_FROM_FUNC_START", "BOOLEAN_FROM_FUNC_TRUE", "BOOLEAN_FROM_FUNC_FALSE", 
			"WS_PLACE_REGION_FROM_FUNC", "REGION_FROM_FUNC", "WS_EXPRESSION", "EXPRESSION_END", 
			"MATH_COMPARE_START", "MATH_COMPARE_COMPARISON_OP", "QUOTE_COMPARE_START", 
			"MATH_START", "QUOTE_TEXT_START", "EXPRESSION_TEXT", "BOOLEAN_FROM_EXPRESSION_START", 
			"WS_EXPRESSION_QUOTED_TEXT_FOR_VAR", "EXPRESSION_OPENING_QUOTE_FOR_VAR", 
			"EXPRESSION_QUOTED_TEXT_FOR_VAR", "EXPRESSION_CLOSING_QUOTE_FOR_VAR", 
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
			setState(104);
			map();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEF_SECTION_START) {
				{
				setState(105);
				def();
				}
			}

			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLACE_AND_CALL_START) {
				{
				setState(108);
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
		public Create_mapContext create_map() {
			return getRuleContext(Create_mapContext.class,0);
		}
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
			setState(111);
			match(MAP_SECTION_START);
			setState(112);
			create_map();
			setState(113);
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
		public TerminalNode DEF_SECTION_START() { return getToken(MapParser.DEF_SECTION_START, 0); }
		public TerminalNode DEF_SECTION_END() { return getToken(MapParser.DEF_SECTION_END, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<Define_featureContext> define_feature() {
			return getRuleContexts(Define_featureContext.class);
		}
		public Define_featureContext define_feature(int i) {
			return getRuleContext(Define_featureContext.class,i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(DEF_SECTION_START);
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(118);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCTION_SIGNATURE_START:
					{
					setState(116);
					function();
					}
					break;
				case DEFINE_FEATURE_START:
					{
					setState(117);
					define_feature();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNCTION_SIGNATURE_START || _la==DEFINE_FEATURE_START );
			setState(122);
			match(DEF_SECTION_END);
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
		public TerminalNode PLACE_AND_CALL_START() { return getToken(MapParser.PLACE_AND_CALL_START, 0); }
		public TerminalNode PLACE_AND_CALL_END() { return getToken(MapParser.PLACE_AND_CALL_END, 0); }
		public List<Place_statementContext> place_statement() {
			return getRuleContexts(Place_statementContext.class);
		}
		public Place_statementContext place_statement(int i) {
			return getRuleContext(Place_statementContext.class,i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(PLACE_AND_CALL_START);
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				place_statement();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE_FEATURE_START) | (1L << PLACE_FEATURE_START) | (1L << PLACE_REGION_START) | (1L << FUNCTION_CALL_START))) != 0) );
			setState(130);
			match(PLACE_AND_CALL_END);
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

	public static class FunctionContext extends ParserRuleContext {
		public Function_startContext function_start() {
			return getRuleContext(Function_startContext.class,0);
		}
		public Function_endContext function_end() {
			return getRuleContext(Function_endContext.class,0);
		}
		public List<Function_statementContext> function_statement() {
			return getRuleContexts(Function_statementContext.class);
		}
		public Function_statementContext function_statement(int i) {
			return getRuleContext(Function_statementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			function_start();
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				function_statement();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (PLACE_REGION_START - 23)) | (1L << (LOOP_START - 23)) | (1L << (IF_SIGNATURE_START - 23)) | (1L << (PLACE_FEATURE_START_FROM_FUNC - 23)) | (1L << (ASSIGNMENT_START - 23)))) != 0) );
			setState(138);
			function_end();
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

	public static class Function_startContext extends ParserRuleContext {
		public TerminalNode FUNCTION_SIGNATURE_START() { return getToken(MapParser.FUNCTION_SIGNATURE_START, 0); }
		public List<TerminalNode> TEXT() { return getTokens(MapParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(MapParser.TEXT, i);
		}
		public TerminalNode FUNCTION_PARAM_START() { return getToken(MapParser.FUNCTION_PARAM_START, 0); }
		public TerminalNode FUNCTION_PARAM_END() { return getToken(MapParser.FUNCTION_PARAM_END, 0); }
		public List<TerminalNode> FUNCTION_PARAM_SEP() { return getTokens(MapParser.FUNCTION_PARAM_SEP); }
		public TerminalNode FUNCTION_PARAM_SEP(int i) {
			return getToken(MapParser.FUNCTION_PARAM_SEP, i);
		}
		public Function_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterFunction_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitFunction_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitFunction_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_startContext function_start() throws RecognitionException {
		Function_startContext _localctx = new Function_startContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(FUNCTION_SIGNATURE_START);
			setState(141);
			match(TEXT);
			setState(142);
			match(FUNCTION_PARAM_START);
			setState(143);
			match(TEXT);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION_PARAM_SEP) {
				{
				{
				setState(144);
				match(FUNCTION_PARAM_SEP);
				setState(145);
				match(TEXT);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(FUNCTION_PARAM_END);
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

	public static class Function_endContext extends ParserRuleContext {
		public TerminalNode FUNCTION_SIGNATURE_END() { return getToken(MapParser.FUNCTION_SIGNATURE_END, 0); }
		public Function_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterFunction_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitFunction_end(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitFunction_end(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_endContext function_end() throws RecognitionException {
		Function_endContext _localctx = new Function_endContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(FUNCTION_SIGNATURE_END);
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

	public static class LoopContext extends ParserRuleContext {
		public Loop_startContext loop_start() {
			return getRuleContext(Loop_startContext.class,0);
		}
		public Loop_endContext loop_end() {
			return getRuleContext(Loop_endContext.class,0);
		}
		public List<Function_statementContext> function_statement() {
			return getRuleContexts(Function_statementContext.class);
		}
		public Function_statementContext function_statement(int i) {
			return getRuleContext(Function_statementContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			loop_start();
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				function_statement();
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (PLACE_REGION_START - 23)) | (1L << (LOOP_START - 23)) | (1L << (IF_SIGNATURE_START - 23)) | (1L << (PLACE_FEATURE_START_FROM_FUNC - 23)) | (1L << (ASSIGNMENT_START - 23)))) != 0) );
			setState(161);
			loop_end();
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

	public static class Loop_startContext extends ParserRuleContext {
		public TerminalNode LOOP_START() { return getToken(MapParser.LOOP_START, 0); }
		public List<TerminalNode> FUNCTION_STATEMENT_TEXT_TEXT() { return getTokens(MapParser.FUNCTION_STATEMENT_TEXT_TEXT); }
		public TerminalNode FUNCTION_STATEMENT_TEXT_TEXT(int i) {
			return getToken(MapParser.FUNCTION_STATEMENT_TEXT_TEXT, i);
		}
		public TerminalNode LOOP_TEXT_SEP() { return getToken(MapParser.LOOP_TEXT_SEP, 0); }
		public TerminalNode LOOP_FROM() { return getToken(MapParser.LOOP_FROM, 0); }
		public TerminalNode LOOP_TO() { return getToken(MapParser.LOOP_TO, 0); }
		public TerminalNode FUNCTION_STATEMENT_NUM() { return getToken(MapParser.FUNCTION_STATEMENT_NUM, 0); }
		public TerminalNode SIGNATURE_END() { return getToken(MapParser.SIGNATURE_END, 0); }
		public TerminalNode LOOP_INCREMENT() { return getToken(MapParser.LOOP_INCREMENT, 0); }
		public TerminalNode LOOP_DECREMENT() { return getToken(MapParser.LOOP_DECREMENT, 0); }
		public Loop_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterLoop_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitLoop_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitLoop_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_startContext loop_start() throws RecognitionException {
		Loop_startContext _localctx = new Loop_startContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loop_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(LOOP_START);
			setState(164);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(165);
			match(LOOP_TEXT_SEP);
			setState(166);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(167);
			match(LOOP_FROM);
			setState(168);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(169);
			match(LOOP_TO);
			setState(170);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(171);
			_la = _input.LA(1);
			if ( !(_la==LOOP_INCREMENT || _la==LOOP_DECREMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(172);
			match(FUNCTION_STATEMENT_NUM);
			setState(173);
			match(SIGNATURE_END);
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

	public static class Loop_endContext extends ParserRuleContext {
		public TerminalNode LOOP_END() { return getToken(MapParser.LOOP_END, 0); }
		public TerminalNode FUNCTION_STATEMENT_TEXT_TEXT() { return getToken(MapParser.FUNCTION_STATEMENT_TEXT_TEXT, 0); }
		public TerminalNode FUNCTION_STATEMENT_END_OF_LINE() { return getToken(MapParser.FUNCTION_STATEMENT_END_OF_LINE, 0); }
		public Loop_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterLoop_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitLoop_end(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitLoop_end(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_endContext loop_end() throws RecognitionException {
		Loop_endContext _localctx = new Loop_endContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loop_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(LOOP_END);
			setState(176);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(177);
			match(FUNCTION_STATEMENT_END_OF_LINE);
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

	public static class ConditionalContext extends ParserRuleContext {
		public If_startContext if_start() {
			return getRuleContext(If_startContext.class,0);
		}
		public If_endContext if_end() {
			return getRuleContext(If_endContext.class,0);
		}
		public List<Function_statementContext> function_statement() {
			return getRuleContexts(Function_statementContext.class);
		}
		public Function_statementContext function_statement(int i) {
			return getRuleContext(Function_statementContext.class,i);
		}
		public Else_startContext else_start() {
			return getRuleContext(Else_startContext.class,0);
		}
		public Else_endContext else_end() {
			return getRuleContext(Else_endContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			if_start();
			setState(181); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(180);
				function_statement();
				}
				}
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (PLACE_REGION_START - 23)) | (1L << (LOOP_START - 23)) | (1L << (IF_SIGNATURE_START - 23)) | (1L << (PLACE_FEATURE_START_FROM_FUNC - 23)) | (1L << (ASSIGNMENT_START - 23)))) != 0) );
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE_START) {
				{
				setState(185);
				else_start();
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186);
					function_statement();
					}
					}
					setState(189); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (PLACE_REGION_START - 23)) | (1L << (LOOP_START - 23)) | (1L << (IF_SIGNATURE_START - 23)) | (1L << (PLACE_FEATURE_START_FROM_FUNC - 23)) | (1L << (ASSIGNMENT_START - 23)))) != 0) );
				setState(191);
				else_end();
				}
			}

			setState(195);
			if_end();
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

	public static class If_startContext extends ParserRuleContext {
		public TerminalNode IF_SIGNATURE_START() { return getToken(MapParser.IF_SIGNATURE_START, 0); }
		public Comparison_ifContext comparison_if() {
			return getRuleContext(Comparison_ifContext.class,0);
		}
		public TerminalNode COMPARISON_FROM_IF_END() { return getToken(MapParser.COMPARISON_FROM_IF_END, 0); }
		public If_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterIf_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitIf_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitIf_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_startContext if_start() throws RecognitionException {
		If_startContext _localctx = new If_startContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IF_SIGNATURE_START);
			setState(198);
			comparison_if();
			setState(199);
			match(COMPARISON_FROM_IF_END);
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

	public static class Else_startContext extends ParserRuleContext {
		public TerminalNode ELSE_START() { return getToken(MapParser.ELSE_START, 0); }
		public Else_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterElse_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitElse_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitElse_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_startContext else_start() throws RecognitionException {
		Else_startContext _localctx = new Else_startContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_else_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ELSE_START);
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

	public static class Else_endContext extends ParserRuleContext {
		public TerminalNode ELSE_END() { return getToken(MapParser.ELSE_END, 0); }
		public Else_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterElse_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitElse_end(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitElse_end(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_endContext else_end() throws RecognitionException {
		Else_endContext _localctx = new Else_endContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_else_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(ELSE_END);
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

	public static class If_endContext extends ParserRuleContext {
		public TerminalNode IF_END() { return getToken(MapParser.IF_END, 0); }
		public If_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterIf_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitIf_end(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitIf_end(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_endContext if_end() throws RecognitionException {
		If_endContext _localctx = new If_endContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_if_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(IF_END);
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

	public static class Comparison_ifContext extends ParserRuleContext {
		public Math_compare_ifContext math_compare_if() {
			return getRuleContext(Math_compare_ifContext.class,0);
		}
		public Quote_compare_ifContext quote_compare_if() {
			return getRuleContext(Quote_compare_ifContext.class,0);
		}
		public Comparison_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterComparison_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitComparison_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitComparison_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_ifContext comparison_if() throws RecognitionException {
		Comparison_ifContext _localctx = new Comparison_ifContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparison_if);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATH_COMPARE_FROM_IF_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				math_compare_if();
				}
				break;
			case QUOTE_COMPARE_FROM_IF_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				quote_compare_if();
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

	public static class Math_compare_ifContext extends ParserRuleContext {
		public TerminalNode MATH_COMPARE_FROM_IF_START() { return getToken(MapParser.MATH_COMPARE_FROM_IF_START, 0); }
		public List<Math_ifContext> math_if() {
			return getRuleContexts(Math_ifContext.class);
		}
		public Math_ifContext math_if(int i) {
			return getRuleContext(Math_ifContext.class,i);
		}
		public Comparison_opContext comparison_op() {
			return getRuleContext(Comparison_opContext.class,0);
		}
		public Math_compare_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_compare_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_compare_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_compare_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_compare_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_compare_ifContext math_compare_if() throws RecognitionException {
		Math_compare_ifContext _localctx = new Math_compare_ifContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_math_compare_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(MATH_COMPARE_FROM_IF_START);
			setState(212);
			math_if();
			setState(213);
			comparison_op();
			setState(214);
			math_if();
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

	public static class Quote_compare_ifContext extends ParserRuleContext {
		public TerminalNode QUOTE_COMPARE_FROM_IF_START() { return getToken(MapParser.QUOTE_COMPARE_FROM_IF_START, 0); }
		public List<Quoted_textContext> quoted_text() {
			return getRuleContexts(Quoted_textContext.class);
		}
		public Quoted_textContext quoted_text(int i) {
			return getRuleContext(Quoted_textContext.class,i);
		}
		public Quote_comparison_opContext quote_comparison_op() {
			return getRuleContext(Quote_comparison_opContext.class,0);
		}
		public Quote_compare_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote_compare_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuote_compare_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuote_compare_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuote_compare_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quote_compare_ifContext quote_compare_if() throws RecognitionException {
		Quote_compare_ifContext _localctx = new Quote_compare_ifContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_quote_compare_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(QUOTE_COMPARE_FROM_IF_START);
			setState(217);
			quoted_text();
			setState(218);
			quote_comparison_op();
			setState(219);
			quoted_text();
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

	public static class Math_ifContext extends ParserRuleContext {
		public TerminalNode MATH_FROM_IF_START() { return getToken(MapParser.MATH_FROM_IF_START, 0); }
		public List<TerminalNode> MATH_FROM_IF_TEXT() { return getTokens(MapParser.MATH_FROM_IF_TEXT); }
		public TerminalNode MATH_FROM_IF_TEXT(int i) {
			return getToken(MapParser.MATH_FROM_IF_TEXT, i);
		}
		public TerminalNode MATH_FROM_IF_END() { return getToken(MapParser.MATH_FROM_IF_END, 0); }
		public Math_op_ifContext math_op_if() {
			return getRuleContext(Math_op_ifContext.class,0);
		}
		public Math_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_ifContext math_if() throws RecognitionException {
		Math_ifContext _localctx = new Math_ifContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_math_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(MATH_FROM_IF_START);
			setState(222);
			match(MATH_FROM_IF_TEXT);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATH_FROM_IF_OPERATORS) {
				{
				setState(223);
				math_op_if();
				setState(224);
				match(MATH_FROM_IF_TEXT);
				}
			}

			setState(228);
			match(MATH_FROM_IF_END);
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

	public static class Math_op_ifContext extends ParserRuleContext {
		public TerminalNode MATH_FROM_IF_OPERATORS() { return getToken(MapParser.MATH_FROM_IF_OPERATORS, 0); }
		public Math_op_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_op_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_op_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_op_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_op_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_op_ifContext math_op_if() throws RecognitionException {
		Math_op_ifContext _localctx = new Math_op_ifContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_math_op_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(MATH_FROM_IF_OPERATORS);
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

	public static class Function_statementContext extends ParserRuleContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public Place_feature_from_funcContext place_feature_from_func() {
			return getRuleContext(Place_feature_from_funcContext.class,0);
		}
		public Place_regionContext place_region() {
			return getRuleContext(Place_regionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Function_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterFunction_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitFunction_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitFunction_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_statementContext function_statement() throws RecognitionException {
		Function_statementContext _localctx = new Function_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_function_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOOP_START:
				{
				setState(232);
				loop();
				}
				break;
			case IF_SIGNATURE_START:
				{
				setState(233);
				conditional();
				}
				break;
			case PLACE_FEATURE_START_FROM_FUNC:
				{
				setState(234);
				place_feature_from_func();
				}
				break;
			case PLACE_REGION_START:
				{
				setState(235);
				place_region();
				}
				break;
			case ASSIGNMENT_START:
				{
				setState(236);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Place_statementContext extends ParserRuleContext {
		public TerminalNode PLACE_STATEMENT_END() { return getToken(MapParser.PLACE_STATEMENT_END, 0); }
		public Define_featureContext define_feature() {
			return getRuleContext(Define_featureContext.class,0);
		}
		public Place_featureContext place_feature() {
			return getRuleContext(Place_featureContext.class,0);
		}
		public Place_regionContext place_region() {
			return getRuleContext(Place_regionContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Place_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterPlace_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitPlace_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitPlace_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_statementContext place_statement() throws RecognitionException {
		Place_statementContext _localctx = new Place_statementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_place_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEFINE_FEATURE_START:
				{
				setState(239);
				define_feature();
				}
				break;
			case PLACE_FEATURE_START:
				{
				setState(240);
				place_feature();
				}
				break;
			case PLACE_REGION_START:
				{
				setState(241);
				place_region();
				}
				break;
			case FUNCTION_CALL_START:
				{
				setState(242);
				function_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(245);
			match(PLACE_STATEMENT_END);
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

	public static class Create_mapContext extends ParserRuleContext {
		public TerminalNode MAP_CREATE_START() { return getToken(MapParser.MAP_CREATE_START, 0); }
		public Quoted_textContext quoted_text() {
			return getRuleContext(Quoted_textContext.class,0);
		}
		public TerminalNode MAP_OR_REGION_DIMENSIONS() { return getToken(MapParser.MAP_OR_REGION_DIMENSIONS, 0); }
		public XytupleContext xytuple() {
			return getRuleContext(XytupleContext.class,0);
		}
		public TerminalNode MAP_CREATE_COLOUR() { return getToken(MapParser.MAP_CREATE_COLOUR, 0); }
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public Create_mapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterCreate_map(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitCreate_map(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitCreate_map(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_mapContext create_map() throws RecognitionException {
		Create_mapContext _localctx = new Create_mapContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_create_map);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(MAP_CREATE_START);
			setState(248);
			quoted_text();
			setState(249);
			match(MAP_OR_REGION_DIMENSIONS);
			setState(250);
			xytuple();
			setState(251);
			match(MAP_CREATE_COLOUR);
			setState(252);
			color();
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

	public static class Place_regionContext extends ParserRuleContext {
		public TerminalNode PLACE_REGION_START() { return getToken(MapParser.PLACE_REGION_START, 0); }
		public TerminalNode REGION() { return getToken(MapParser.REGION, 0); }
		public TerminalNode FEATURE_OR_REGION_NAME() { return getToken(MapParser.FEATURE_OR_REGION_NAME, 0); }
		public Quoted_textContext quoted_text() {
			return getRuleContext(Quoted_textContext.class,0);
		}
		public TerminalNode FEATURE_OR_REGION_LOCATION() { return getToken(MapParser.FEATURE_OR_REGION_LOCATION, 0); }
		public List<XytupleContext> xytuple() {
			return getRuleContexts(XytupleContext.class);
		}
		public XytupleContext xytuple(int i) {
			return getRuleContext(XytupleContext.class,i);
		}
		public TerminalNode PLACE_REGION_DIMENSIONS() { return getToken(MapParser.PLACE_REGION_DIMENSIONS, 0); }
		public TerminalNode FEATURE_OR_REGION_DISPLAY() { return getToken(MapParser.FEATURE_OR_REGION_DISPLAY, 0); }
		public Boolean_antlrContext boolean_antlr() {
			return getRuleContext(Boolean_antlrContext.class,0);
		}
		public Place_regionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_region; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterPlace_region(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitPlace_region(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitPlace_region(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_regionContext place_region() throws RecognitionException {
		Place_regionContext _localctx = new Place_regionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_place_region);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(PLACE_REGION_START);
			setState(255);
			match(REGION);
			setState(256);
			match(FEATURE_OR_REGION_NAME);
			setState(257);
			quoted_text();
			setState(258);
			match(FEATURE_OR_REGION_LOCATION);
			setState(259);
			xytuple();
			setState(260);
			match(PLACE_REGION_DIMENSIONS);
			setState(261);
			xytuple();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEATURE_OR_REGION_DISPLAY) {
				{
				setState(262);
				match(FEATURE_OR_REGION_DISPLAY);
				setState(263);
				boolean_antlr();
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

	public static class Define_featureContext extends ParserRuleContext {
		public TerminalNode DEFINE_FEATURE_START() { return getToken(MapParser.DEFINE_FEATURE_START, 0); }
		public TerminalNode TEXT() { return getToken(MapParser.TEXT, 0); }
		public TerminalNode DEFINE_FEATURE_ICON() { return getToken(MapParser.DEFINE_FEATURE_ICON, 0); }
		public Quoted_textContext quoted_text() {
			return getRuleContext(Quoted_textContext.class,0);
		}
		public TerminalNode DEFINE_FEATURE_SIZE() { return getToken(MapParser.DEFINE_FEATURE_SIZE, 0); }
		public TerminalNode NUM() { return getToken(MapParser.NUM, 0); }
		public Define_featureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterDefine_feature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitDefine_feature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitDefine_feature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_featureContext define_feature() throws RecognitionException {
		Define_featureContext _localctx = new Define_featureContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_define_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(DEFINE_FEATURE_START);
			setState(267);
			match(TEXT);
			setState(268);
			match(DEFINE_FEATURE_ICON);
			setState(269);
			quoted_text();
			setState(270);
			match(DEFINE_FEATURE_SIZE);
			setState(271);
			match(NUM);
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

	public static class Place_featureContext extends ParserRuleContext {
		public TerminalNode PLACE_FEATURE_START() { return getToken(MapParser.PLACE_FEATURE_START, 0); }
		public TerminalNode TEXT() { return getToken(MapParser.TEXT, 0); }
		public TerminalNode FEATURE_OR_REGION_NAME() { return getToken(MapParser.FEATURE_OR_REGION_NAME, 0); }
		public Quoted_textContext quoted_text() {
			return getRuleContext(Quoted_textContext.class,0);
		}
		public TerminalNode FEATURE_OR_REGION_LOCATION() { return getToken(MapParser.FEATURE_OR_REGION_LOCATION, 0); }
		public XytupleContext xytuple() {
			return getRuleContext(XytupleContext.class,0);
		}
		public TerminalNode PLACE_FEATURE_ON() { return getToken(MapParser.PLACE_FEATURE_ON, 0); }
		public AreaContext area() {
			return getRuleContext(AreaContext.class,0);
		}
		public TerminalNode FEATURE_OR_REGION_DISPLAY() { return getToken(MapParser.FEATURE_OR_REGION_DISPLAY, 0); }
		public Boolean_antlrContext boolean_antlr() {
			return getRuleContext(Boolean_antlrContext.class,0);
		}
		public Place_featureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterPlace_feature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitPlace_feature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitPlace_feature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_featureContext place_feature() throws RecognitionException {
		Place_featureContext _localctx = new Place_featureContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_place_feature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(PLACE_FEATURE_START);
			setState(274);
			match(TEXT);
			setState(275);
			match(FEATURE_OR_REGION_NAME);
			setState(276);
			quoted_text();
			setState(277);
			match(FEATURE_OR_REGION_LOCATION);
			setState(278);
			xytuple();
			setState(279);
			match(PLACE_FEATURE_ON);
			setState(280);
			area();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEATURE_OR_REGION_DISPLAY) {
				{
				setState(281);
				match(FEATURE_OR_REGION_DISPLAY);
				setState(282);
				boolean_antlr();
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION_CALL_START() { return getToken(MapParser.FUNCTION_CALL_START, 0); }
		public List<TerminalNode> TEXT() { return getTokens(MapParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(MapParser.TEXT, i);
		}
		public TerminalNode FUNCTION_PARAM_START() { return getToken(MapParser.FUNCTION_PARAM_START, 0); }
		public TerminalNode FUNCITON_CALL_PARAM_END() { return getToken(MapParser.FUNCITON_CALL_PARAM_END, 0); }
		public List<TerminalNode> FUNCTION_PARAM_SEP() { return getTokens(MapParser.FUNCTION_PARAM_SEP); }
		public TerminalNode FUNCTION_PARAM_SEP(int i) {
			return getToken(MapParser.FUNCTION_PARAM_SEP, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(FUNCTION_CALL_START);
			setState(286);
			match(TEXT);
			setState(287);
			match(FUNCTION_PARAM_START);
			setState(288);
			match(TEXT);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION_PARAM_SEP) {
				{
				{
				setState(289);
				match(FUNCTION_PARAM_SEP);
				setState(290);
				match(TEXT);
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
			match(FUNCITON_CALL_PARAM_END);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGNMENT_START() { return getToken(MapParser.ASSIGNMENT_START, 0); }
		public TerminalNode FUNCTION_STATEMENT_TEXT_TEXT() { return getToken(MapParser.FUNCTION_STATEMENT_TEXT_TEXT, 0); }
		public TerminalNode ASSIGNMENT_EQUALS() { return getToken(MapParser.ASSIGNMENT_EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(ASSIGNMENT_START);
			setState(299);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(300);
			match(ASSIGNMENT_EQUALS);
			setState(301);
			expression();
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

	public static class Place_feature_from_funcContext extends ParserRuleContext {
		public TerminalNode PLACE_FEATURE_START_FROM_FUNC() { return getToken(MapParser.PLACE_FEATURE_START_FROM_FUNC, 0); }
		public TerminalNode FUNCTION_STATEMENT_TEXT_TEXT() { return getToken(MapParser.FUNCTION_STATEMENT_TEXT_TEXT, 0); }
		public TerminalNode FEATURE_OR_REGION_NAME_FROM_FUNC() { return getToken(MapParser.FEATURE_OR_REGION_NAME_FROM_FUNC, 0); }
		public Quoted_text_funcContext quoted_text_func() {
			return getRuleContext(Quoted_text_funcContext.class,0);
		}
		public TerminalNode FEATURE_OR_REGION_LOCATION_FROM_FUNC() { return getToken(MapParser.FEATURE_OR_REGION_LOCATION_FROM_FUNC, 0); }
		public Xytuple_funcContext xytuple_func() {
			return getRuleContext(Xytuple_funcContext.class,0);
		}
		public TerminalNode PLACE_FEATURE_ON_FROM_FUNC() { return getToken(MapParser.PLACE_FEATURE_ON_FROM_FUNC, 0); }
		public Area_funcContext area_func() {
			return getRuleContext(Area_funcContext.class,0);
		}
		public TerminalNode FEATURE_OR_REGION_DISPLAY_FROM_FUNC() { return getToken(MapParser.FEATURE_OR_REGION_DISPLAY_FROM_FUNC, 0); }
		public Boolean_antlrContext boolean_antlr() {
			return getRuleContext(Boolean_antlrContext.class,0);
		}
		public Place_feature_from_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_feature_from_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterPlace_feature_from_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitPlace_feature_from_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitPlace_feature_from_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_feature_from_funcContext place_feature_from_func() throws RecognitionException {
		Place_feature_from_funcContext _localctx = new Place_feature_from_funcContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_place_feature_from_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(PLACE_FEATURE_START_FROM_FUNC);
			setState(304);
			match(FUNCTION_STATEMENT_TEXT_TEXT);
			setState(305);
			match(FEATURE_OR_REGION_NAME_FROM_FUNC);
			setState(306);
			quoted_text_func();
			setState(307);
			match(FEATURE_OR_REGION_LOCATION_FROM_FUNC);
			setState(308);
			xytuple_func();
			setState(309);
			match(PLACE_FEATURE_ON_FROM_FUNC);
			setState(310);
			area_func();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEATURE_OR_REGION_DISPLAY_FROM_FUNC) {
				{
				setState(311);
				match(FEATURE_OR_REGION_DISPLAY_FROM_FUNC);
				setState(312);
				boolean_antlr();
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

	public static class Xytuple_funcContext extends ParserRuleContext {
		public TerminalNode FROM_FUNC_OPENING_BRACKET() { return getToken(MapParser.FROM_FUNC_OPENING_BRACKET, 0); }
		public List<TerminalNode> FROM_FUNC_TUPLE_TEXT() { return getTokens(MapParser.FROM_FUNC_TUPLE_TEXT); }
		public TerminalNode FROM_FUNC_TUPLE_TEXT(int i) {
			return getToken(MapParser.FROM_FUNC_TUPLE_TEXT, i);
		}
		public TerminalNode FROM_FUNC_TUPLE_SEP() { return getToken(MapParser.FROM_FUNC_TUPLE_SEP, 0); }
		public TerminalNode FROM_FUNC_CLOSING_BRACKET() { return getToken(MapParser.FROM_FUNC_CLOSING_BRACKET, 0); }
		public Xytuple_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xytuple_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterXytuple_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitXytuple_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitXytuple_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xytuple_funcContext xytuple_func() throws RecognitionException {
		Xytuple_funcContext _localctx = new Xytuple_funcContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_xytuple_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(FROM_FUNC_OPENING_BRACKET);
			setState(316);
			match(FROM_FUNC_TUPLE_TEXT);
			setState(317);
			match(FROM_FUNC_TUPLE_SEP);
			setState(318);
			match(FROM_FUNC_TUPLE_TEXT);
			setState(319);
			match(FROM_FUNC_CLOSING_BRACKET);
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

	public static class Quoted_text_funcContext extends ParserRuleContext {
		public TerminalNode FROM_FUNC_OPENING_QUOTE() { return getToken(MapParser.FROM_FUNC_OPENING_QUOTE, 0); }
		public TerminalNode FROM_FUNC_QUOTED_TEXT() { return getToken(MapParser.FROM_FUNC_QUOTED_TEXT, 0); }
		public TerminalNode FROM_FUNC_CLOSING_QUOTE() { return getToken(MapParser.FROM_FUNC_CLOSING_QUOTE, 0); }
		public Quoted_text_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_text_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuoted_text_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuoted_text_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuoted_text_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quoted_text_funcContext quoted_text_func() throws RecognitionException {
		Quoted_text_funcContext _localctx = new Quoted_text_funcContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_quoted_text_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(FROM_FUNC_OPENING_QUOTE);
			setState(322);
			match(FROM_FUNC_QUOTED_TEXT);
			setState(323);
			match(FROM_FUNC_CLOSING_QUOTE);
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

	public static class Area_funcContext extends ParserRuleContext {
		public TerminalNode AREA_FROM_FUNC_MAP() { return getToken(MapParser.AREA_FROM_FUNC_MAP, 0); }
		public TerminalNode AREA_FRM_FUNC_REGION() { return getToken(MapParser.AREA_FRM_FUNC_REGION, 0); }
		public Quoted_textContext quoted_text() {
			return getRuleContext(Quoted_textContext.class,0);
		}
		public Area_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_area_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterArea_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitArea_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitArea_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Area_funcContext area_func() throws RecognitionException {
		Area_funcContext _localctx = new Area_funcContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_area_func);
		try {
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AREA_FROM_FUNC_MAP:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				match(AREA_FROM_FUNC_MAP);
				}
				break;
			case AREA_FRM_FUNC_REGION:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(326);
				match(AREA_FRM_FUNC_REGION);
				setState(327);
				quoted_text();
				}
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EXPRESSION_END() { return getToken(MapParser.EXPRESSION_END, 0); }
		public Comparison_expressionsContext comparison_expressions() {
			return getRuleContext(Comparison_expressionsContext.class,0);
		}
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public Math_expressionContext math_expression() {
			return getRuleContext(Math_expressionContext.class,0);
		}
		public Quoted_text_from_expressionContext quoted_text_from_expression() {
			return getRuleContext(Quoted_text_from_expressionContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(MapParser.TEXT, 0); }
		public TerminalNode EXPRESSION_TEXT() { return getToken(MapParser.EXPRESSION_TEXT, 0); }
		public Boolean_antlrContext boolean_antlr() {
			return getRuleContext(Boolean_antlrContext.class,0);
		}
		public Quoted_text_for_varContext quoted_text_for_var() {
			return getRuleContext(Quoted_text_for_varContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATH_COMPARE_START:
			case QUOTE_COMPARE_START:
				{
				setState(330);
				comparison_expressions();
				}
				break;
			case MATH_START:
				{
				setState(331);
				math();
				}
				break;
			case MATH_FROM_EXPRESSION_START:
				{
				setState(332);
				math_expression();
				}
				break;
			case QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT:
				{
				setState(333);
				quoted_text_from_expression();
				}
				break;
			case TEXT:
				{
				setState(334);
				match(TEXT);
				}
				break;
			case EXPRESSION_TEXT:
				{
				setState(335);
				match(EXPRESSION_TEXT);
				}
				break;
			case BOOLEAN_START:
			case BOOLEAN_FROM_EXPRESSION_START:
				{
				setState(336);
				boolean_antlr();
				}
				break;
			case QUOTE_TEXT_START:
				{
				setState(337);
				quoted_text_for_var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(340);
			match(EXPRESSION_END);
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

	public static class Comparison_expressionsContext extends ParserRuleContext {
		public Math_compareContext math_compare() {
			return getRuleContext(Math_compareContext.class,0);
		}
		public Quote_compareContext quote_compare() {
			return getRuleContext(Quote_compareContext.class,0);
		}
		public Comparison_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterComparison_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitComparison_expressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitComparison_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_expressionsContext comparison_expressions() throws RecognitionException {
		Comparison_expressionsContext _localctx = new Comparison_expressionsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_comparison_expressions);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATH_COMPARE_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				math_compare();
				}
				break;
			case QUOTE_COMPARE_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				quote_compare();
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

	public static class Math_expressionContext extends ParserRuleContext {
		public TerminalNode MATH_FROM_EXPRESSION_START() { return getToken(MapParser.MATH_FROM_EXPRESSION_START, 0); }
		public List<TerminalNode> MATH_FROM_EXPRESSION_TEXT() { return getTokens(MapParser.MATH_FROM_EXPRESSION_TEXT); }
		public TerminalNode MATH_FROM_EXPRESSION_TEXT(int i) {
			return getToken(MapParser.MATH_FROM_EXPRESSION_TEXT, i);
		}
		public TerminalNode MATH_FROM_EXPRESSION_END() { return getToken(MapParser.MATH_FROM_EXPRESSION_END, 0); }
		public Math_opContext math_op() {
			return getRuleContext(Math_opContext.class,0);
		}
		public Math_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_expressionContext math_expression() throws RecognitionException {
		Math_expressionContext _localctx = new Math_expressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_math_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(MATH_FROM_EXPRESSION_START);
			setState(347);
			match(MATH_FROM_EXPRESSION_TEXT);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATH_FROM_EXPRESSION_OPERATORS) {
				{
				setState(348);
				math_op();
				setState(349);
				match(MATH_FROM_EXPRESSION_TEXT);
				}
			}

			setState(353);
			match(MATH_FROM_EXPRESSION_END);
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

	public static class Quoted_text_from_expressionContext extends ParserRuleContext {
		public TerminalNode QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT() { return getToken(MapParser.QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT, 0); }
		public TerminalNode QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE() { return getToken(MapParser.QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE, 0); }
		public Quoted_text_from_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_text_from_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuoted_text_from_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuoted_text_from_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuoted_text_from_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quoted_text_from_expressionContext quoted_text_from_expression() throws RecognitionException {
		Quoted_text_from_expressionContext _localctx = new Quoted_text_from_expressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_quoted_text_from_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT);
			setState(356);
			match(QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE);
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

	public static class Quoted_text_from_expression_secondContext extends ParserRuleContext {
		public TerminalNode SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE() { return getToken(MapParser.SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE, 0); }
		public TerminalNode SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT() { return getToken(MapParser.SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT, 0); }
		public TerminalNode SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE() { return getToken(MapParser.SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE, 0); }
		public Quoted_text_from_expression_secondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_text_from_expression_second; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuoted_text_from_expression_second(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuoted_text_from_expression_second(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuoted_text_from_expression_second(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quoted_text_from_expression_secondContext quoted_text_from_expression_second() throws RecognitionException {
		Quoted_text_from_expression_secondContext _localctx = new Quoted_text_from_expression_secondContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_quoted_text_from_expression_second);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE);
			setState(359);
			match(SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT);
			setState(360);
			match(SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE);
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

	public static class Quoted_text_for_varContext extends ParserRuleContext {
		public TerminalNode QUOTE_TEXT_START() { return getToken(MapParser.QUOTE_TEXT_START, 0); }
		public TerminalNode EXPRESSION_QUOTED_TEXT_FOR_VAR() { return getToken(MapParser.EXPRESSION_QUOTED_TEXT_FOR_VAR, 0); }
		public TerminalNode EXPRESSION_CLOSING_QUOTE_FOR_VAR() { return getToken(MapParser.EXPRESSION_CLOSING_QUOTE_FOR_VAR, 0); }
		public Quoted_text_for_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_text_for_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuoted_text_for_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuoted_text_for_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuoted_text_for_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quoted_text_for_varContext quoted_text_for_var() throws RecognitionException {
		Quoted_text_for_varContext _localctx = new Quoted_text_for_varContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_quoted_text_for_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(QUOTE_TEXT_START);
			setState(363);
			match(EXPRESSION_QUOTED_TEXT_FOR_VAR);
			setState(364);
			match(EXPRESSION_CLOSING_QUOTE_FOR_VAR);
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

	public static class Math_compareContext extends ParserRuleContext {
		public TerminalNode MATH_COMPARE_START() { return getToken(MapParser.MATH_COMPARE_START, 0); }
		public List<Math_expressionContext> math_expression() {
			return getRuleContexts(Math_expressionContext.class);
		}
		public Math_expressionContext math_expression(int i) {
			return getRuleContext(Math_expressionContext.class,i);
		}
		public Comparison_opContext comparison_op() {
			return getRuleContext(Comparison_opContext.class,0);
		}
		public Math_compareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_compare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_compare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_compare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_compareContext math_compare() throws RecognitionException {
		Math_compareContext _localctx = new Math_compareContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_math_compare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(MATH_COMPARE_START);
			setState(367);
			math_expression();
			setState(368);
			comparison_op();
			setState(369);
			math_expression();
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

	public static class Quote_compareContext extends ParserRuleContext {
		public TerminalNode QUOTE_COMPARE_START() { return getToken(MapParser.QUOTE_COMPARE_START, 0); }
		public Quoted_text_from_expressionContext quoted_text_from_expression() {
			return getRuleContext(Quoted_text_from_expressionContext.class,0);
		}
		public Quote_comparison_opContext quote_comparison_op() {
			return getRuleContext(Quote_comparison_opContext.class,0);
		}
		public Quoted_text_from_expression_secondContext quoted_text_from_expression_second() {
			return getRuleContext(Quoted_text_from_expression_secondContext.class,0);
		}
		public Quote_compareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuote_compare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuote_compare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuote_compare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quote_compareContext quote_compare() throws RecognitionException {
		Quote_compareContext _localctx = new Quote_compareContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_quote_compare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(QUOTE_COMPARE_START);
			setState(372);
			quoted_text_from_expression();
			setState(373);
			quote_comparison_op();
			setState(374);
			quoted_text_from_expression_second();
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

	public static class Comparison_opContext extends ParserRuleContext {
		public Math_comparison_opContext math_comparison_op() {
			return getRuleContext(Math_comparison_opContext.class,0);
		}
		public Quote_comparison_opContext quote_comparison_op() {
			return getRuleContext(Quote_comparison_opContext.class,0);
		}
		public Comparison_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterComparison_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitComparison_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitComparison_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_opContext comparison_op() throws RecognitionException {
		Comparison_opContext _localctx = new Comparison_opContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_comparison_op);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATH_COMPARE_COMPARISON_OP:
			case MATH_COMPARE_FROM_IF_COMPARISON_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				math_comparison_op();
				}
				break;
			case QUOTE_COMPARISON_OP_FROM_EXPRESSION:
			case QUOTE_COMPARISON_OP_FROM_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				quote_comparison_op();
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

	public static class Math_comparison_opContext extends ParserRuleContext {
		public TerminalNode MATH_COMPARE_COMPARISON_OP() { return getToken(MapParser.MATH_COMPARE_COMPARISON_OP, 0); }
		public TerminalNode MATH_COMPARE_FROM_IF_COMPARISON_OP() { return getToken(MapParser.MATH_COMPARE_FROM_IF_COMPARISON_OP, 0); }
		public Math_comparison_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_comparison_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_comparison_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_comparison_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_comparison_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_comparison_opContext math_comparison_op() throws RecognitionException {
		Math_comparison_opContext _localctx = new Math_comparison_opContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_math_comparison_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_la = _input.LA(1);
			if ( !(_la==MATH_COMPARE_COMPARISON_OP || _la==MATH_COMPARE_FROM_IF_COMPARISON_OP) ) {
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

	public static class Quote_comparison_opContext extends ParserRuleContext {
		public TerminalNode QUOTE_COMPARISON_OP_FROM_EXPRESSION() { return getToken(MapParser.QUOTE_COMPARISON_OP_FROM_EXPRESSION, 0); }
		public TerminalNode QUOTE_COMPARISON_OP_FROM_IF() { return getToken(MapParser.QUOTE_COMPARISON_OP_FROM_IF, 0); }
		public Quote_comparison_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote_comparison_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuote_comparison_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuote_comparison_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuote_comparison_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quote_comparison_opContext quote_comparison_op() throws RecognitionException {
		Quote_comparison_opContext _localctx = new Quote_comparison_opContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_quote_comparison_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_la = _input.LA(1);
			if ( !(_la==QUOTE_COMPARISON_OP_FROM_EXPRESSION || _la==QUOTE_COMPARISON_OP_FROM_IF) ) {
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

	public static class MathContext extends ParserRuleContext {
		public TerminalNode MATH_START() { return getToken(MapParser.MATH_START, 0); }
		public List<TerminalNode> MATH_FROM_EXPRESSION_TEXT() { return getTokens(MapParser.MATH_FROM_EXPRESSION_TEXT); }
		public TerminalNode MATH_FROM_EXPRESSION_TEXT(int i) {
			return getToken(MapParser.MATH_FROM_EXPRESSION_TEXT, i);
		}
		public TerminalNode MATH_FROM_EXPRESSION_END() { return getToken(MapParser.MATH_FROM_EXPRESSION_END, 0); }
		public Math_opContext math_op() {
			return getRuleContext(Math_opContext.class,0);
		}
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathContext math() throws RecognitionException {
		MathContext _localctx = new MathContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_math);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(MATH_START);
			setState(385);
			match(MATH_FROM_EXPRESSION_TEXT);
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATH_FROM_EXPRESSION_OPERATORS) {
				{
				setState(386);
				math_op();
				setState(387);
				match(MATH_FROM_EXPRESSION_TEXT);
				}
			}

			setState(391);
			match(MATH_FROM_EXPRESSION_END);
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

	public static class Math_opContext extends ParserRuleContext {
		public TerminalNode MATH_FROM_EXPRESSION_OPERATORS() { return getToken(MapParser.MATH_FROM_EXPRESSION_OPERATORS, 0); }
		public Math_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterMath_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitMath_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitMath_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_opContext math_op() throws RecognitionException {
		Math_opContext _localctx = new Math_opContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_math_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(MATH_FROM_EXPRESSION_OPERATORS);
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

	public static class AreaContext extends ParserRuleContext {
		public TerminalNode AREA_MAP() { return getToken(MapParser.AREA_MAP, 0); }
		public TerminalNode AREA_REGION() { return getToken(MapParser.AREA_REGION, 0); }
		public Quoted_textContext quoted_text() {
			return getRuleContext(Quoted_textContext.class,0);
		}
		public AreaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_area; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterArea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitArea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitArea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AreaContext area() throws RecognitionException {
		AreaContext _localctx = new AreaContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_area);
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AREA_MAP:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				match(AREA_MAP);
				}
				break;
			case AREA_REGION:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(396);
				match(AREA_REGION);
				setState(397);
				quoted_text();
				}
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

	public static class XytupleContext extends ParserRuleContext {
		public TerminalNode OPENING_BRACKET() { return getToken(MapParser.OPENING_BRACKET, 0); }
		public List<TerminalNode> TUPLE_TEXT() { return getTokens(MapParser.TUPLE_TEXT); }
		public TerminalNode TUPLE_TEXT(int i) {
			return getToken(MapParser.TUPLE_TEXT, i);
		}
		public TerminalNode TUPLE_SEP() { return getToken(MapParser.TUPLE_SEP, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(MapParser.CLOSING_BRACKET, 0); }
		public XytupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xytuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterXytuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitXytuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitXytuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XytupleContext xytuple() throws RecognitionException {
		XytupleContext _localctx = new XytupleContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_xytuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(OPENING_BRACKET);
			setState(401);
			match(TUPLE_TEXT);
			setState(402);
			match(TUPLE_SEP);
			setState(403);
			match(TUPLE_TEXT);
			setState(404);
			match(CLOSING_BRACKET);
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

	public static class Quoted_textContext extends ParserRuleContext {
		public TerminalNode OPENING_QUOTE() { return getToken(MapParser.OPENING_QUOTE, 0); }
		public TerminalNode QUOTED_TEXT() { return getToken(MapParser.QUOTED_TEXT, 0); }
		public TerminalNode CLOSING_QUOTE() { return getToken(MapParser.CLOSING_QUOTE, 0); }
		public Quoted_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterQuoted_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitQuoted_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitQuoted_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quoted_textContext quoted_text() throws RecognitionException {
		Quoted_textContext _localctx = new Quoted_textContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_quoted_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(OPENING_QUOTE);
			setState(407);
			match(QUOTED_TEXT);
			setState(408);
			match(CLOSING_QUOTE);
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

	public static class ColorContext extends ParserRuleContext {
		public TerminalNode COLOR_START() { return getToken(MapParser.COLOR_START, 0); }
		public TerminalNode COLOR_CODE() { return getToken(MapParser.COLOR_CODE, 0); }
		public TerminalNode COLOR_END() { return getToken(MapParser.COLOR_END, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(COLOR_START);
			setState(411);
			match(COLOR_CODE);
			setState(412);
			match(COLOR_END);
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

	public static class Boolean_antlrContext extends ParserRuleContext {
		public Boolean_antlr_redContext boolean_antlr_red() {
			return getRuleContext(Boolean_antlr_redContext.class,0);
		}
		public Boolean_antlr_expressionContext boolean_antlr_expression() {
			return getRuleContext(Boolean_antlr_expressionContext.class,0);
		}
		public Boolean_antlrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_antlr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterBoolean_antlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitBoolean_antlr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitBoolean_antlr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_antlrContext boolean_antlr() throws RecognitionException {
		Boolean_antlrContext _localctx = new Boolean_antlrContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_boolean_antlr);
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				boolean_antlr_red();
				}
				break;
			case BOOLEAN_FROM_EXPRESSION_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				boolean_antlr_expression();
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

	public static class Boolean_antlr_redContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_START() { return getToken(MapParser.BOOLEAN_START, 0); }
		public TerminalNode BOOLEAN_TRUE() { return getToken(MapParser.BOOLEAN_TRUE, 0); }
		public TerminalNode BOOLEAN_FALSE() { return getToken(MapParser.BOOLEAN_FALSE, 0); }
		public Boolean_antlr_redContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_antlr_red; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterBoolean_antlr_red(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitBoolean_antlr_red(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitBoolean_antlr_red(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_antlr_redContext boolean_antlr_red() throws RecognitionException {
		Boolean_antlr_redContext _localctx = new Boolean_antlr_redContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_boolean_antlr_red);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(BOOLEAN_START);
			setState(419);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN_TRUE || _la==BOOLEAN_FALSE) ) {
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

	public static class Boolean_antlr_expressionContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_FROM_EXPRESSION_START() { return getToken(MapParser.BOOLEAN_FROM_EXPRESSION_START, 0); }
		public TerminalNode BOOLEAN_FROM_EXPRESSION_TRUE() { return getToken(MapParser.BOOLEAN_FROM_EXPRESSION_TRUE, 0); }
		public TerminalNode BOOLEAN_FROM_EXPRESSION_FALSE() { return getToken(MapParser.BOOLEAN_FROM_EXPRESSION_FALSE, 0); }
		public Boolean_antlr_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_antlr_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).enterBoolean_antlr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapParserListener ) ((MapParserListener)listener).exitBoolean_antlr_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapParserVisitor ) return ((MapParserVisitor<? extends T>)visitor).visitBoolean_antlr_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_antlr_expressionContext boolean_antlr_expression() throws RecognitionException {
		Boolean_antlr_expressionContext _localctx = new Boolean_antlr_expressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_boolean_antlr_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(BOOLEAN_FROM_EXPRESSION_START);
			setState(422);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN_FROM_EXPRESSION_TRUE || _la==BOOLEAN_FROM_EXPRESSION_FALSE) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0096\u01ab\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\3\2\5\2m\n\2\3\2\5\2p\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\6\4y\n\4\r\4\16\4z\3\4\3\4\3\5\3\5\6\5\u0081\n\5\r\5\16\5\u0082\3\5"+
		"\3\5\3\6\3\6\6\6\u0089\n\6\r\6\16\6\u008a\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\7\7\u0095\n\7\f\7\16\7\u0098\13\7\3\7\3\7\3\b\3\b\3\t\3\t\6\t\u00a0"+
		"\n\t\r\t\16\t\u00a1\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\6\f\u00b8\n\f\r\f\16\f\u00b9\3\f\3"+
		"\f\6\f\u00be\n\f\r\f\16\f\u00bf\3\f\3\f\5\f\u00c4\n\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\5\21\u00d4\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u00e5\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00f0"+
		"\n\26\3\27\3\27\3\27\3\27\5\27\u00f6\n\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u010b\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u011e\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u0126\n\34\f\34\16\34\u0129\13\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u013c\n\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\5!\u014b\n!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0155\n\"\3\"\3\"\3#\3#\5#\u015b\n#\3$"+
		"\3$\3$\3$\3$\5$\u0162\n$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\5*\u017d\n*\3+\3+\3,\3,\3-\3-\3-\3"+
		"-\3-\5-\u0188\n-\3-\3-\3.\3.\3/\3/\3/\5/\u0191\n/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\5\63\u01a3"+
		"\n\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\2\2\66\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfh\2\7\3\2"+
		"AB\4\2gg\u0087\u0087\4\2~~\u0093\u0093\3\2\65\66\3\2\u0083\u0084\2\u019c"+
		"\2j\3\2\2\2\4q\3\2\2\2\6u\3\2\2\2\b~\3\2\2\2\n\u0086\3\2\2\2\f\u008e\3"+
		"\2\2\2\16\u009b\3\2\2\2\20\u009d\3\2\2\2\22\u00a5\3\2\2\2\24\u00b1\3\2"+
		"\2\2\26\u00b5\3\2\2\2\30\u00c7\3\2\2\2\32\u00cb\3\2\2\2\34\u00cd\3\2\2"+
		"\2\36\u00cf\3\2\2\2 \u00d3\3\2\2\2\"\u00d5\3\2\2\2$\u00da\3\2\2\2&\u00df"+
		"\3\2\2\2(\u00e8\3\2\2\2*\u00ef\3\2\2\2,\u00f5\3\2\2\2.\u00f9\3\2\2\2\60"+
		"\u0100\3\2\2\2\62\u010c\3\2\2\2\64\u0113\3\2\2\2\66\u011f\3\2\2\28\u012c"+
		"\3\2\2\2:\u0131\3\2\2\2<\u013d\3\2\2\2>\u0143\3\2\2\2@\u014a\3\2\2\2B"+
		"\u0154\3\2\2\2D\u015a\3\2\2\2F\u015c\3\2\2\2H\u0165\3\2\2\2J\u0168\3\2"+
		"\2\2L\u016c\3\2\2\2N\u0170\3\2\2\2P\u0175\3\2\2\2R\u017c\3\2\2\2T\u017e"+
		"\3\2\2\2V\u0180\3\2\2\2X\u0182\3\2\2\2Z\u018b\3\2\2\2\\\u0190\3\2\2\2"+
		"^\u0192\3\2\2\2`\u0198\3\2\2\2b\u019c\3\2\2\2d\u01a2\3\2\2\2f\u01a4\3"+
		"\2\2\2h\u01a7\3\2\2\2jl\5\4\3\2km\5\6\4\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2"+
		"\2np\5\b\5\2on\3\2\2\2op\3\2\2\2p\3\3\2\2\2qr\7\4\2\2rs\5.\30\2st\7\b"+
		"\2\2t\5\3\2\2\2ux\7\t\2\2vy\5\n\6\2wy\5\62\32\2xv\3\2\2\2xw\3\2\2\2yz"+
		"\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\n\2\2}\7\3\2\2\2~\u0080\7\22"+
		"\2\2\177\u0081\5,\27\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\23\2\2"+
		"\u0085\t\3\2\2\2\u0086\u0088\5\f\7\2\u0087\u0089\5*\26\2\u0088\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\5\16\b\2\u008d\13\3\2\2\2\u008e\u008f\7\13"+
		"\2\2\u008f\u0090\7\35\2\2\u0090\u0091\7\f\2\2\u0091\u0096\7\35\2\2\u0092"+
		"\u0093\7\r\2\2\u0093\u0095\7\35\2\2\u0094\u0092\3\2\2\2\u0095\u0098\3"+
		"\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\16\2\2\u009a\r\3\2\2\2\u009b\u009c\7;\2\2"+
		"\u009c\17\3\2\2\2\u009d\u009f\5\22\n\2\u009e\u00a0\5*\26\2\u009f\u009e"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\5\24\13\2\u00a4\21\3\2\2\2\u00a5\u00a6\7<\2"+
		"\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\7Q\2\2\u00a9\u00aa"+
		"\7?\2\2\u00aa\u00ab\7Q\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\7Q\2\2\u00ad"+
		"\u00ae\t\2\2\2\u00ae\u00af\78\2\2\u00af\u00b0\79\2\2\u00b0\23\3\2\2\2"+
		"\u00b1\u00b2\7=\2\2\u00b2\u00b3\7Q\2\2\u00b3\u00b4\7:\2\2\u00b4\25\3\2"+
		"\2\2\u00b5\u00b7\5\30\r\2\u00b6\u00b8\5*\26\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00c3\3\2"+
		"\2\2\u00bb\u00bd\5\32\16\2\u00bc\u00be\5*\26\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c2\5\34\17\2\u00c2\u00c4\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\5\36\20\2\u00c6\27\3\2"+
		"\2\2\u00c7\u00c8\7C\2\2\u00c8\u00c9\5 \21\2\u00c9\u00ca\7\u0089\2\2\u00ca"+
		"\31\3\2\2\2\u00cb\u00cc\7E\2\2\u00cc\33\3\2\2\2\u00cd\u00ce\7F\2\2\u00ce"+
		"\35\3\2\2\2\u00cf\u00d0\7D\2\2\u00d0\37\3\2\2\2\u00d1\u00d4\5\"\22\2\u00d2"+
		"\u00d4\5$\23\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4!\3\2\2\2"+
		"\u00d5\u00d6\7\u0086\2\2\u00d6\u00d7\5&\24\2\u00d7\u00d8\5R*\2\u00d8\u00d9"+
		"\5&\24\2\u00d9#\3\2\2\2\u00da\u00db\7\u0088\2\2\u00db\u00dc\5`\61\2\u00dc"+
		"\u00dd\5V,\2\u00dd\u00de\5`\61\2\u00de%\3\2\2\2\u00df\u00e0\7\u008b\2"+
		"\2\u00e0\u00e4\7\u008c\2\2\u00e1\u00e2\5(\25\2\u00e2\u00e3\7\u008c\2\2"+
		"\u00e3\u00e5\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e7\7\u008e\2\2\u00e7\'\3\2\2\2\u00e8\u00e9\7\u008d\2"+
		"\2\u00e9)\3\2\2\2\u00ea\u00f0\5\20\t\2\u00eb\u00f0\5\26\f\2\u00ec\u00f0"+
		"\5:\36\2\u00ed\u00f0\5\60\31\2\u00ee\u00f0\58\35\2\u00ef\u00ea\3\2\2\2"+
		"\u00ef\u00eb\3\2\2\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee"+
		"\3\2\2\2\u00f0+\3\2\2\2\u00f1\u00f6\5\62\32\2\u00f2\u00f6\5\64\33\2\u00f3"+
		"\u00f6\5\60\31\2\u00f4\u00f6\5\66\34\2\u00f5\u00f1\3\2\2\2\u00f5\u00f2"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f8\7\34\2\2\u00f8-\3\2\2\2\u00f9\u00fa\7\5\2\2\u00fa\u00fb\5`\61\2"+
		"\u00fb\u00fc\7\6\2\2\u00fc\u00fd\5^\60\2\u00fd\u00fe\7\7\2\2\u00fe\u00ff"+
		"\5b\62\2\u00ff/\3\2\2\2\u0100\u0101\7\31\2\2\u0101\u0102\7.\2\2\u0102"+
		"\u0103\7\25\2\2\u0103\u0104\5`\61\2\u0104\u0105\7\26\2\2\u0105\u0106\5"+
		"^\60\2\u0106\u0107\7M\2\2\u0107\u010a\5^\60\2\u0108\u0109\7\30\2\2\u0109"+
		"\u010b\5d\63\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\61\3\2\2"+
		"\2\u010c\u010d\7\17\2\2\u010d\u010e\7\35\2\2\u010e\u010f\7\20\2\2\u010f"+
		"\u0110\5`\61\2\u0110\u0111\7\21\2\2\u0111\u0112\7#\2\2\u0112\63\3\2\2"+
		"\2\u0113\u0114\7\24\2\2\u0114\u0115\7\35\2\2\u0115\u0116\7\25\2\2\u0116"+
		"\u0117\5`\61\2\u0117\u0118\7\26\2\2\u0118\u0119\5^\60\2\u0119\u011a\7"+
		"\27\2\2\u011a\u011d\5\\/\2\u011b\u011c\7\30\2\2\u011c\u011e\5d\63\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\65\3\2\2\2\u011f\u0120\7\32\2"+
		"\2\u0120\u0121\7\35\2\2\u0121\u0122\7\f\2\2\u0122\u0127\7\35\2\2\u0123"+
		"\u0124\7\r\2\2\u0124\u0126\7\35\2\2\u0125\u0123\3\2\2\2\u0126\u0129\3"+
		"\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u012b\7\33\2\2\u012b\67\3\2\2\2\u012c\u012d\7N\2"+
		"\2\u012d\u012e\7Q\2\2\u012e\u012f\7O\2\2\u012f\u0130\5B\"\2\u01309\3\2"+
		"\2\2\u0131\u0132\7G\2\2\u0132\u0133\7Q\2\2\u0133\u0134\7H\2\2\u0134\u0135"+
		"\5> \2\u0135\u0136\7I\2\2\u0136\u0137\5<\37\2\u0137\u0138\7J\2\2\u0138"+
		"\u013b\5@!\2\u0139\u013a\7K\2\2\u013a\u013c\5d\63\2\u013b\u0139\3\2\2"+
		"\2\u013b\u013c\3\2\2\2\u013c;\3\2\2\2\u013d\u013e\7W\2\2\u013e\u013f\7"+
		"X\2\2\u013f\u0140\7Y\2\2\u0140\u0141\7X\2\2\u0141\u0142\7Z\2\2\u0142="+
		"\3\2\2\2\u0143\u0144\7S\2\2\u0144\u0145\7T\2\2\u0145\u0146\7U\2\2\u0146"+
		"?\3\2\2\2\u0147\u014b\7\\\2\2\u0148\u0149\7]\2\2\u0149\u014b\5`\61\2\u014a"+
		"\u0147\3\2\2\2\u014a\u0148\3\2\2\2\u014bA\3\2\2\2\u014c\u0155\5D#\2\u014d"+
		"\u0155\5X-\2\u014e\u0155\5F$\2\u014f\u0155\5H%\2\u0150\u0155\7\35\2\2"+
		"\u0151\u0155\7k\2\2\u0152\u0155\5d\63\2\u0153\u0155\5L\'\2\u0154\u014c"+
		"\3\2\2\2\u0154\u014d\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3\2\2\2\u0154"+
		"\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\u0157\7e\2\2\u0157C\3\2\2\2\u0158\u015b"+
		"\5N(\2\u0159\u015b\5P)\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b"+
		"E\3\2\2\2\u015c\u015d\7v\2\2\u015d\u0161\7w\2\2\u015e\u015f\5Z.\2\u015f"+
		"\u0160\7w\2\2\u0160\u0162\3\2\2\2\u0161\u015e\3\2\2\2\u0161\u0162\3\2"+
		"\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7y\2\2\u0164G\3\2\2\2\u0165\u0166"+
		"\7{\2\2\u0166\u0167\7|\2\2\u0167I\3\2\2\2\u0168\u0169\7\177\2\2\u0169"+
		"\u016a\7\u0080\2\2\u016a\u016b\7\u0081\2\2\u016bK\3\2\2\2\u016c\u016d"+
		"\7j\2\2\u016d\u016e\7o\2\2\u016e\u016f\7p\2\2\u016fM\3\2\2\2\u0170\u0171"+
		"\7f\2\2\u0171\u0172\5F$\2\u0172\u0173\5R*\2\u0173\u0174\5F$\2\u0174O\3"+
		"\2\2\2\u0175\u0176\7h\2\2\u0176\u0177\5H%\2\u0177\u0178\5V,\2\u0178\u0179"+
		"\5J&\2\u0179Q\3\2\2\2\u017a\u017d\5T+\2\u017b\u017d\5V,\2\u017c\u017a"+
		"\3\2\2\2\u017c\u017b\3\2\2\2\u017dS\3\2\2\2\u017e\u017f\t\3\2\2\u017f"+
		"U\3\2\2\2\u0180\u0181\t\4\2\2\u0181W\3\2\2\2\u0182\u0183\7i\2\2\u0183"+
		"\u0187\7w\2\2\u0184\u0185\5Z.\2\u0185\u0186\7w\2\2\u0186\u0188\3\2\2\2"+
		"\u0187\u0184\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a"+
		"\7y\2\2\u018aY\3\2\2\2\u018b\u018c\7x\2\2\u018c[\3\2\2\2\u018d\u0191\7"+
		"\60\2\2\u018e\u018f\7\61\2\2\u018f\u0191\5`\61\2\u0190\u018d\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0191]\3\2\2\2\u0192\u0193\7&\2\2\u0193\u0194\7\'\2\2\u0194"+
		"\u0195\7(\2\2\u0195\u0196\7\'\2\2\u0196\u0197\7)\2\2\u0197_\3\2\2\2\u0198"+
		"\u0199\7 \2\2\u0199\u019a\7!\2\2\u019a\u019b\7\"\2\2\u019ba\3\2\2\2\u019c"+
		"\u019d\7*\2\2\u019d\u019e\7+\2\2\u019e\u019f\7,\2\2\u019fc\3\2\2\2\u01a0"+
		"\u01a3\5f\64\2\u01a1\u01a3\5h\65\2\u01a2\u01a0\3\2\2\2\u01a2\u01a1\3\2"+
		"\2\2\u01a3e\3\2\2\2\u01a4\u01a5\7\64\2\2\u01a5\u01a6\t\5\2\2\u01a6g\3"+
		"\2\2\2\u01a7\u01a8\7l\2\2\u01a8\u01a9\t\6\2\2\u01a9i\3\2\2\2\35loxz\u0082"+
		"\u008a\u0096\u00a1\u00b9\u00bf\u00c3\u00d3\u00e4\u00ef\u00f5\u010a\u011d"+
		"\u0127\u013b\u014a\u0154\u015a\u0161\u017c\u0187\u0190\u01a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}