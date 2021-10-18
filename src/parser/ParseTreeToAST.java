package parser;

import helpers.ASTHelpers;
import ast.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static parser.MapParser.*;

public class ParseTreeToAST extends MapParserBaseVisitor<Node> {

    //region AST Visit Methods
    @Override
    public Program visitProgram(ProgramContext ctx) {
        Map map = visitMap(ctx.map());

        ArrayList<Def> defs = new ArrayList<>();

        if (canVisit(ctx.def())) {
            defs = definitions(ctx.def());
        }

        PlaceAndCall placeAndCall = null;
        if (canVisit(ctx.place_and_call())) {
            placeAndCall = visitPlace_and_call(ctx.place_and_call());
        }

        return new Program(map, placeAndCall, defs);
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
        ArrayList<Statement> statements = new ArrayList<>();
        for (Place_statementContext placeStatementCtx : ctx.place_statement()) {
            Statement statement = visitPlace_statement(placeStatementCtx);
            if (statement != null) {
                statements.add(statement);
            }
        }
        return new PlaceAndCall(statements);
    }

    @Override
    public Statement visitPlace_statement(Place_statementContext ctx) {
        if (canVisit(ctx.place_feature())) {
            return visitPlace_feature(ctx.place_feature());
        } else if (canVisit(ctx.place_region())) {
            return visitPlace_region(ctx.place_region());
        } else if (canVisit(ctx.function_call())) {
            return visitFunction_call(ctx.function_call());
        }
        return null;
    }

    @Override
    public DefineFunction visitFunction(FunctionContext ctx) {
        ArrayList<String> paramNames = new ArrayList<>();
        List<TerminalNode> textList = ctx.function_start().TEXT();
        String functionName = textList.get(0).getText();
        ASTHelpers.handleParamList(paramNames, textList);

        ArrayList<Statement> statements = new ArrayList<>();
        for (Function_statementContext functionStatementCtx : ctx.function_statement()) {
            Statement statement = visitFunction_statement(functionStatementCtx);
            if (statement != null) {
                statements.add(statement);
            }
        }

        return new DefineFunction(functionName, paramNames, statements);
    }

    @Override
    public Loop visitLoop(LoopContext ctx) {
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
        for (Function_statementContext functionStatementCtx : ctx.function_statement()) {
            Statement statement = visitFunction_statement(functionStatementCtx);
            if (statement != null) {
                statements.add(statement);
            }
        }
        return new Loop(name, variable, start, stop, counter, statements);
    }

