package ast;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map extends Node{

    public static final Integer PIXELS_PER_POINT = 4;
    private Integer height;
    private Integer width;
    private Color color;
    private BufferedImage image;
    private String title;

    public Map(Integer height, Integer width, Color color, String title) {
        this.height = height * PIXELS_PER_POINT;
        this.width = width * PIXELS_PER_POINT;
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
