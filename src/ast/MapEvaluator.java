package ast;

import helpers.ASTHelpers;
import model.*;
import org.stringtemplate.v4.ST;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map;

public class MapEvaluator<T> implements MapVisitor<T> {

    public static Map<String, Region> regions = new HashMap<>();
    public static Map<String, Feature> features = new HashMap<>();
    public static ArrayList<Placement> placements = new ArrayList<>();
    public static Map<String, Object> variables = new HashMap<>();
    public static Map<String, DefineFunction> functionDefs = new HashMap<>();
    public static Map<String, Map<String, Variable<?>>> funCalls = new HashMap<>();
    public static WorldMap map;

    @Override
    public T visit(Program p) {
        p.getMap().accept(this);
        for (Def def: p.getDefs()) {
            def.accept(this);
        }
        p.getPlaceAndCall().accept(this);
        return null;
    }

    @Override
    public T visit(ast.Map p) {
        String title = p.getTitle();
        Color color = p.getColor();
        int height = p.getHeight();
        int width = p.getWidth();
        map = new WorldMap(height, width, color, title);
        return null;
    }

    @Override
    public T visit(Def p) {
        if (p instanceof DefineFeature) {
            p.accept(this);
        } else if (p instanceof DefineFunction) {
            p.accept(this);
        }
        return null;
    }

    @Override
    public T visit(DefineFeature p) {
        String name = p.getFeatureType();
        String icon = p.getIcon();
        String size = p.getSize();
        FeatureSize featureSize = FeatureSize.valueOf(size.toUpperCase());
        Feature feature = new Feature(name, icon, featureSize);
        features.put(name, feature);
        return null;
    }

    @Override
    public T visit(DefineFunction p) {
        functionDefs.put(p.getFunctionName(), p);
        for (Statement statement: p.getStatements()) {
            statement.setParamNames(p.getParamNames());
            statement.setFunctionName(p.getFunctionName());
            statement.accept(this);
        }
        return null;
    }

    @Override
    public T visit(Loop p) {
        if (p.isEvaluate()) {
            String funName = p.getFunctionName();
            String variable = p.getVariable();
            int start = (ASTHelpers.isInteger(p.getStart())) ? Integer.parseInt(p.getStart()): handleVariable(p.getStart(), funName);
            int end = (ASTHelpers.isInteger(p.getStop())) ? Integer.parseInt(p.getStart()): handleVariable(p.getStop(), funName);
            int counter = p.getCounter();

            for (int i = start; i < end; i += counter) {
                for (Statement statement: p.getStatements()) {
                    updateFunCall(variable, new Variable<Integer>(variable, i), funName);
                    statement.addParamValue(variable, Integer.toString(i));
                    statement.setEvaluate(true);
                    statement.accept(this);
                }
            }
            removeVariable(variable, funName);
        } else {
            for (Statement statement: p.getStatements()) {
                statement.setFunctionName(p.getFunctionName());
                statement.accept(this);
            }
        }

        return null;
    }

    @Override
    public T visit(Conditional p) {
        if (p.isEvaluate()) {
            boolean comparisonResult = handleComparison(p.getCondition(), p.getFunctionName());
            if (comparisonResult) {
                List<Statement> ifStatements = p.getIfStatements();
                for (Statement statement: ifStatements) {
                    statement.setEvaluate(true);
                    statement.accept(this);
                }
            } else {
                List<Statement> elseStatements = p.getElseStatements();
                for (Statement statement: elseStatements) {
                    statement.setEvaluate(true);
                    statement.accept(this);
                }
            }
        } else {
            p.getCondition().setFunctionName(p.getFunctionName());
            for (Statement statement: p.getStatements()) {
                statement.setFunctionName(p.getFunctionName());
                statement.accept(this);
            }
        }
        return null;
    }

