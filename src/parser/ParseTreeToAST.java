package parser;

import ast.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import static parser.MapParser.*;

public class ParseTreeToAST extends MapParserBaseVisitor<Node> {

    @Override
    public Program visitProgram(ProgramContext ctx) {
        Map map = visitMap(ctx.map());
        definitions(ctx.def());
        PlaceAndCall placeAndCall = visitPlace_and_call(ctx.place_and_call());
        return new Program(map, placeAndCall);
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
    public PlaceAndCall visitPlace_and_call(Place_and_callContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        ArrayList<Statement> statements = new ArrayList<>();

        for (Place_statementContext placeStatementCtx
                : ctx.place_statement()) {
            Statement statement = visitPlace_statement(placeStatementCtx);
            if (statement != null) {
                statements.add(statement);
            }
        }
        return new PlaceAndCall(statements);
    }

    @Override
    public Statement visitPlace_statement(Place_statementContext ctx) {
        if (ctx.place_feature() != null) {
            return visitPlace_feature(ctx.place_feature());
        } else if (ctx.place_region() != null) {
            return visitPlace_region(ctx.place_region());
        } else if (ctx.function_call() != null) {
            return visitFunction_call(ctx.function_call());
        }
        return null;
    }

    @Override
    public Function visitFunction(FunctionContext ctx) {
        ArrayList<String> paramNames = new ArrayList<>();
        List<TerminalNode> textList = ctx.function_start().TEXT();
        String functionName = textList.get(0).getText();
        handleParamList(paramNames, textList);

        ArrayList<Statement> statements = new ArrayList<>();
        for (Function_statementContext functionStatementCtx: ctx.function_statement()) {
            Statement statement = visitFunction_statement(functionStatementCtx);
            if (statement != null) {
                statements.add(statement);
            }
        }

        return new Function(functionName, paramNames, statements);
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
        List<Statement> statements = new ArrayList<>();
        for (Function_statementContext functionStatementCtx
                : ctx.function_statement()) {
            Statement statement = visitFunction_statement(functionStatementCtx);
            if (statement != null) {
                statements.add(statement);
            }
        }
        return new Loop(name, variable, start, stop, counter, statements);
    }

    @Override
    public Conditional visitConditional(ConditionalContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        List<Statement> ifStatements = new ArrayList<>();
        List<Statement> elseStatements = new ArrayList<>();
        boolean inElse = false;
        for (int i = 0; i< ctx.children.size(); i ++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof Else_startContext) {
                inElse = true;
            } else if (child instanceof Function_statementContext context) {
                Statement statement = visitFunction_statement(context);
                if (statement != null) {
                    if (inElse) {
                        elseStatements.add(statement);
                    } else {
                        ifStatements.add(statement);
                    }
                }
            }
        }
        return new Conditional(ifStatements, elseStatements);
    }

