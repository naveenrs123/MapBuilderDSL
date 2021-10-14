package model;

import java.awt.*;

public class FeaturePlacement {

    private String id;
    private String label;
    private Point location;
    private boolean showLabel;

    public FeaturePlacement(String id, String label, Point location, boolean showLabel) {
        this.id = id;
        this.label = label;
        this.location = location;
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

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isShowLabel() {
        return showLabel;
    }

    public void setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
    }
}
