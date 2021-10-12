package ast;

public class DefineFeature extends Statement {

    private final String featureType;
    private final String icon;
    private final int size;

    public DefineFeature(String featureType, String icon, int size) {
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

    public int getSize() {
        return size;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
