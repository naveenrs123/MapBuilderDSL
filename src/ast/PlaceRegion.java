package ast;

public class PlaceRegion extends Statement {

    private final String regionType;
    private final String regionName;
    private final XYTuple location;
    private final XYTuple dimensions;
    private final boolean displayLabels;

    public PlaceRegion(String regionType, String regionName, XYTuple location,
                        XYTuple dimensions, boolean displayLabels) {
        this.regionType = regionType;
        this.regionName = regionName;
        this.location = location;
        this.dimensions = dimensions;
        this.displayLabels = displayLabels;
    }

    public String getRegionType() {
        return regionType;
    }

    public String getRegionName() {
        return regionName;
    }

    public XYTuple getLocation() {
        return location;
    }

    public XYTuple getDimensions() {
        return dimensions;
    }

    public boolean isDisplayLabels() {
        return displayLabels;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
