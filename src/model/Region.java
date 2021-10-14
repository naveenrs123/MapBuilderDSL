package model;

import java.awt.*;
import java.util.ArrayList;

public class Region {

    private Point corner;
    private Integer height;
    private Integer width;
    private RegionType regionType;
    private String label;
    private boolean showLabel;

    public Region(Point corner,
                  Integer height,
                  Integer width,
                  RegionType regionType,
                  String label,
                  boolean showLabel) {
        int ppp = Map.PIXELS_PER_POINT;
        this.corner = new Point(corner.x * ppp, corner.y * ppp);
        this.height = height * ppp;
        this.width = width * ppp;
        this.regionType = regionType;
        this.label = label;
        this.showLabel = showLabel;
    }


    public Point getCorner() {
        return corner;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public String getLabel() {
        return label;
    }

    public boolean isShowLabel() {
        return showLabel;
    }
}
