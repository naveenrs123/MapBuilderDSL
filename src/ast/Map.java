package ast;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map extends Node{

    public static final Integer PIXELS_PER_POINT = 4;
    private final Color color;
    private BufferedImage image;
    private String title;
    private final int width;
    private final int height;

    public Map(XYTuple dimensions, Color color, String title) {
        this.width = dimensions.getX() * PIXELS_PER_POINT;
        this.height = dimensions.getY() * PIXELS_PER_POINT;
        this.color = color;
        this.image = new BufferedImage(this.width, this.height, 1);
        this.title = title;
    }

    //region Getters
    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
    //endregion

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
