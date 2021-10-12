package ast;

import Helpers.ExecutionOrderContext;

import java.util.ArrayList;
import java.util.ArrayList;

public class PlaceAndCall extends Node {

    public static ArrayList<PlaceRegion> placeRegionList;
    public static ArrayList<PlaceFeature> placeFeatureList;
    public static ArrayList<FunctionCall> functionCallList;
    public static ArrayList<ExecutionOrderContext> executionOrderList;

    public PlaceAndCall(ArrayList<PlaceRegion> placeRegionList,
                        ArrayList<PlaceFeature> placeFeatureList,
                        ArrayList<FunctionCall> functionCallList,
                        ArrayList<ExecutionOrderContext> executionOrderList) {
        PlaceAndCall.placeRegionList = placeRegionList;
        PlaceAndCall.placeFeatureList = placeFeatureList;
        PlaceAndCall.functionCallList = functionCallList;
        PlaceAndCall.executionOrderList = executionOrderList;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
