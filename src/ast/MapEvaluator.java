package ast;

import model.Feature;
import model.FeaturePlacement;
import model.Region;
import model.RegionType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MapEvaluator<T> implements MapVisitor<T> {

    public static java.util.Map<String, Region> regions = new HashMap<>();
    public static java.util.Map<String, Feature> features = new HashMap<>();
    // Map of RegionName (or "map") to feature placements
    public static java.util.Map<String, java.util.Map<String, ArrayList<FeaturePlacement>>> featurePlacements = new HashMap<>();
    public static java.util.Map<String, Object> variables = new HashMap<>();
    public static java.util.Map<String, Function> functionDefs = new HashMap<>();
    public static java.util.Map<String, java.util.Map<String, String>> funCalls = new HashMap<>();
    public static model.Map map;

    @Override
    public T visit(Program p) {
        p.getMap().accept(this);
        for (DefineFeature defineFeature: Program.featureDefinitions) {
            defineFeature.accept(this);
        }
        for (Function function: Program.functionDefinitions.values()) {
            function.accept(this);
        }
        p.getPlaceAndCall().accept(this);
        return null;
    }

    @Override
    public T visit(Map p) {
        String title = p.getTitle();
        Color color = p.getColor();
        int height = p.getHeight();
        int width = p.getWidth();
        map = new model.Map(height, width, color, title);
        return null;
    }

    @Override
    public T visit(DefineFeature p) {
        String name = p.getFeatureType();
        String icon = p.getIcon();
        Integer size = p.getSize();
        Feature feature = new Feature(name, icon, size);
        features.put(name, feature);
        return null;
    }

    @Override
    public T visit(Function p) {
        functionDefs.put(p.getFunctionName(), p);
        for (Statement statement: p.getStatements()) {
            statement.setParamNames(p.getParamNames());
            statement.setFunctionName(p.getFunctionName());
            statement.accept(this);
        }
        return null;
    }

    @Override
    public T visit(Statement p) {
        return null;
    }

    @Override
    public T visit(Loop p) {
        if (p.isEvaluate()) {

            String funName = p.getFunctionName();
            Function function = functionDefs.get(funName);
            String variable = p.getVariable();
            int start = Integer.parseInt(p.getStart());
            int end = Integer.parseInt(p.getStop());
            int counter = p.getCounter();

            for (int i = start; i < end; i += counter) {
                for (Statement statement: p.getStatements()) {
                    statement.addParamValue(variable, Integer.toString(i));
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public T visit(PlaceAndCall p) {
        // TODO: rework
        for (Statement statement : p.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public T visit(PlaceRegion p) {
        String regionName = p.getRegionName();
        String regionType = p.getRegionType();
        RegionType type = RegionType.valueOf(regionType.toUpperCase());
        Point corner = new Point(p.getLocation().getX(), p.getLocation().getY());
        int height = p.getDimensions().getX();
        int width = p.getDimensions().getY();
        Region region = new Region(corner, height, width, type, regionName, p.isDisplayLabels());
        regions.put(regionName, region);
        return null;
    }

    @Override
    public T visit(PlaceFeature p) {
        String id = p.getFeatureType();
        String name = p.getFeatureName();
        int ppp = model.Map.PIXELS_PER_POINT;
        Point location = new Point(p.getLocation().getX() * ppp, p.getLocation().getY() * ppp);
        String regionName = p.getRegionName();
        Feature feature = features.get(id);
        if (feature == null) {
            System.out.println("Implement dynamic error");
        }
        assert feature != null;
        if (!Objects.equals(regionName, "map")) {
            Region region = regions.get(regionName);
            if (region == null) {
                System.out.println("Implement dynamic error");
            }
            assert region != null;
        }
        java.util.Map<String, ArrayList<FeaturePlacement>> featureToPlacements = (featurePlacements.containsKey(regionName)) ? featurePlacements.get(regionName): new HashMap<>();
        ArrayList<FeaturePlacement> placements = (featureToPlacements.containsKey(id)) ? featureToPlacements.get(id): new ArrayList<>();
        FeaturePlacement featurePlacement = new FeaturePlacement(feature.getId(), name, location, p.isDisplayLabels());
        placements.add(featurePlacement);
        featureToPlacements.put(id, placements);
        featurePlacements.put(regionName, featureToPlacements);
        return null;
    }

    @Override
    public T visit(FunctionCall p) {
        String functionName = p.getFunctionName();
        ArrayList<String> paramValueStrings = p.getParameterValueStrings();
        Function function = functionDefs.get(functionName);
        ArrayList<String> paramNames = function.getParamNames();
        for (Statement statement: function.getStatements()) {
            // TODO: rework based on the param changes.
            //statement.setParamsToValues(paramNames, values);
            //statement.setEvaluate(true);
        }
        function.accept(this);
        return null;

        /* // REFERENCE FOR EVALUATING PARAMS, NEEDS REWORKING.

        if (paramNames != null) {
            parameters = new ArrayList<>();
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

        * */
    }
}