    @Override
    public Statement visitFunction_statement(Function_statementContext ctx) {
        if (ctx.loop() != null) {
            return visitLoop(ctx.loop());
        } else if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment());
        } else if (ctx.conditional() != null) {
            return visitConditional(ctx.conditional());
        } else if (ctx.place_feature_from_func() != null) {
            return visitPlace_feature_from_func(ctx.place_feature_from_func());
        } else if (ctx.place_region_from_func() != null) {
            return visitPlace_region_from_func(ctx.place_region_from_func());
        }
        return null;
    }

    @Override
    public PlaceRegion visitPlace_region(Place_regionContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String regionType = ctx.REGION().getText();
        String regionName = ctx.quoted_text().QUOTED_TEXT().getText();
        XYTupleWithVariables location = visitXytuple(ctx.xytuple(0));
        XYTupleWithVariables dimensions = visitXytuple(ctx.xytuple(1));
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
        XYTupleWithVariables location = visitXytuple(ctx.xytuple());
        boolean onMap = ctx.area().quoted_text() == null || ctx.area().quoted_text().isEmpty();
        String regionName = null;
        if (!onMap) {
            regionName = ctx.area().quoted_text().QUOTED_TEXT().getText();
        } else {
            regionName = "map";
        }
        boolean displayLabels = true;
        if (ctx.boolean_antlr_reg() != null && !ctx.isEmpty()) {
            if (ctx.boolean_antlr_reg().BOOLEAN_FALSE() != null) {
                displayLabels = false;
            }
        }

        return new PlaceFeature(featureType, featureName, location, onMap, regionName, displayLabels);
    }

    @Override
    public FunctionCall visitFunction_call(Function_callContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        ArrayList<String> paramValueStrings = new ArrayList<>();
        List<TerminalNode> textList = ctx.TEXT();
        String functionName = textList.get(0).getText();
        handleParamList(paramValueStrings, textList);

        String[] paramNames = Program.retrieveParameterListForFunction(functionName);

        ArrayList<Variable<?>> parameters = new ArrayList<>();

        if (paramNames != null) {
            for (int i = 0; i < paramValueStrings.size(); i++) {
                try {
                    Integer paramIntValue = Integer.parseInt(paramValueStrings.get(i));
                    Variable<Integer> param = new Variable<>(paramNames[i], paramIntValue);
                    parameters.add(param);
                } catch (NumberFormatException e) {
                    Variable<String> param = new Variable<>(paramNames[i], paramValueStrings.get(i));
                    parameters.add(param);
                }
            }
        }

        return new FunctionCall(functionName, parameters);
    }

    @Override
    public Assignment visitAssignment(AssignmentContext ctx) {
        String variableName = ctx.FUNCTION_STATEMENT_TEXT_TEXT().getText();
        return new Assignment(variableName);
    }

    @Override
    public PlaceFeature visitPlace_feature_from_func(Place_feature_from_funcContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String featureType = ctx.FUNCTION_STATEMENT_TEXT_TEXT().getText();
        String featureName = ctx.quoted_text_func().FROM_FUNC_QUOTED_TEXT().getText();
        XYTupleWithVariables location = visitXytuple_func(ctx.xytuple_func());
        boolean onMap = ctx.area_func().quoted_text() == null || ctx.area_func().quoted_text().isEmpty();
        String regionName = null;
        if (!onMap) {
            regionName = ctx.area_func().quoted_text().QUOTED_TEXT().getText();
        }
        boolean displayLabels = true;
        if (ctx.boolean_antlr_func() != null && !ctx.isEmpty()) {
            if (ctx.boolean_antlr_func().BOOLEAN_FROM_FUNC_FALSE() != null) {
                displayLabels = false;
            }
        }

        return new PlaceFeature(featureType, featureName, location, onMap, regionName, displayLabels);
    }

    @Override
    public PlaceRegion visitPlace_region_from_func(Place_region_from_funcContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        String regionType = ctx.REGION_FROM_FUNC().getText();
        String regionName = ctx.quoted_text_func().FROM_FUNC_QUOTED_TEXT().getText();
        XYTupleWithVariables location = visitXytuple_func(ctx.xytuple_func(0));
        XYTupleWithVariables dimensions = visitXytuple_func(ctx.xytuple_func(1));
        boolean displayLabels = true;
        if (ctx.boolean_antlr_func() != null && !ctx.isEmpty()) {
            if (ctx.boolean_antlr_func().BOOLEAN_FROM_FUNC_FALSE() != null) {
                displayLabels = false;
            }
        }

        return new PlaceRegion(regionType, regionName, location, dimensions, displayLabels);
    }

    @Override
    public XYTupleWithVariables visitXytuple_func(Xytuple_funcContext ctx) {
        String x_str = ctx.FROM_FUNC_TUPLE_TEXT(0).getText();
        String y_str = ctx.FROM_FUNC_TUPLE_TEXT(1).getText();
        int x = (isInteger(x_str)) ? Integer.parseInt(x_str) : -1;
        int y = (isInteger(y_str)) ? Integer.parseInt(y_str) : -1;
        return new XYTupleWithVariables(x, y, x_str, y_str);
    }

    @Override
    public XYTupleWithVariables visitXytuple(XytupleContext ctx) {
        int x = Integer.parseInt(ctx.TUPLE_TEXT(0).getText());
        int y = Integer.parseInt(ctx.TUPLE_TEXT(1).getText());
        return new XYTupleWithVariables(x, y);
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
    public Node visitArea(AreaContext ctx) {
        return super.visitArea(ctx);
    }

    @Override
    public Node visitBoolean_antlr_expression(Boolean_antlr_expressionContext ctx) {
        return super.visitBoolean_antlr_expression(ctx);
    }

    //region Helpers
    public void definitions(DefContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return;
        }
        HashMap<String, Function> functionDefinitions = new HashMap<>();
        HashSet<DefineFeature> featureDefinitions = new HashSet<>();

        for (Define_featureContext defineFeatureCtx : ctx.define_feature()) {
            featureDefinitions.add(visitDefine_feature(defineFeatureCtx));
        }

        for (FunctionContext functionCtx : ctx.function()) {
            Function function = visitFunction(functionCtx);
            functionDefinitions.put(function.getFunctionName(), function);
        }

        Program.featureDefinitions = featureDefinitions;
        Program.functionDefinitions = functionDefinitions;
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
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
    //endregion

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
    public Node visitLoop_start(Loop_startContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitLoop_end(Loop_endContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitDef(DefContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }
    //endregion
}
