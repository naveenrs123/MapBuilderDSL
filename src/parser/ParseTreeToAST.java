package parser;

import ast.*;
import org.antlr.v4.runtime.tree.*;

public class ParseTreeToAST extends AbstractParseTreeVisitor<Node> implements MapParserVisitor<Node> {
    @Override
    public Node visitProgram(MapParser.ProgramContext ctx) {
        return null;
    }

    @Override
    public Node visitMap(MapParser.MapContext ctx) {
        return null;
    }

    @Override
    public Node visitDef(MapParser.DefContext ctx) {
        return null;
    }

    @Override
    public Node visitPlace_and_call(MapParser.Place_and_callContext ctx) {
        return null;
    }

    @Override
    public Node visitFunction(MapParser.FunctionContext ctx) {
        return null;
    }

    @Override
    public Node visitFunction_start(MapParser.Function_startContext ctx) {
        return null;
    }

    @Override
    public Node visitFunction_end(MapParser.Function_endContext ctx) {
        return null;
    }

    @Override
    public Node visitLoop(MapParser.LoopContext ctx) {
        return null;
    }

    @Override
    public Node visitLoop_start(MapParser.Loop_startContext ctx) {
        return null;
    }

    @Override
    public Node visitLoop_end(MapParser.Loop_endContext ctx) {
        return null;
    }

    @Override
    public Node visitConditional(MapParser.ConditionalContext ctx) {
        return null;
    }

    @Override
    public Node visitIf_start(MapParser.If_startContext ctx) {
        return null;
    }

    @Override
    public Node visitElse_start(MapParser.Else_startContext ctx) {
        return null;
    }

    @Override
    public Node visitElse_end(MapParser.Else_endContext ctx) {
        return null;
    }

    @Override
    public Node visitIf_end(MapParser.If_endContext ctx) {
        return null;
    }


    @Override
    public Node visitQuote_compare_start(MapParser.Quote_compare_startContext ctx) {
        return null;
    }

    @Override
    public Node visitMath_if(MapParser.Math_ifContext ctx) {
        return null;
    }


    @Override
    public Node visitPlace_feature_regular(MapParser.Place_feature_regularContext ctx) {
        return null;
    }

    @Override
    public Node visitFunction_statement(MapParser.Function_statementContext ctx) {
        return null;
    }

    @Override
    public Node visitPlace_statement(MapParser.Place_statementContext ctx) {
        return null;
    }

    @Override
    public Node visitCreate_map(MapParser.Create_mapContext ctx) {
        return null;
    }

    @Override
    public Node visitPlace_region(MapParser.Place_regionContext ctx) {
        return null;
    }

    @Override
    public Node visitDefine_feature(MapParser.Define_featureContext ctx) {
        return null;
    }

    @Override
    public Node visitPlace_feature(MapParser.Place_featureContext ctx) {
        return null;
    }

    @Override
    public Node visitFunction_call(MapParser.Function_callContext ctx) {
        return null;
    }

    @Override
    public Node visitAssignment(MapParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public Node visitPlace_feature_from_func(MapParser.Place_feature_from_funcContext ctx) {
        return null;
    }

    @Override
    public Node visitXytuple_func(MapParser.Xytuple_funcContext ctx) {
        return null;
    }

    @Override
    public Node visitXytuple_regular(MapParser.Xytuple_regularContext ctx) {
        return null;
    }

    @Override
    public Node visitQuoted_text_regular(MapParser.Quoted_text_regularContext ctx) {
        return null;
    }

    @Override
    public Node visitQuoted_text_func(MapParser.Quoted_text_funcContext ctx) {
        return null;
    }

    @Override
    public Node visitArea_func(MapParser.Area_funcContext ctx) {
        return null;
    }

    @Override
    public Node visitExpression(MapParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public Node visitComparison(MapParser.ComparisonContext ctx) {
        return null;
    }


    @Override
    public Node visitMath_expression(MapParser.Math_expressionContext ctx) {
        return null;
    }

    @Override
    public Node visitMath_compare_start(MapParser.Math_compare_startContext ctx) {
        return null;
    }

    @Override
    public Node visitQuoted_text_from_expression(MapParser.Quoted_text_from_expressionContext ctx) {
        return null;
    }

    @Override
    public Node visitQuoted_text_from_expression_second(MapParser.Quoted_text_from_expression_secondContext ctx) {
        return null;
    }

    @Override
    public Node visitQuoted_text_for_var(MapParser.Quoted_text_for_varContext ctx) {
        return null;
    }

    @Override
    public Node visitArea_regular(MapParser.Area_regularContext ctx) {
        return null;
    }

    @Override
    public Node visitMath_compare(MapParser.Math_compareContext ctx) {
        return null;
    }

    @Override
    public Node visitQuote_compare(MapParser.Quote_compareContext ctx) {
        return null;
    }

    @Override
    public Node visitComparison_op(MapParser.Comparison_opContext ctx) {
        return null;
    }

    @Override
    public Node visitMath_comparison_op(MapParser.Math_comparison_opContext ctx) {
        return null;
    }

    @Override
    public Node visitQuote_comparison_op(MapParser.Quote_comparison_opContext ctx) {
        return null;
    }

    @Override
    public Node visitMath(MapParser.MathContext ctx) {
        return null;
    }

    @Override
    public Node visitMath_op(MapParser.Math_opContext ctx) {
        return null;
    }

    @Override
    public Node visitArea(MapParser.AreaContext ctx) {
        return null;
    }

    @Override
    public Node visitXytuple(MapParser.XytupleContext ctx) {
        return null;
    }

    @Override
    public Node visitQuoted_text(MapParser.Quoted_textContext ctx) {
        return null;
    }

    @Override
    public Node visitColor(MapParser.ColorContext ctx) {
        return null;
    }

    @Override
    public Node visitBoolean_antlr(MapParser.Boolean_antlrContext ctx) {
        return null;
    }

    @Override
    public Node visitBoolean_antlr_red(MapParser.Boolean_antlr_redContext ctx) {
        return null;
    }

    @Override
    public Node visitBoolean_antlr_expression(MapParser.Boolean_antlr_expressionContext ctx) {
        return null;
    }

    @Override
    public Node visitMath_regular(MapParser.Math_regularContext ctx) {
        return null;
    }
}