    @Override
    public T visit(Variable<?> p) {
        if (p.isEvaluate()) {
            String funName = p.getFunctionName();
            Map<String, Variable<?>> variableMap = funCalls.get(funName);
            String name = p.getName();
            Variable<?> variable = null;
            if (p.getValue() instanceof Integer) {
                variable = new Variable<Integer>(name, (Integer) p.getValue());
            } else if (p.getValue() instanceof Boolean) {
                variable = new Variable<Boolean>(name, (Boolean) p.getValue());
            } else if (p.getValue() instanceof Comparison<?, ?>) {
                boolean result = handleComparison((Comparison<?, ?>) p.getValue(), funName);
                variable = new Variable<Boolean>(name, result);
            } else if (p.getValue() instanceof String) {
                variable = new Variable<String>(name, (String) p.getValue());
            } else if (p.getValue() == null) {
                String refName = p.getReferencedVariable();
                Variable<?> var = variableMap.get(refName);
                if (var.getValue() instanceof Integer) {
                    variable = new Variable<Integer>(name, (Integer) var.getValue());
                } else if (var.getValue() instanceof String) {
                    variable = new Variable<String>(name, (String) var.getValue());
                } else if (var.getValue() instanceof Boolean) {
                    variable = new Variable<Boolean>(name, (Boolean) var.getValue());
                }

            }
            variableMap.put(name, variable);
            funCalls.put(funName, variableMap);
        }
        return null;
    }


