package ast;

import java.util.Objects;

public class PlaceRegion extends Statement {

    private final String regionType;
    private final String regionName;
    private final XYTupleWithVariables location;
    private final XYTupleWithVariables dimensions;
    private final boolean displayLabels;

    public PlaceRegion(String regionType, String regionName, XYTupleWithVariables location,
                       XYTupleWithVariables dimensions, boolean displayLabels) {
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

    public XYTupleWithVariables getLocation() {
        return location;
    }

    public XYTupleWithVariables getDimensions() {
        return dimensions;
    }

    public boolean isDisplayLabels() {
        return displayLabels;
    }

    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return v.visit(context, this);
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
