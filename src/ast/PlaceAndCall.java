package ast;

import java.util.ArrayList;

public class PlaceAndCall extends Node {

    public static ArrayList<PlaceRegion> placeRegionList;
    public static ArrayList<PlaceFeature> placeFeatureList;
    public static ArrayList<FunctionCall> functionCallList;

    public PlaceAndCall(ArrayList<PlaceRegion> placeRegionList,
                        ArrayList<PlaceFeature> placeFeatureList,
                        ArrayList<FunctionCall> functionCallList) {
        PlaceAndCall.placeRegionList = placeRegionList;
        PlaceAndCall.placeFeatureList = placeFeatureList;
        PlaceAndCall.functionCallList = functionCallList;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
