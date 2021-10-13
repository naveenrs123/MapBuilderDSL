package ast;

import Helpers.ExecutionOrderContext;

import java.util.ArrayList;
import java.util.ArrayList;

public class PlaceAndCall extends Node {

    private ArrayList<PlaceRegion> placeRegionList;
    private ArrayList<PlaceFeature> placeFeatureList;
    private ArrayList<FunctionCall> functionCallList;
    private ArrayList<ExecutionOrderContext> executionOrderList;

    public PlaceAndCall(ArrayList<PlaceRegion> placeRegionList,
                        ArrayList<PlaceFeature> placeFeatureList,
                        ArrayList<FunctionCall> functionCallList,
                        ArrayList<ExecutionOrderContext> executionOrderList) {
        this.placeRegionList = placeRegionList;
        this.placeFeatureList = placeFeatureList;
        this.functionCallList = functionCallList;
        this.executionOrderList = executionOrderList;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    public ArrayList<PlaceRegion> getPlaceRegionList() {
        return placeRegionList;
    }

    public ArrayList<PlaceFeature> getPlaceFeatureList() {
        return placeFeatureList;
    }

    public ArrayList<FunctionCall> getFunctionCallList() {
        return functionCallList;
    }

    public ArrayList<ExecutionOrderContext> getExecutionOrderList() {
        return executionOrderList;
    }
}
