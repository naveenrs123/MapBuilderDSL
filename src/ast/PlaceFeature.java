package ast;

import java.util.Objects;

public class PlaceFeature extends Statement {

    private final String featureType;
    private final String featureName;
    private final XYTupleWithVariables location;
    private final boolean onMap;
    private final String regionName;

    public PlaceFeature(String featureType, String featureName,
                        XYTupleWithVariables location, boolean onMap, String regionName) {
        this.featureType = featureType;
        this.featureName = featureName;
        this.location = location;
        this.onMap = onMap;
        this.regionName = regionName;
    }

    public String getFeatureType() {
        return featureType;
    }

    public String getFeatureName() {
        return featureName;
    }

    public XYTuple getLocation() {
        return location;
    }

    public boolean isOnMap() {
        return onMap;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
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
