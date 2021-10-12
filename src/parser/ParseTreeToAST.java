package parser;

import Helpers.ExecutionOrderContext;
import Helpers.StatementListEnum;
import ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.awt.*;
import java.util.HashSet;
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
        return new Map(mapDimensions, color, title);
    }

    @Override
    public Def visitDef(DefContext ctx) {
        HashSet<Function> functions = new HashSet<>();
        HashSet<DefineFeature> defineFeatures = new HashSet<>();

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
        ArrayList<ExecutionOrderContext> executionOrderList = new ArrayList<>();
        ArrayList<PlaceRegion> placeRegionList = new ArrayList<>();
        ArrayList<PlaceFeature> placeFeatureList = new ArrayList<>();
        ArrayList<FunctionCall> functionCallList = new ArrayList<>();

        for (Place_statementContext placeStatementCtx
                : ctx.place_statement()) {
            PlaceRegion placeRegion = visitPlace_region(placeStatementCtx.place_region());
            PlaceFeature placeFeature = visitPlace_feature(placeStatementCtx.place_feature());
            FunctionCall functionCall = visitFunction_call(placeStatementCtx.function_call());

            if (placeRegion != null) {
                placeRegionList.add(placeRegion);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.PLACE_REGION, placeRegionList.size() - 1));
            }
            if (placeFeature != null) {
                placeFeatureList.add(placeFeature);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.PLACE_FEATURE, placeFeatureList.size() - 1));
            }
            if (functionCall != null) {
                functionCallList.add(functionCall);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.FUNCTION_CALL, functionCallList.size() - 1));
            }
        }

        return new PlaceAndCall(placeRegionList, placeFeatureList, functionCallList, executionOrderList);
    }

    @Override
    public Function visitFunction(FunctionContext ctx) {
        ArrayList<ExecutionOrderContext> executionOrderList = new ArrayList<>();
        ArrayList<String> paramNames = new ArrayList<>();
        List<TerminalNode> textList = ctx.function_start().TEXT();
        String functionName = textList.get(0).getText();
        handleParamList(paramNames, textList);

        ArrayList<Loop> loops = new ArrayList<>();
        ArrayList<Conditional> conditionals = new ArrayList<>();
        ArrayList<PlaceFeature> placeFeatures = new ArrayList<>();
        ArrayList<PlaceRegion> placeRegions = new ArrayList<>();
        ArrayList<Assignment> assignments = new ArrayList<>();

        for (Function_statementContext functionStatementCtx
                : ctx.function_statement()) {
            Loop loop = visitLoop(functionStatementCtx.loop());
            Conditional conditional = visitConditional(functionStatementCtx.conditional());
            PlaceFeature placeFeature = visitPlace_feature_from_func(functionStatementCtx.place_feature_from_func());
            PlaceRegion placeRegion = visitPlace_region_from_func(functionStatementCtx.place_region_from_func());
            Assignment assignment = visitAssignment(functionStatementCtx.assignment());

            if (loop != null) {
                loops.add(loop);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.LOOP, loops.size() - 1));
            }
            if (conditional != null) {
                conditionals.add(conditional);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.CONDITIONAL, conditionals.size() - 1));
            }
            if (placeFeature != null) {
                placeFeatures.add(placeFeature);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.PLACE_FEATURE, placeFeatures.size() - 1));
            }
            if (placeRegion != null) {
                placeRegions.add(placeRegion);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.PLACE_REGION, placeRegions.size() - 1));
            }
            if (assignment != null) {
                assignments.add(assignment);
                executionOrderList.add(new ExecutionOrderContext(StatementListEnum.ASSIGNMENT, assignments.size() - 1));
            }
;        }

        return new Function(functionName, paramNames, executionOrderList);
    }

    @Override
    public Loop visitLoop(LoopContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        Loop_startContext loopStartCtx = ctx.loop_start();

        String name = loopStartCtx.FUNCTION_STATEMENT_TEXT_TEXT(0).getText();
        String variable = loopStartCtx.FUNCTION_STATEMENT_TEXT_TEXT(1).getText();
        String start = loopStartCtx.FUNCTION_STATEMENT_TEXT_TEXT(2).getText();
        String stop = loopStartCtx.FUNCTION_STATEMENT_TEXT_TEXT(3).getText();
        int counter = Integer.parseInt(loopStartCtx.FUNCTION_STATEMENT_NUM().getText());
        if (loopStartCtx.LOOP_DECREMENT() != null) {
            counter = -counter;
        }
        return new Loop(name, variable, start, stop, counter);
    }

    @Override
    public Conditional visitConditional(ConditionalContext ctx) {
        return new Conditional();
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
    public Assignment visitAssignment(AssignmentContext ctx) {
        return new Assignment();
    }

    @Override
    public PlaceFeature visitPlace_feature_from_func(Place_feature_from_funcContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String featureType = ctx.FUNCTION_STATEMENT_TEXT_TEXT().getText();
        String featureName = ctx.quoted_text_func().FROM_FUNC_QUOTED_TEXT().getText();
        XYTuple location = visitXytuple_func(ctx.xytuple_func());
        boolean onMap = ctx.area_func().quoted_text() == null || ctx.area_func().quoted_text().isEmpty();
        String regionName = null;
        if (!onMap) {
            regionName = ctx.area_func().quoted_text().QUOTED_TEXT().getText();
        }

        return new PlaceFeature(featureType, featureName, location, onMap, regionName);
    }

    @Override
    public PlaceRegion visitPlace_region_from_func(Place_region_from_funcContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String regionType = ctx.REGION_FROM_FUNC().getText();
        String regionName = ctx.quoted_text_func().FROM_FUNC_QUOTED_TEXT().getText();
        XYTuple location = visitXytuple_func(ctx.xytuple_func(0));
        XYTuple dimensions = visitXytuple_func(ctx.xytuple_func(1));
        boolean displayLabels = true;
        if (ctx.boolean_antlr_func() != null && !ctx.isEmpty()) {
            if (ctx.boolean_antlr_func().BOOLEAN_FROM_FUNC_FALSE() != null) {
                displayLabels = false;
            }
        }

        return new PlaceRegion(regionType, regionName, location, dimensions, displayLabels);
    }

    @Override
    public XYTuple visitXytuple_func(Xytuple_funcContext ctx) {
        int x = Integer.parseInt(ctx.FROM_FUNC_TUPLE_TEXT(0).getText());
        int y = Integer.parseInt(ctx.FROM_FUNC_TUPLE_TEXT(1).getText());
        return new XYTuple(x, y);
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
    public Node visitBoolean_antlr_reg(Boolean_antlr_regContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitBoolean_antlr_func(Boolean_antlr_funcContext ctx) {
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

    @Override
    public Node visitLoop_start(Loop_startContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitLoop_end(Loop_endContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }
    //endregion
}
