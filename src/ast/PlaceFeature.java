package ast;

public class PlaceFeature extends Statement {

    private final String featureType;
    private final String featureName;
    private final XYTuple location;
    private final boolean onMap;
    private final String regionName;

    public PlaceFeature(String featureType, String featureName,
                            XYTuple location, boolean onMap, String regionName) {
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
}