    @Override
    public Conditional visitConditional(ConditionalContext ctx) {
        Comparison<?, ?> condition = visitIf_start(ctx.if_start());
        List<Statement> ifStatements = new ArrayList<>();
        List<Statement> elseStatements = new ArrayList<>();

        boolean inElse = false;
        for (int i = 0; i < ctx.children.size(); i++) {
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
        int separationIndex = ifStatements.size();
        ifStatements.addAll(elseStatements);

        return new Conditional(condition, ifStatements, separationIndex);
    }

    @Override
    public Comparison<?, ?> visitIf_start(If_startContext ctx) {
        if (canVisit(ctx.math_compare_if())) {
            return visitMath_compare_if(ctx.math_compare_if());
        } else if (canVisit(ctx.quote_compare_if())) {
            return visitQuote_compare_if(ctx.quote_compare_if());
        }
        return null;
    }

    @Override
    public Statement visitFunction_statement(Function_statementContext ctx) {
        if (canVisit(ctx.loop())) {
            return visitLoop(ctx.loop());
        } else if (canVisit(ctx.assignment())) {
            return visitAssignment(ctx.assignment());
        } else if (canVisit(ctx.conditional())) {
            return visitConditional(ctx.conditional());
        } else if (canVisit(ctx.place_feature_from_func())) {
            return visitPlace_feature_from_func(ctx.place_feature_from_func());
        } else if (canVisit(ctx.place_region_from_func())) {
            return visitPlace_region_from_func(ctx.place_region_from_func());
        }
        return null;
    }

    @Override
    public PlaceRegion visitPlace_region(Place_regionContext ctx) {
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
        String featureType = ctx.TEXT().getText();
        String icon = ctx.quoted_text().QUOTED_TEXT().getText();
        String size = ctx.SIZE().getText();
        return new DefineFeature(featureType, icon, size);
    }

    @Override
    public PlaceFeature visitPlace_feature(Place_featureContext ctx) {
        String featureType = ctx.TEXT().getText();
        String featureName = ctx.quoted_text().QUOTED_TEXT().getText();
        XYTupleWithVariables location = visitXytuple(ctx.xytuple());
        boolean onMap = ctx.area().quoted_text() == null || ctx.area().quoted_text().isEmpty();
        String regionName;
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
        ArrayList<String> paramValueStrings = new ArrayList<>();
        String functionName = ctx.TEXT().getText();
        for (TerminalNode param : ctx.NUM()) {
            paramValueStrings.add(param.getText());
        }
        return new FunctionCall(functionName, paramValueStrings);
    }

    @Override
    public Variable<?> visitAssignment(AssignmentContext ctx) {
        String variableName = ctx.FUNCTION_STATEMENT_TEXT_TEXT().getText();
        return handleExpressionForVariable(ctx.expression(), variableName);
    }

    @Override
    public PlaceFeature visitPlace_feature_from_func(Place_feature_from_funcContext ctx) {
        String featureType = ctx.FUNCTION_STATEMENT_TEXT_TEXT().getText();
        String featureName = ctx.quoted_text_func().FROM_FUNC_QUOTED_TEXT().getText();
        XYTupleWithVariables location = visitXytuple_func(ctx.xytuple_func());
        boolean onMap = ctx.area_func().quoted_text_func() == null || ctx.area_func().quoted_text_func().isEmpty();
        String regionName = null;
        if (!onMap) {
            regionName = ctx.area_func().quoted_text_func().FROM_FUNC_QUOTED_TEXT().getText();
        } else {
            regionName = "map";
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
        int x = (ASTHelpers.isInteger(x_str)) ? Integer.parseInt(x_str) : -1;
        int y = (ASTHelpers.isInteger(y_str)) ? Integer.parseInt(y_str) : -1;
        return new XYTupleWithVariables(x, y, x_str, y_str);
    }

    @Override
    public XYTupleWithVariables visitXytuple(XytupleContext ctx) {
        int x = Integer.parseInt(ctx.TUPLE_TEXT(0).getText());
        int y = Integer.parseInt(ctx.TUPLE_TEXT(1).getText());
        return new XYTupleWithVariables(x, y);
    }

    @Override
    public Comparison<String, String> visitQuote_compare(Quote_compareContext ctx) {
        String firstText = ctx.quoted_text_from_expression().QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT().getText();
        String secondText = ctx.quoted_text_from_expression_second().SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT().getText();
        String operator = retrieveQuoteComparisonOp(ctx.quote_comparison_op());
        return new Comparison<>(firstText, secondText, firstText, secondText, operator);
    }


    @Override
    public Comparison<String, String> visitQuote_compare_if(Quote_compare_ifContext ctx) {
        String firstText = ctx.quoted_text(0).QUOTED_TEXT().getText();
        String secondText = ctx.quoted_text(1).QUOTED_TEXT().getText();
        String operator = retrieveQuoteComparisonOp(ctx.quote_comparison_op());
        return new Comparison<>(firstText, secondText, firstText, secondText, operator);
    }

    @Override
    public Comparison<Integer, Integer> visitMath_compare(Math_compareContext ctx) {
        String firstMath = ctx.MATH_FROM_EXPRESSION_TEXT(0).getText();
        String secondMath = ctx.MATH_FROM_EXPRESSION_TEXT(1).getText();
        Integer firstVal = ASTHelpers.isInteger(firstMath) ? Integer.parseInt(firstMath) : null;
        Integer secondVal = ASTHelpers.isInteger(secondMath) ? Integer.parseInt(secondMath) : null;
        String operator = retrieveMathComparisonOp(ctx.math_comparison_op());
        return new Comparison<>(firstMath, secondMath, firstVal, secondVal, operator);
    }

    @Override
    public Comparison<Integer, Integer> visitMath_compare_if(Math_compare_ifContext ctx) {
        String firstMath = ctx.MATH_FROM_IF_TEXT(0).getText();
        String secondMath = ctx.MATH_FROM_IF_TEXT(1).getText();
        Integer firstVal = ASTHelpers.isInteger(firstMath) ? Integer.parseInt(firstMath) : null;
        Integer secondVal = ASTHelpers.isInteger(secondMath) ? Integer.parseInt(secondMath) : null;
        String operator = retrieveMathComparisonOp(ctx.math_comparison_op());
        return new Comparison<>(firstMath, secondMath, firstVal, secondVal, operator);
    }
    //endregion

    //region Helpers
    private boolean canVisit(ParserRuleContext ctx) {
        return ctx != null && !ctx.isEmpty();
    }

    private ArrayList<Def> definitions(DefContext ctx) {
        if (ctx == null || ctx.isEmpty()) {
            return null;
        }
        ArrayList<Def> defs = new ArrayList<>();

        for (int i = 0; i < ctx.children.size(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                continue;
            } else if (child instanceof Define_featureContext context) {
                defs.add(visitDefine_feature(context));
            } else if (child instanceof FunctionContext context) {
                defs.add(visitFunction(context));
            }
        }
        return defs;
    }

    private Variable<?> handleExpressionForVariable(ExpressionContext ctx, String variableName) {
        if (canVisit(ctx.quote_compare())) {
            return new Variable<>(variableName, visitQuote_compare(ctx.quote_compare()));
        } else if (canVisit(ctx.math_compare())) {
            return new Variable<>(variableName, visitMath_compare(ctx.math_compare()));
        } else if (canVisit(ctx.quoted_text_for_var())) {
            return new Variable<>(variableName, ctx.quoted_text_for_var().EXPRESSION_QUOTED_TEXT_FOR_VAR().getText());
        } else if (canVisit(ctx.boolean_antlr_expression())) {
            return new Variable<>(variableName, handleBooleanExpression(ctx.boolean_antlr_expression()));
        } else if (ctx.EXPRESSION_TEXT() != null) {
            String valText = ctx.EXPRESSION_TEXT().getText();
            boolean isInteger = ASTHelpers.isInteger(valText);
            Integer val = isInteger ? Integer.parseInt(valText) : null;
            if (isInteger) {
                return new Variable<>(variableName, val);
            } else {
                return new Variable<>(variableName, val, valText);
            }
        }
        return null;
    }

    private Boolean handleBooleanExpression(Boolean_antlr_expressionContext ctx) {
        String boolText = "";
        if (ctx.BOOLEAN_FROM_EXPRESSION_TRUE() != null) {
            boolText = ctx.BOOLEAN_FROM_EXPRESSION_TRUE().getText();
        } else if (ctx.BOOLEAN_FROM_EXPRESSION_FALSE() != null) {
            boolText = ctx.BOOLEAN_FROM_EXPRESSION_FALSE().getText();
        }
        // NOTE: This parsing will force anything that is not case-insensitive equivalent to "true" to equal false.
        return Boolean.parseBoolean(boolText);
    }

    private String retrieveQuoteComparisonOp(Quote_comparison_opContext ctx) {
        if (ctx.QUOTE_COMPARISON_OP_FROM_EXPRESSION() != null) {
            return ctx.QUOTE_COMPARISON_OP_FROM_EXPRESSION().getText();
        } else if (ctx.QUOTE_COMPARISON_OP_FROM_IF() != null) {
            return ctx.QUOTE_COMPARISON_OP_FROM_IF().getText();
        } else {
            return null;
        }
    }

    private String retrieveMathComparisonOp(Math_comparison_opContext ctx) {
        if (ctx.MATH_COMPARE_COMPARISON_OP() != null) {
            return ctx.MATH_COMPARE_COMPARISON_OP().getText();
        } else if (ctx.MATH_COMPARE_FROM_IF_COMPARISON_OP() != null) {
            return ctx.MATH_COMPARE_FROM_IF_COMPARISON_OP().getText();
        } else {
            return null;
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
    public Node visitArea(MapParser.AreaContext ctx) {
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

    @Override
    public Node visitQuoted_text_from_expression(Quoted_text_from_expressionContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitQuoted_text_from_expression_second(Quoted_text_from_expression_secondContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitExpression(ExpressionContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitElse_start(Else_startContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitElse_end(Else_endContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitIf_end(If_endContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitQuoted_text_func(Quoted_text_funcContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitArea_func(Area_funcContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitQuoted_text_for_var(Quoted_text_for_varContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitMath_comparison_op(Math_comparison_opContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }

    @Override
    public Node visitQuote_comparison_op(Quote_comparison_opContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }


    @Override
    public Node visitBoolean_antlr_expression(Boolean_antlr_expressionContext ctx) {
        throw new UnsupportedOperationException("This method is not used.");
    }
    //endregion
}
