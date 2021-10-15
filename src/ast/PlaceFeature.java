package ast;

import java.util.Objects;

public class PlaceFeature extends TerminalStatement {

    private final String featureType;
    private final String featureName;
    private final XYTupleWithVariables location;
    private final boolean onMap;
    private final String regionName;
    private final boolean displayLabel;

    public PlaceFeature(String featureType, String featureName,
                        XYTupleWithVariables location, boolean onMap, String regionName, boolean displayLabel) {
        this.featureType = featureType;
        this.featureName = featureName;
        this.location = location;
        this.onMap = onMap;
        this.regionName = regionName;
        this.displayLabel = displayLabel;
    }

    public String getFeatureType() {
        return featureType;
    }

    public String getFeatureName() {
        return featureName;
    }

    public XYTupleWithVariables getLocation() { return location; }

    public boolean isOnMap() {
        return onMap;
    }

    public String getRegionName() {
        return regionName;
    }

    public boolean isDisplayLabels() { return displayLabel; }


    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceFeature that = (PlaceFeature) o;
        return onMap == that.onMap && featureType.equals(that.featureType) && featureName.equals(that.featureName)
                && location.equals(that.location) && Objects.equals(regionName, that.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureType, featureName, location, onMap, regionName);
    }
}
