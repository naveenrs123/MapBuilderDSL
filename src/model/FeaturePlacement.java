package model;

import java.awt.*;

public class FeaturePlacement extends Placement {

    private String id;
    private String label;
    private Point location;
    private String region;
    private boolean showLabel;

    public FeaturePlacement(String id, String label, Point location, String region, boolean showLabel) {
        int ppp = WorldMap.PIXELS_PER_POINT;
        this.id = id;
        this.label = label;
        this.location = new Point(location.x * ppp, location.y * ppp);
        this.region = region;
        this.showLabel = showLabel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Point getLocation() {
        return location;
    }

    public Integer getHeight() {
        return (int) location.getY();
    }

    public Integer getWidth() {
        return (int) location.getX();
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isShowLabel() {
        return showLabel;
    }

    public void setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
    }

    public String getRegion() {
        return region;
    }
}
