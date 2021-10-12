package parser;

import ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static parser.MapParser.*;

public class ParseTreeToAST extends MapParserBaseVisitor<Node> {

    @Override
    public Program visitProgram(ProgramContext ctx) {
        Map map = visitMap(ctx.map());
        Def def = visitDef(ctx.def());
        PlaceAndCall placeAndCall = visitPlace_and_call(ctx.place_and_call());
        return new Program(map, def, placeAndCall);
    }

    @Override
    public Map visitMap(MapContext ctx) {
        return visitCreate_map(ctx.create_map());
    }

    @Override
    public Map visitCreate_map(Create_mapContext ctx) {
        String title = ctx.quoted_text().QUOTED_TEXT().getText();
        XYTuple mapDimensions = visitXytuple(ctx.xytuple());
        String colorText = ctx.color().COLOR_CODE().getSymbol().getText();
        Color color = new Color(Integer.parseInt(colorText, 16));
        return new Map(mapDimensions.getY(), mapDimensions.getX(), color, title);
    }

    @Override
    public Def visitDef(DefContext ctx) {
        ArrayList<Function> functions = new ArrayList<>();
        ArrayList<DefineFeature> defineFeatures = new ArrayList<>();

        for (Define_featureContext defineFeatureCtx
                : ctx.define_feature()) {
            defineFeatures.add(visitDefine_feature(defineFeatureCtx));
        }

        for (FunctionContext functionCtx
                : ctx.function()) {
            functions.add(visitFunction(functionCtx));
        }

        return new Def(functions, defineFeatures);
    }

    @Override
    public PlaceAndCall visitPlace_and_call(Place_and_callContext ctx) {
        ArrayList<PlaceRegion> placeRegionList = new ArrayList<>();
        ArrayList<PlaceFeature> placeFeatureList = new ArrayList<>();
        ArrayList<FunctionCall> functionCallList = new ArrayList<>();

        for (Place_statementContext placeStatementCtx
                : ctx.place_statement()) {
            PlaceRegion placeRegion = visitPlace_region(placeStatementCtx.place_region());
            PlaceFeature placeFeature = visitPlace_feature(placeStatementCtx.place_feature());
            FunctionCall functionCall = visitFunction_call(placeStatementCtx.function_call());

            if (placeRegion != null) placeRegionList.add(placeRegion);
            if (placeFeature != null) placeFeatureList.add(placeFeature);
            if (functionCall != null) functionCallList.add(functionCall);
        }

        return new PlaceAndCall(placeRegionList, placeFeatureList, functionCallList);
    }

    @Override
    public Function visitFunction(FunctionContext ctx) {
        ArrayList<String> paramNames = new ArrayList<>();
        ArrayList<Statement> functionStatements = new ArrayList<>();
        List<TerminalNode> textList = ctx.function_start().TEXT();
        String functionName = textList.get(0).getText();
        handleParamList(paramNames, textList);

        for (Function_statementContext functionStatementCtx
                : ctx.function_statement()) {
            functionStatements.add(visitFunction_statement(functionStatementCtx));
        }

        return new Function(functionName, paramNames, functionStatements);
    }

    @Override
    public Node visitLoop(LoopContext ctx) {
        return super.visitLoop(ctx);
    }

    @Override
    public Node visitLoop_start(Loop_startContext ctx) {
        return super.visitLoop_start(ctx);
    }

    @Override
    public Node visitLoop_end(Loop_endContext ctx) {
        return super.visitLoop_end(ctx);
    }

    @Override
    public Node visitConditional(ConditionalContext ctx) {
        return super.visitConditional(ctx);
    }

    @Override
    public Node visitIf_start(If_startContext ctx) {
        return super.visitIf_start(ctx);
    }

    @Override
    public Node visitElse_start(Else_startContext ctx) {
        return super.visitElse_start(ctx);
    }

    @Override
    public Node visitElse_end(Else_endContext ctx) {
        return super.visitElse_end(ctx);
    }

    @Override
    public Node visitIf_end(If_endContext ctx) {
        return super.visitIf_end(ctx);
    }

    @Override
    public Node visitComparison_if(Comparison_ifContext ctx) {
        return super.visitComparison_if(ctx);
    }

    @Override
    public Node visitMath_compare_if(Math_compare_ifContext ctx) {
        return super.visitMath_compare_if(ctx);
    }

    @Override
    public Node visitQuote_compare_if(Quote_compare_ifContext ctx) {
        return super.visitQuote_compare_if(ctx);
    }

    @Override
    public Node visitMath_if(Math_ifContext ctx) {
        return super.visitMath_if(ctx);
    }

    @Override
    public Node visitMath_op_if(Math_op_ifContext ctx) {
        return super.visitMath_op_if(ctx);
    }

    @Override
    public Statement visitFunction_statement(Function_statementContext ctx) {
        System.out.println(ctx.getChildCount());
        return null;
    }

