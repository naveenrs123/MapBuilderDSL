package ast;

import java.util.HashMap;
import java.util.HashSet;

public class Program extends Node{

    /**
     * Different sections of a program. The def section is optional.
     */
    private final Map map;
    private final PlaceAndCall placeAndCall;

    public Program(Map map, PlaceAndCall placeAndCall) {
        this.map = map;
        this.placeAndCall = placeAndCall;
    }

    public Map getMap() {
        return map;
    }

    public PlaceAndCall getPlaceAndCall() {
        return placeAndCall;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    public static HashMap<String, Function> functionDefinitions = null;
    public static HashSet<DefineFeature> featureDefinitions = null;

    public static String[] retrieveParameterListForFunction(String functionName) {
        Function func = functionDefinitions.get(functionName);
        if (func != null) {
            String[] params = new String[func.getParamNames().size()];
            params = func.getParamNames().toArray(params);
            return params;
        } else {
            return null;
        }
    }
}
