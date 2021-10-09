// Generated from /Users/kaicycle/bike-boy-does-school/CS410/Project1Group8/ProjectFiles/out/production/ProjectFiles/parser/MapParser.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MapParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MapParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MapParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MapParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(MapParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(MapParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#place_and_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_and_call(MapParser.Place_and_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MapParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#function_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_start(MapParser.Function_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#function_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_end(MapParser.Function_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(MapParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#loop_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_start(MapParser.Loop_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#loop_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_end(MapParser.Loop_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(MapParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#if_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_start(MapParser.If_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#else_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_start(MapParser.Else_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#else_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_end(MapParser.Else_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#if_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_end(MapParser.If_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#comparison_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_if(MapParser.Comparison_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_compare_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_compare_if(MapParser.Math_compare_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quote_compare_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote_compare_if(MapParser.Quote_compare_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_if(MapParser.Math_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_op_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_op_if(MapParser.Math_op_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#function_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_statement(MapParser.Function_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#place_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_statement(MapParser.Place_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#create_map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_map(MapParser.Create_mapContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#place_region}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_region(MapParser.Place_regionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#define_feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_feature(MapParser.Define_featureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#place_feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_feature(MapParser.Place_featureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(MapParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MapParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#place_feature_from_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_feature_from_func(MapParser.Place_feature_from_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#xytuple_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXytuple_func(MapParser.Xytuple_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quoted_text_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted_text_func(MapParser.Quoted_text_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#area_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArea_func(MapParser.Area_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MapParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#comparison_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_expressions(MapParser.Comparison_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_expression(MapParser.Math_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quoted_text_from_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted_text_from_expression(MapParser.Quoted_text_from_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quoted_text_from_expression_second}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted_text_from_expression_second(MapParser.Quoted_text_from_expression_secondContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quoted_text_for_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted_text_for_var(MapParser.Quoted_text_for_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_compare(MapParser.Math_compareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quote_compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote_compare(MapParser.Quote_compareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#comparison_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_op(MapParser.Comparison_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_comparison_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_comparison_op(MapParser.Math_comparison_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quote_comparison_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote_comparison_op(MapParser.Quote_comparison_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(MapParser.MathContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#math_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_op(MapParser.Math_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#area}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArea(MapParser.AreaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#xytuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXytuple(MapParser.XytupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#quoted_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted_text(MapParser.Quoted_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(MapParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#boolean_antlr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_antlr(MapParser.Boolean_antlrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#boolean_antlr_red}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_antlr_red(MapParser.Boolean_antlr_redContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#boolean_antlr_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_antlr_expression(MapParser.Boolean_antlr_expressionContext ctx);
}