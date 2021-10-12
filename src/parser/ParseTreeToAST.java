package parser;

import ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ParseTreeToAST extends MapParserBaseVisitor<Node> {

    @Override
    public Program visitProgram(MapParser.ProgramContext ctx) {
        Map map = visitMap(ctx.map());
        Def def = visitDef(ctx.def());
        PlaceAndCall placeAndCall = visitPlace_and_call(ctx.place_and_call());
        return new Program(map, def, placeAndCall);
    }

    @Override
    public Map visitMap(MapParser.MapContext ctx) {
        return visitCreate_map(ctx.create_map());
    }

    @Override
    public Map visitCreate_map(MapParser.Create_mapContext ctx) {
        String title = ctx.quoted_text().getText();
        XYTuple xyTuple = visitXytuple(ctx.xytuple());
        String colorText = ctx.color().COLOR_CODE().getSymbol().getText();
        Color color = new Color(Integer.parseInt(colorText, 16));
        return new Map(xyTuple.getY(), xyTuple.getX(), color, title);
    }

    @Override
    public Def visitDef(MapParser.DefContext ctx) {
        ArrayList<Function> functions = new ArrayList<>();
        ArrayList<DefineFeature> defineFeatures = new ArrayList<>();

        for (MapParser.Define_featureContext defineFeatureCtx
                : ctx.define_feature()) {
            defineFeatures.add(visitDefine_feature(defineFeatureCtx));
        }

        for (MapParser.FunctionContext functionCtx
                : ctx.function()) {
            functions.add(visitFunction(functionCtx));
        }

        return new Def(functions, defineFeatures);
    }

    @Override
    public PlaceAndCall visitPlace_and_call(MapParser.Place_and_callContext ctx) {
        ArrayList<Statement> placeStatements = new ArrayList<>();

        for (MapParser.Place_statementContext placeStatementCtx
                : ctx.place_statement()) {
            placeStatements.add(visitPlace_statement(placeStatementCtx));
        }

        return new PlaceAndCall(placeStatements);
    }

    @Override
    public Statement visitPlace_statement(MapParser.Place_statementContext ctx) {
        DefineFeature defineFeature = visitDefine_feature(ctx.define_feature());
        PlaceFeature placeFeature = visitPlace_feature(ctx.place_feature());
        PlaceRegion placeRegion = visitPlace_region(ctx.place_region());
        FunctionCall functionCall = visitFunction_call(ctx.function_call());

        if (defineFeature != null) return defineFeature;
        if (placeFeature != null) return placeFeature;
        if (placeRegion != null) return placeRegion;
        return functionCall;
    }

    @Override
    public Function visitFunction(MapParser.FunctionContext ctx) {
        ArrayList<String> paramNames = new ArrayList<>();
        ArrayList<Statement> functionStatements = new ArrayList<>();

        List<TerminalNode> textList = ctx.function_start().TEXT();
        String functionName = textList.get(0).getText();

        List<TerminalNode> params = textList.size() > 1
                ? textList.subList(1, textList.size())
                : null;

        if (params != null) {
            for (TerminalNode param : params) {
                paramNames.add(param.getText());
            }
        }

        for (MapParser.Function_statementContext functionStatementCtx
                : ctx.function_statement()) {
            functionStatements.add(visitFunction_statement(functionStatementCtx));
        }

        return new Function(functionName, paramNames, functionStatements);
    }

    @Override
    public Node visitLoop(MapParser.LoopContext ctx) {
        return super.visitLoop(ctx);
    }

    @Override
    public Node visitLoop_start(MapParser.Loop_startContext ctx) {
        return super.visitLoop_start(ctx);
    }

    @Override
    public Node visitLoop_end(MapParser.Loop_endContext ctx) {
        return super.visitLoop_end(ctx);
    }

    @Override
    public Node visitConditional(MapParser.ConditionalContext ctx) {
        return super.visitConditional(ctx);
    }

    @Override
    public Node visitIf_start(MapParser.If_startContext ctx) {
        return super.visitIf_start(ctx);
    }

    @Override
    public Node visitElse_start(MapParser.Else_startContext ctx) {
        return super.visitElse_start(ctx);
    }

    @Override
    public Node visitElse_end(MapParser.Else_endContext ctx) {
        return super.visitElse_end(ctx);
    }

    @Override
    public Node visitIf_end(MapParser.If_endContext ctx) {
        return super.visitIf_end(ctx);
    }

    @Override
    public Node visitComparison_if(MapParser.Comparison_ifContext ctx) {
        return super.visitComparison_if(ctx);
    }

    @Override
    public Node visitMath_compare_if(MapParser.Math_compare_ifContext ctx) {
        return super.visitMath_compare_if(ctx);
    }

    @Override
    public Node visitQuote_compare_if(MapParser.Quote_compare_ifContext ctx) {
        return super.visitQuote_compare_if(ctx);
    }

    @Override
    public Node visitMath_if(MapParser.Math_ifContext ctx) {
        return super.visitMath_if(ctx);
    }

    @Override
    public Node visitMath_op_if(MapParser.Math_op_ifContext ctx) {
        return super.visitMath_op_if(ctx);
    }

    @Override
    public Statement visitFunction_statement(MapParser.Function_statementContext ctx) {
        System.out.println(ctx.getChildCount());
        return null;
    }

    @Override
    public PlaceRegion visitPlace_region(MapParser.Place_regionContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        return new PlaceRegion();
    }

    @Override
    public DefineFeature visitDefine_feature(MapParser.Define_featureContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String featureType = ctx.TEXT().getText();
        String icon = ctx.quoted_text().getText();
        int size = Integer.parseInt(ctx.NUM().getText());
        return new DefineFeature(featureType, icon, size);
    }

    @Override
    public PlaceFeature visitPlace_feature(MapParser.Place_featureContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        return new PlaceFeature();
    }

    @Override
    public FunctionCall visitFunction_call(MapParser.Function_callContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        return new FunctionCall();
    }

    @Override
    public Node visitAssignment(MapParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public Node visitPlace_feature_from_func(MapParser.Place_feature_from_funcContext ctx) {
        return super.visitPlace_feature_from_func(ctx);
    }

    @Override
    public XYTuple visitXytuple_func(MapParser.Xytuple_funcContext ctx) {
        return new XYTuple(0,0);
    }

    @Override
    public Node visitQuoted_text_func(MapParser.Quoted_text_funcContext ctx) {
        return super.visitQuoted_text_func(ctx);
    }

    @Override
    public Node visitArea_func(MapParser.Area_funcContext ctx) {
        return super.visitArea_func(ctx);
    }

    @Override
    public Node visitExpression(MapParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Node visitComparison_expressions(MapParser.Comparison_expressionsContext ctx) {
        return super.visitComparison_expressions(ctx);
    }

    @Override
    public Node visitMath_expression(MapParser.Math_expressionContext ctx) {
        return super.visitMath_expression(ctx);
    }

    @Override
    public Node visitQuoted_text_from_expression(MapParser.Quoted_text_from_expressionContext ctx) {
        return super.visitQuoted_text_from_expression(ctx);
    }

    @Override
    public Node visitQuoted_text_from_expression_second(MapParser.Quoted_text_from_expression_secondContext ctx) {
        return super.visitQuoted_text_from_expression_second(ctx);
    }

    @Override
    public Node visitQuoted_text_for_var(MapParser.Quoted_text_for_varContext ctx) {
        return super.visitQuoted_text_for_var(ctx);
    }

    @Override
    public Node visitMath_compare(MapParser.Math_compareContext ctx) {
        return super.visitMath_compare(ctx);
    }

    @Override
    public Node visitQuote_compare(MapParser.Quote_compareContext ctx) {
        return super.visitQuote_compare(ctx);
    }

    @Override
    public Node visitComparison_op(MapParser.Comparison_opContext ctx) {
        return super.visitComparison_op(ctx);
    }

    @Override
    public Node visitMath_comparison_op(MapParser.Math_comparison_opContext ctx) {
        return super.visitMath_comparison_op(ctx);
    }

    @Override
    public Node visitQuote_comparison_op(MapParser.Quote_comparison_opContext ctx) {
        return super.visitQuote_comparison_op(ctx);
    }

    @Override
    public Node visitMath(MapParser.MathContext ctx) {
        return super.visitMath(ctx);
    }

    @Override
    public Node visitMath_op(MapParser.Math_opContext ctx) {
        return super.visitMath_op(ctx);
    }

    @Override
    public Node visitArea(MapParser.AreaContext ctx) {
        return super.visitArea(ctx);
    }

    @Override
    public XYTuple visitXytuple(MapParser.XytupleContext ctx) {
        int x = Integer.parseInt(ctx.TUPLE_TEXT(0).getText());
        int y = Integer.parseInt(ctx.TUPLE_TEXT(1).getText());
        return new XYTuple(x, y);
    }

    @Override
    public Node visitBoolean_antlr(MapParser.Boolean_antlrContext ctx) {
        return super.visitBoolean_antlr(ctx);
    }

    @Override
    public Node visitBoolean_antlr_red(MapParser.Boolean_antlr_redContext ctx) {
        return super.visitBoolean_antlr_red(ctx);
    }

    @Override
    public Node visitBoolean_antlr_expression(MapParser.Boolean_antlr_expressionContext ctx) {
        return super.visitBoolean_antlr_expression(ctx);
    }

    //region Unused Methods
    @Override
    public Node visitQuoted_text(MapParser.Quoted_textContext ctx) {
        return null;
    }

    @Override
    public Node visitColor(MapParser.ColorContext ctx) {
        return null;
    }

    @Override
    public Node visitFunction_start(MapParser.Function_startContext ctx) {
        return super.visitFunction_start(ctx);
    }

    @Override
    public Node visitFunction_end(MapParser.Function_endContext ctx) {
        return super.visitFunction_end(ctx);
    }
    //endregion
}
