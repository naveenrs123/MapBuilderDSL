package model;

public enum FeatureSize {

    SMALL("small", 24),
    MEDIUM("medium", 32),
    LARGE("large", 64);

    private String size;
    private int pixels;


    FeatureSize(String size, int pixels) {
        this.size = size;
        this.pixels = pixels;
    }

    public int getPixels() {
        return this.pixels;
    }
}
