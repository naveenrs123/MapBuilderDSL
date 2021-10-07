package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map {

    public static final Integer PIXELS_PER_POINT = 4;
    private Integer height;
    private Integer width;
    private Color color;
    private BufferedImage image;
    private String title;


    public Map(Integer height, Integer width, Color color, String title) {
        this.title = title;
        this.color = color;
        this.height = height * PIXELS_PER_POINT;
        this.width = width * PIXELS_PER_POINT;
        this.image = new BufferedImage(this.width, this.height, 1);
        Graphics2D graphics = image.createGraphics();
        graphics.setPaint(color);
        graphics.fillRect(0, 0, this.width, this.height);
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}
