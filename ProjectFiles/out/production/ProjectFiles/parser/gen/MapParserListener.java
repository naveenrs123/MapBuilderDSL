// Generated from /Users/kaicycle/bike-boy-does-school/CS410/Project1Group8/ProjectFiles/out/production/ProjectFiles/parser/MapParser.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MapParser}.
 */
public interface MapParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MapParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MapParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MapParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(MapParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(MapParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(MapParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(MapParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#place_and_call}.
	 * @param ctx the parse tree
	 */
	void enterPlace_and_call(MapParser.Place_and_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#place_and_call}.
	 * @param ctx the parse tree
	 */
	void exitPlace_and_call(MapParser.Place_and_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MapParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MapParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#function_start}.
	 * @param ctx the parse tree
	 */
	void enterFunction_start(MapParser.Function_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#function_start}.
	 * @param ctx the parse tree
	 */
	void exitFunction_start(MapParser.Function_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#function_end}.
	 * @param ctx the parse tree
	 */
	void enterFunction_end(MapParser.Function_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#function_end}.
	 * @param ctx the parse tree
	 */
	void exitFunction_end(MapParser.Function_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(MapParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(MapParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#loop_start}.
	 * @param ctx the parse tree
	 */
	void enterLoop_start(MapParser.Loop_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#loop_start}.
	 * @param ctx the parse tree
	 */
	void exitLoop_start(MapParser.Loop_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#loop_end}.
	 * @param ctx the parse tree
	 */
	void enterLoop_end(MapParser.Loop_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#loop_end}.
	 * @param ctx the parse tree
	 */
	void exitLoop_end(MapParser.Loop_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(MapParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(MapParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#if_start}.
	 * @param ctx the parse tree
	 */
	void enterIf_start(MapParser.If_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#if_start}.
	 * @param ctx the parse tree
	 */
	void exitIf_start(MapParser.If_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#else_start}.
	 * @param ctx the parse tree
	 */
	void enterElse_start(MapParser.Else_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#else_start}.
	 * @param ctx the parse tree
	 */
	void exitElse_start(MapParser.Else_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#else_end}.
	 * @param ctx the parse tree
	 */
	void enterElse_end(MapParser.Else_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#else_end}.
	 * @param ctx the parse tree
	 */
	void exitElse_end(MapParser.Else_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#if_end}.
	 * @param ctx the parse tree
	 */
	void enterIf_end(MapParser.If_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#if_end}.
	 * @param ctx the parse tree
	 */
	void exitIf_end(MapParser.If_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#comparison_if}.
	 * @param ctx the parse tree
	 */
	void enterComparison_if(MapParser.Comparison_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#comparison_if}.
	 * @param ctx the parse tree
	 */
	void exitComparison_if(MapParser.Comparison_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_compare_if}.
	 * @param ctx the parse tree
	 */
	void enterMath_compare_if(MapParser.Math_compare_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_compare_if}.
	 * @param ctx the parse tree
	 */
	void exitMath_compare_if(MapParser.Math_compare_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quote_compare_if}.
	 * @param ctx the parse tree
	 */
	void enterQuote_compare_if(MapParser.Quote_compare_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quote_compare_if}.
	 * @param ctx the parse tree
	 */
	void exitQuote_compare_if(MapParser.Quote_compare_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_if}.
	 * @param ctx the parse tree
	 */
	void enterMath_if(MapParser.Math_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_if}.
	 * @param ctx the parse tree
	 */
	void exitMath_if(MapParser.Math_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_op_if}.
	 * @param ctx the parse tree
	 */
	void enterMath_op_if(MapParser.Math_op_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_op_if}.
	 * @param ctx the parse tree
	 */
	void exitMath_op_if(MapParser.Math_op_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#function_statement}.
	 * @param ctx the parse tree
	 */
	void enterFunction_statement(MapParser.Function_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#function_statement}.
	 * @param ctx the parse tree
	 */
	void exitFunction_statement(MapParser.Function_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#place_statement}.
	 * @param ctx the parse tree
	 */
	void enterPlace_statement(MapParser.Place_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#place_statement}.
	 * @param ctx the parse tree
	 */
	void exitPlace_statement(MapParser.Place_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#create_map}.
	 * @param ctx the parse tree
	 */
	void enterCreate_map(MapParser.Create_mapContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#create_map}.
	 * @param ctx the parse tree
	 */
	void exitCreate_map(MapParser.Create_mapContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#place_region}.
	 * @param ctx the parse tree
	 */
	void enterPlace_region(MapParser.Place_regionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#place_region}.
	 * @param ctx the parse tree
	 */
	void exitPlace_region(MapParser.Place_regionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#define_feature}.
	 * @param ctx the parse tree
	 */
	void enterDefine_feature(MapParser.Define_featureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#define_feature}.
	 * @param ctx the parse tree
	 */
	void exitDefine_feature(MapParser.Define_featureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#place_feature}.
	 * @param ctx the parse tree
	 */
	void enterPlace_feature(MapParser.Place_featureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#place_feature}.
	 * @param ctx the parse tree
	 */
	void exitPlace_feature(MapParser.Place_featureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(MapParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(MapParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MapParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MapParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#place_feature_from_func}.
	 * @param ctx the parse tree
	 */
	void enterPlace_feature_from_func(MapParser.Place_feature_from_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#place_feature_from_func}.
	 * @param ctx the parse tree
	 */
	void exitPlace_feature_from_func(MapParser.Place_feature_from_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#xytuple_func}.
	 * @param ctx the parse tree
	 */
	void enterXytuple_func(MapParser.Xytuple_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#xytuple_func}.
	 * @param ctx the parse tree
	 */
	void exitXytuple_func(MapParser.Xytuple_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quoted_text_func}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_text_func(MapParser.Quoted_text_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quoted_text_func}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_text_func(MapParser.Quoted_text_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#area_func}.
	 * @param ctx the parse tree
	 */
	void enterArea_func(MapParser.Area_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#area_func}.
	 * @param ctx the parse tree
	 */
	void exitArea_func(MapParser.Area_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MapParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MapParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#comparison_expressions}.
	 * @param ctx the parse tree
	 */
	void enterComparison_expressions(MapParser.Comparison_expressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#comparison_expressions}.
	 * @param ctx the parse tree
	 */
	void exitComparison_expressions(MapParser.Comparison_expressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_expression}.
	 * @param ctx the parse tree
	 */
	void enterMath_expression(MapParser.Math_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_expression}.
	 * @param ctx the parse tree
	 */
	void exitMath_expression(MapParser.Math_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quoted_text_from_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_text_from_expression(MapParser.Quoted_text_from_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quoted_text_from_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_text_from_expression(MapParser.Quoted_text_from_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quoted_text_from_expression_second}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_text_from_expression_second(MapParser.Quoted_text_from_expression_secondContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quoted_text_from_expression_second}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_text_from_expression_second(MapParser.Quoted_text_from_expression_secondContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quoted_text_for_var}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_text_for_var(MapParser.Quoted_text_for_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quoted_text_for_var}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_text_for_var(MapParser.Quoted_text_for_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_compare}.
	 * @param ctx the parse tree
	 */
	void enterMath_compare(MapParser.Math_compareContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_compare}.
	 * @param ctx the parse tree
	 */
	void exitMath_compare(MapParser.Math_compareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quote_compare}.
	 * @param ctx the parse tree
	 */
	void enterQuote_compare(MapParser.Quote_compareContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quote_compare}.
	 * @param ctx the parse tree
	 */
	void exitQuote_compare(MapParser.Quote_compareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#comparison_op}.
	 * @param ctx the parse tree
	 */
	void enterComparison_op(MapParser.Comparison_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#comparison_op}.
	 * @param ctx the parse tree
	 */
	void exitComparison_op(MapParser.Comparison_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_comparison_op}.
	 * @param ctx the parse tree
	 */
	void enterMath_comparison_op(MapParser.Math_comparison_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_comparison_op}.
	 * @param ctx the parse tree
	 */
	void exitMath_comparison_op(MapParser.Math_comparison_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quote_comparison_op}.
	 * @param ctx the parse tree
	 */
	void enterQuote_comparison_op(MapParser.Quote_comparison_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quote_comparison_op}.
	 * @param ctx the parse tree
	 */
	void exitQuote_comparison_op(MapParser.Quote_comparison_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMath(MapParser.MathContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMath(MapParser.MathContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#math_op}.
	 * @param ctx the parse tree
	 */
	void enterMath_op(MapParser.Math_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#math_op}.
	 * @param ctx the parse tree
	 */
	void exitMath_op(MapParser.Math_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#area}.
	 * @param ctx the parse tree
	 */
	void enterArea(MapParser.AreaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#area}.
	 * @param ctx the parse tree
	 */
	void exitArea(MapParser.AreaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#xytuple}.
	 * @param ctx the parse tree
	 */
	void enterXytuple(MapParser.XytupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#xytuple}.
	 * @param ctx the parse tree
	 */
	void exitXytuple(MapParser.XytupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#quoted_text}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_text(MapParser.Quoted_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#quoted_text}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_text(MapParser.Quoted_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(MapParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(MapParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#boolean_antlr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_antlr(MapParser.Boolean_antlrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#boolean_antlr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_antlr(MapParser.Boolean_antlrContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#boolean_antlr_red}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_antlr_red(MapParser.Boolean_antlr_redContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#boolean_antlr_red}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_antlr_red(MapParser.Boolean_antlr_redContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#boolean_antlr_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_antlr_expression(MapParser.Boolean_antlr_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#boolean_antlr_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_antlr_expression(MapParser.Boolean_antlr_expressionContext ctx);
}