    @Override
    public T visit(PlaceAndCall p) {
        for (Statement statement : p.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public T visit(PlaceRegion p) {
        XYTuple xyCorner;
        XYTuple xyDimensions;
        if (inFunctionScope(p)) {
            if (!p.isEvaluate()) {
                return null;
            }
        }
        if (p.getFunctionName() != null) {
            xyCorner = handleXYTupleWithVariables(p.getLocation(), p.getFunctionName());
            xyDimensions = handleXYTupleWithVariables(p.getDimensions(), p.getFunctionName());
        } else {
            xyCorner = p.getLocation();
            xyDimensions = p.getDimensions();
        }
        String regionName = p.getRegionName();
        String regionType = p.getRegionType();
        RegionType type = RegionType.valueOf(regionType.toUpperCase());
        Point corner = new Point(xyCorner.getX(), xyCorner.getY());
        int width = xyDimensions.getX();
        int height = xyDimensions.getY();
        Region region = new Region(corner, height, width, type, regionName, p.isDisplayLabels());
        regions.put(regionName, region);
        placements.add(region);
        return null;
    }

    @Override
    public T visit(PlaceFeature p) {
        XYTuple xy;
        if (inFunctionScope(p)) {
            if (!p.isEvaluate()) {
                return null;
            }
        }
        if (p.getFunctionName() != null) {
            xy = handleXYTupleWithVariables(p.getLocation(), p.getFunctionName());
        } else {
            xy = p.getLocation();
        }
        String id = p.getFeatureType();
        String name = p.getFeatureName();
        Point location = new Point(xy.getX(), xy.getY());
        String regionName = p.getRegionName();
        Feature feature = features.get(id);
        if (feature == null) {
            System.out.println("Implement dynamic error 1");
        }
        assert feature != null;
        if (!Objects.equals(regionName, "map")) {
            Region region = regions.get(regionName);
            if (region == null) {
                System.out.println("Implement dynamic error 2");
            }
            assert region != null;
        }
        FeaturePlacement featurePlacement = new FeaturePlacement(feature.getId(), name, location, regionName, p.isDisplayLabels());
        placements.add(featurePlacement);
        return null;
    }

    @Override
    public T visit(FunctionCall p) {
        String functionName = p.getFunctionName();
        ArrayList<String> paramValueStrings = p.getParameterValueStrings();
        Map<String, Variable<?>> variables = new HashMap<>();
        DefineFunction function = functionDefs.get(functionName);
        ArrayList<String> paramNames = function.getParamNames();
        if (paramNames.size() != paramValueStrings.size()) {
            System.out.println("Dynamic error thrown here");
        }

        for (int i = 0; i < paramNames.size(); i++) {
            String name = paramNames.get(i);
            String value = paramValueStrings.get(i);
            if (ASTHelpers.isInteger(value)) {
                Integer paramIntValue = Integer.parseInt(value);
                Variable<Integer> param = new Variable<>(name, paramIntValue);
                variables.put(name, param);
            } else {
                Variable<String> param = new Variable<>(name, value);
                variables.put(name, param);
            }
        }
        funCalls.put(functionName, variables);
        for (Statement statement: function.getStatements()) {
            statement.setFunctionName(functionName);
            statement.setEvaluate(true);
        }
        function.accept(this);
        return null;
    }


    // HELPERS

    private XYTuple handleXYTupleWithVariables(XYTupleWithVariables xy, String funName) {
        int x;
        int y;
        String x_str = xy.getX_str();
        String y_str = xy.getY_str();
        if (ASTHelpers.isInteger(x_str)) {
            x = xy.getX();
        } else {
            x = handleVariable(x_str, funName);
        }

        if (ASTHelpers.isInteger(y_str)) {
            y = xy.getY();
        } else {
            y = handleVariable(y_str, funName);
        }
        return new XYTuple(x, y);
    }

    private void updateFunCall(String varName, Variable<?> variable, String funName) {
        Map<String, Variable<?>> variableMap = funCalls.get(funName);
        variableMap.put(varName, variable);
        funCalls.put(funName, variableMap);
    }

    private void removeVariable(String varName, String funName) {
        Map<String, Variable<?>> variableMap = funCalls.get(funName);
        variableMap.remove(varName);
        funCalls.put(funName, variableMap);
    }

    private int handleVariable(String s, String functionName) {
        Map<String, Variable<?>> variableMap = funCalls.get(functionName);
        Variable<?> variable = variableMap.get(s);
        if (variable == null) {
            System.out.println("Dynamic error thrown, referenced variable" +  s  + " not defined/doesn't exist");
        } else if (!(variable.getValue() instanceof Integer)) {
            System.out.println("Dynamic error thrown, referenced variable is not an integer");
        } else {
            return (Integer) variable.getValue();
        }
        return 0;
    }

    private boolean handleComparison(Comparison<?, ?> comparison, String funName) {
        if (comparison.getFirstVal() instanceof String && comparison.getSecondVal() instanceof String) {
            return handleStringComparison((Comparison<String, String>) comparison);
        } else {
            return handleNumComparison((Comparison<Integer, Integer>) comparison, funName);
        }
    }

    private boolean handleStringComparison(Comparison<String, String> comparison) {

        String first = comparison.getFirstVal();
        String second = comparison.getSecondVal();

        boolean result = false;
        String operator = comparison.getOperator();
        if (!validStringOp(operator)) {
            System.out.println("Dynamic exception should be thrown");
        }

        switch (operator) {
            case "==" -> result = ((String) first).equals((String) second);
            case "!=" -> result = !((String) first).equals((String) second);
            default -> System.out.println("dynamic exception should be thrown");
        }
        return result;
    }

    private boolean handleNumComparison(Comparison<Integer, Integer> comparison,
                                        String funName) {
        int first;
        int second;
        if (!comparison.isFirstReference()) {
            first = handleVariable(comparison.getFirst(), funName);
        } else {
            first = comparison.getFirstVal();
        }

        if (!comparison.isSecondReference()) {
            second = handleVariable(comparison.getSecond(), funName);
        } else {
            second = comparison.getSecondVal();
        }
        String operator = comparison.getOperator();

        if (!validIntOp(operator)) {
            System.out.println("Dynamic error should be thrown");
        }

        boolean result = false;

        switch (operator) {
            case ">" -> result = (int) first > (int) second;
            case "<" -> result = (int) first < (int) second;
            case "==" -> result = (int) first == (int) second;
            case ">=" -> result = (int) first >= (int) second;
            case "<=" -> result = (int) first <= (int) second;
            case "!=" -> result = (int) first != (int) second;
            default -> System.out.println("dynamic exception should be thrown");
        }

        return result;
    }

    private boolean validStringOp(String op) {
        return Arrays.stream(Comparison.STRING_OPERATORS).toList().contains(op);
    }

    private boolean validIntOp(String op) {
        return Arrays.stream(Comparison.NUM_OPERATORS).toList().contains(op);
    }

    private boolean inFunctionScope(Statement s) {
        return s.getFunctionName() != null;
    }
}
