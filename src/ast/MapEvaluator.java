package ast;

import helpers.ASTHelpers;
import model.*;
import org.stringtemplate.v4.ST;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map;

public class MapEvaluator implements MapVisitor<StringBuilder, Integer> {

    public static Map<String, Region> regions = new HashMap<>();
    public static Map<String, Feature> features = new HashMap<>();
    public static ArrayList<Placement> placements = new ArrayList<>();
    public static Map<String, Object> variables = new HashMap<>();
    public static Map<String, DefineFunction> functionDefs = new HashMap<>();
    public static Map<String, Map<String, Variable<?>>> funCalls = new HashMap<>();
    public static WorldMap map;
    private static StringBuilder c = new StringBuilder();

    @Override
    public Integer visit(StringBuilder context, Program p) {
        p.getMap().accept(context, this);
        for (Def def: p.getDefs()) {
            def.accept(context, this);
            if (!context.isEmpty()) {
                break; // error in creating program
            }
        }
        p.getPlaceAndCall().accept(context, this);
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, ast.Map p) {
        String title = p.getTitle();
        Color color = p.getColor();
        int height = p.getHeight();
        int width = p.getWidth();
        map = new WorldMap(height, width, color, title);
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, Def p) {
        if (p instanceof DefineFeature) {
            p.accept(context, this);
        } else if (p instanceof DefineFunction) {
            p.accept(context, this);
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, DefineFeature p) {
        String name = p.getFeatureType();
        String icon = p.getIcon();
        String size = p.getSize();
        FeatureSize featureSize = FeatureSize.valueOf(size.toUpperCase());
        Feature feature = new Feature(name, icon, featureSize);
        features.put(name, feature);
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, DefineFunction p) {
        functionDefs.put(p.getFunctionName(), p);
        for (Statement statement: p.getStatements()) {
            statement.setParamNames(p.getParamNames());
            statement.setFunctionName(p.getFunctionName());
            statement.accept(context, this);
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, Loop p) {
        if (p.isEvaluate()) {
            String funName = p.getFunctionName();
            String variable = p.getVariable();
            int start = (ASTHelpers.isInteger(p.getStart())) ? Integer.parseInt(p.getStart()): handleVariable(p.getStart(), funName);
            int end = (ASTHelpers.isInteger(p.getStop())) ? Integer.parseInt(p.getStop()): handleVariable(p.getStop(), funName);
            if (!c.isEmpty()) { // copy dynamic error if start or end values are invalid
                context.append(c);
                c.setLength(0); // reset global dynamic error check
            }
            if (context.isEmpty()) {
                if (!validBounds(start, end)) {
                    // dynamic check when loop goes out of bounds of the map dimension
                    context.append("Loop start parameter ").append(start).append(" and/or end parameter ").append(end)
                            .append(" are out of bounds of the map dimension.\n");
                }
                int counter = p.getCounter();

                for (int i = start; i < end; i += counter) {
                    for (Statement statement: p.getStatements()) {
                        updateFunCall(variable, new Variable<Integer>(variable, i), funName);
                        statement.addParamValue(variable, Integer.toString(i));
                        statement.setEvaluate(true);
                        statement.accept(context, this);
                        if (!context.isEmpty()) {
                            break;
                        }
                    }
                }
            }
            removeVariable(variable, funName);
        } else {
            for (Statement statement: p.getStatements()) {
                statement.setFunctionName(p.getFunctionName());
                statement.accept(context,this);
                if (!context.isEmpty()) {
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, Conditional p) {
        if (p.isEvaluate()) {
            boolean comparisonResult = handleComparison(p.getCondition(), p.getFunctionName());
            if (!c.isEmpty()) { // copy dynamic error if one occurred
                context.append(c);
                c.setLength(0); // reset global dynamic error check
            }
            if (comparisonResult) {
                List<Statement> ifStatements = p.getIfStatements();
                for (Statement statement: ifStatements) {
                    statement.setEvaluate(true);
                    statement.accept(context,this);
                    if (!context.isEmpty()) {
                        break;
                    }
                }
            } else {
                List<Statement> elseStatements = p.getElseStatements();
                for (Statement statement: elseStatements) {
                    statement.setEvaluate(true);
                    statement.accept(context, this);
                    if (!context.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            p.getCondition().setFunctionName(p.getFunctionName());
            for (Statement statement: p.getStatements()) {
                statement.setFunctionName(p.getFunctionName());
                statement.accept(context, this);
                if (!context.isEmpty()) {
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, Variable<?> p) {
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
                if (!c.isEmpty()) { // copy dynamic error if one occurred
                    context.append(c);
                    c.setLength(0); // reset global dynamic error check
                }
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
                } else {
                    context.append("Referenced variable ").append(refName).append(" is undefined\n");
                }
            } else {
                context.append("Variable ").append(name).append(" is undefined\n");
            }
            if (context.isEmpty()) {
                variableMap.put(name, variable);
                funCalls.put(funName, variableMap);
            }
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, PlaceAndCall p) {
        for (Statement statement : p.getStatements()) {
            statement.accept(context, this);
            if (!context.isEmpty()) {
                break;
            }
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, PlaceRegion p) {
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
            if (!c.isEmpty()) { // copy dynamic error if one occurred
                context.append(c);
                c.setLength(0); // reset global dynamic error check
            }
        } else {
            xyCorner = p.getLocation();
            xyDimensions = p.getDimensions();
        }
        if (context.isEmpty()) {
            String regionName = p.getRegionName();
            String regionType = p.getRegionType();
            RegionType type = RegionType.valueOf(regionType.toUpperCase());
            Point corner = new Point(xyCorner.getX(), xyCorner.getY());
            int width = xyDimensions.getX();
            int height = xyDimensions.getY();

            int xCoordinate = (int) corner.getX() + width;
            int yCoordinate = (int) corner.getY() + height;

            if (!validBounds(xCoordinate, yCoordinate)) {
                // dynamic check when region is out of bounds of the map dimension
                context.append("Region ").append(regionName).append(" is out of bounds of the map dimension\n");
            } else if (invalidRegionOverlap(corner, width, height)) {
                // dynamic check when the region completely overlaps an existing region
                context.append("Region ").append(regionName).append(" completely covers a pre-existing region\n");
            } else {
                Region region = new Region(corner, height, width, type, regionName, p.isDisplayLabels());
                regions.put(regionName, region);
                placements.add(region);
            }
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, PlaceFeature p) {
        XYTuple xy;
        if (inFunctionScope(p)) {
            if (!p.isEvaluate()) {
                return null;
            }
        }
        if (p.getFunctionName() != null) {
            xy = handleXYTupleWithVariables(p.getLocation(), p.getFunctionName());
            if (!c.isEmpty()) { // copy dynamic error if one occurred
                context.append(c);
                c.setLength(0); // reset global dynamic error check
            }
        } else {
            xy = p.getLocation();
        }
        if (context.isEmpty()) {
            String id = p.getFeatureType();
            String name = p.getFeatureName();
            Point location = new Point(xy.getX(), xy.getY());
            String regionName = p.getRegionName();
            Feature feature = features.get(id);
            if (feature == null) {
                context.append("PlaceFeature call made on an undefined feature ").append(name).append("\n");
            }
            if (context.isEmpty()) {
//            assert feature != null;
                int xCoordinate = 0;
                int yCoordinate = 0;
                if (!Objects.equals(regionName, "map")) {
                    Region region = regions.get(regionName);
                    if (region == null) {
                        context.append("Feature is placed to an undeclared region ").append(regionName).append("\n");
                        return null;
                    }
                    xCoordinate = xy.getX() + (region.getLocation().x / WorldMap.PIXELS_PER_POINT);
                    yCoordinate = xy.getY() + (region.getLocation().y / WorldMap.PIXELS_PER_POINT);
//                assert region != null;
                } else {
                    xCoordinate = xy.getX();
                    yCoordinate = xy.getY();
                }
                if (!validBounds(xCoordinate, yCoordinate)) {
                    // dynamic check when feature is out of bounds of the map dimension
                    context.append("Feature ").append(name).append(" is out of bounds of the map dimension.\n");
                }
                if (context.isEmpty()) {
                    FeaturePlacement featurePlacement = new FeaturePlacement(feature.getId(), name, location, regionName, p.isDisplayLabels());
                    placements.add(featurePlacement);
                }
            }
        }
        return null;
    }

    @Override
    public Integer visit(StringBuilder context, FunctionCall p) {
        String functionName = p.getFunctionName();
        ArrayList<String> paramValueStrings = p.getParameterValueStrings();
        Map<String, Variable<?>> variables = new HashMap<>();
        DefineFunction function = functionDefs.get(functionName);
        if (function == null) {
            context.append("Function call made on an undefined function ").append(functionName).append("\n");
        }
        if (context.isEmpty()) {
            ArrayList<String> paramNames = function.getParamNames();
            if (paramNames.size() != paramValueStrings.size()) {
                context.append("The number of parameters declared, ").append(paramValueStrings.size())
                        .append(" is different to the number of parameters needed for function ").append(functionName)
                        .append(", which is ").append(paramNames.size());
            }
            if (context.isEmpty()) {
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
                function.accept(context, this);
            }
        }
        return null;
    }

    // HELPERS

    // dynamic error handler for helper functions
    private void handleDynamicError(String msg) {
        c.append(msg).append("\n");
    }

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
            handleDynamicError("Variable " + s + " is undefined");
        } else if (!(variable.getValue() instanceof Integer)) {
            handleDynamicError("Variable " + s + " is not an integer");
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
            handleDynamicError("Invalid String operator declared");
        } else {
            switch (operator) {
                case "==" -> result = ((String) first).equals((String) second);
                case "!=" -> result = !((String) first).equals((String) second);
                default -> handleDynamicError("Invalid String operator declared");
            }
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
        if (!c.isEmpty()) { // dynamic error found
            return false;
        }
        String operator = comparison.getOperator();

        boolean result = false;
        if (!validIntOp(operator)) {
            handleDynamicError("Invalid Integer operator declared");
        } else {
            switch (operator) {
                case ">" -> result = (int) first > (int) second;
                case "<" -> result = (int) first < (int) second;
                case "==" -> result = (int) first == (int) second;
                case ">=" -> result = (int) first >= (int) second;
                case "<=" -> result = (int) first <= (int) second;
                case "!=" -> result = (int) first != (int) second;
                default -> handleDynamicError("Invalid Integer operator declared");
            }
        }
        return result;
    }

    private boolean validStringOp(String op) {
        return Arrays.stream(Comparison.STRING_OPERATORS).toList().contains(op);
    }

    private boolean validIntOp(String op) {
        return Arrays.stream(Comparison.NUM_OPERATORS).toList().contains(op);
    }

    private boolean validBounds(int x, int y) {
        int ppp = map.PIXELS_PER_POINT;

        return (x*ppp <= map.getWidth() && y*ppp <= map.getHeight());
    }

    private boolean invalidRegionOverlap(Point p, int w, int h) {
        int ppp = WorldMap.PIXELS_PER_POINT;
        Point val = new Point(p.x * ppp, p.y * ppp);
        for (int i = 0; i < placements.size(); i++) {
            if (placements.get(i) instanceof Region) {
                if (val.equals(placements.get(i).getLocation())
                        && placements.get(i).getWidth() == (w*ppp) && placements.get(i).getHeight() == (h*ppp)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean inFunctionScope(Statement s) {
        return s.getFunctionName() != null;
    }
}