    @Override
    public PlaceRegion visitPlace_region(Place_regionContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String regionType = ctx.REGION().getText();
        String regionName = ctx.quoted_text().QUOTED_TEXT().getText();
        XYTuple location = visitXytuple(ctx.xytuple(0));
        XYTuple dimensions = visitXytuple(ctx.xytuple(1));
        boolean displayLabels = true;
        if (ctx.boolean_antlr_reg() != null && !ctx.isEmpty()) {
            if (ctx.boolean_antlr_reg().BOOLEAN_FALSE() != null) {
                displayLabels = false;
            }
        }

        return new PlaceRegion(regionType, regionName, location, dimensions, displayLabels);
    }

    @Override
    public DefineFeature visitDefine_feature(Define_featureContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String featureType = ctx.TEXT().getText();
        String icon = ctx.quoted_text().QUOTED_TEXT().getText();
        int size = Integer.parseInt(ctx.NUM().getText());
        return new DefineFeature(featureType, icon, size);
    }

    @Override
    public PlaceFeature visitPlace_feature(Place_featureContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String featureType = ctx.TEXT().getText();
        String featureName = ctx.quoted_text().QUOTED_TEXT().getText();
        XYTuple location = visitXytuple(ctx.xytuple());
        boolean onMap = ctx.area().quoted_text() == null || ctx.area().quoted_text().isEmpty();
        String regionName = null;
        if (!onMap) {
            regionName = ctx.area().quoted_text().QUOTED_TEXT().getText();
        }

        return new PlaceFeature(featureType, featureName, location, onMap, regionName);
    }

    @Override
    public FunctionCall visitFunction_call(Function_callContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        ArrayList<String> paramValues = new ArrayList<>();
        List<TerminalNode> textList = ctx.TEXT();
        String functionName = textList.get(0).getText();
        handleParamList(paramValues, textList);

        return new FunctionCall(functionName, paramValues);
    }

    private void handleParamList(ArrayList<String> paramValues, List<TerminalNode> textList) {
        List<TerminalNode> params = textList.size() > 1
                ? textList.subList(1, textList.size())
                : null;

        if (params != null) {
            for (TerminalNode param : params) {
                paramValues.add(param.getText());
            }
        }
    }

    @Override
    public Node visitAssignment(AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public Node visitPlace_feature_from_func(Place_feature_from_funcContext ctx) {
        return super.visitPlace_feature_from_func(ctx);
    }

    @Override
    public XYTuple visitXytuple_func(Xytuple_funcContext ctx) {
        return new XYTuple(0,0);
    }

    @Override
    public Node visitQuoted_text_func(Quoted_text_funcContext ctx) {
        return super.visitQuoted_text_func(ctx);
    }

    @Override
    public Node visitArea_func(Area_funcContext ctx) {
        return super.visitArea_func(ctx);
    }

    @Override
    public Node visitExpression(ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Node visitComparison_expressions(Comparison_expressionsContext ctx) {
        return super.visitComparison_expressions(ctx);
    }

    @Override
    public Node visitMath_expression(Math_expressionContext ctx) {
        return super.visitMath_expression(ctx);
    }

    @Override
    public Node visitQuoted_text_from_expression(Quoted_text_from_expressionContext ctx) {
        return super.visitQuoted_text_from_expression(ctx);
    }

    @Override
    public Node visitQuoted_text_from_expression_second(Quoted_text_from_expression_secondContext ctx) {
        return super.visitQuoted_text_from_expression_second(ctx);
    }

    @Override
    public Node visitQuoted_text_for_var(Quoted_text_for_varContext ctx) {
        return super.visitQuoted_text_for_var(ctx);
    }

    @Override
    public Node visitMath_compare(Math_compareContext ctx) {
        return super.visitMath_compare(ctx);
    }

    @Override
    public Node visitQuote_compare(Quote_compareContext ctx) {
        return super.visitQuote_compare(ctx);
    }

    @Override
    public Node visitComparison_op(Comparison_opContext ctx) {
        return super.visitComparison_op(ctx);
    }

    @Override
    public Node visitMath_comparison_op(Math_comparison_opContext ctx) {
        return super.visitMath_comparison_op(ctx);
    }

    @Override
    public Node visitQuote_comparison_op(Quote_comparison_opContext ctx) {
        return super.visitQuote_comparison_op(ctx);
    }

    @Override
    public Node visitMath(MathContext ctx) {
        return super.visitMath(ctx);
    }

    @Override
    public Node visitMath_op(Math_opContext ctx) {
        return super.visitMath_op(ctx);
    }

    @Override
    public Node visitArea(AreaContext ctx) {
        return super.visitArea(ctx);
    }

    @Override
    public XYTuple visitXytuple(XytupleContext ctx) {
        int x = Integer.parseInt(ctx.TUPLE_TEXT(0).getText());
        int y = Integer.parseInt(ctx.TUPLE_TEXT(1).getText());
        return new XYTuple(x, y);
    }

    @Override
    public Node visitBoolean_antlr_expression(Boolean_antlr_expressionContext ctx) {
        return super.visitBoolean_antlr_expression(ctx);
    }

    //region Unused Methods
    @Override
    public Node visitQuoted_text(Quoted_textContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitColor(ColorContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitFunction_start(Function_startContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitFunction_end(Function_endContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Statement visitPlace_statement(Place_statementContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }
    //endregion
}
