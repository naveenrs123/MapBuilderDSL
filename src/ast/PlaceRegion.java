package ast;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceRegion that = (PlaceRegion) o;
        return regionType.equals(that.regionType) && regionName.equals(that.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionType, regionName);
    }
}
