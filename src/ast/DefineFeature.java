package ast;

import java.util.Objects;

public class DefineFeature extends Def {

    private final String featureType;
    private final String icon;
    private String size;

    public DefineFeature(String featureType, String icon, String size) {
        this.featureType = featureType;
        this.icon = icon;
        this.size = size;
    }

    public String getFeatureType() {
        return featureType;
    }

    public String getIcon() {
        return icon;
    }

    public String getSize() {
        return size;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefineFeature that = (DefineFeature) o;
        return featureType.equals(that.featureType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureType);
    }
}
