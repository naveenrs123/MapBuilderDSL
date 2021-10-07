package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Feature implements Cloneable {

    private BufferedImage icon;
    private Point location;
    private String label;
    private Integer size = 24;

    public Feature(String iconName, Point location, String label, Integer size) {
        int ppp = Map.PIXELS_PER_POINT;
        this.location = new Point(location.x * ppp, location.y * ppp);
        this.size = size;
        this.icon = fetchIcon(iconName);
        this.label = label;

    }

    public Feature(String iconName, Point location, String label) {
        int ppp = Map.PIXELS_PER_POINT;
        this.location = new Point(location.x * ppp, location.y * ppp);
        this.icon = fetchIcon(iconName);
        this.label = label;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public Point getLocation() {
        return location;
    }

    public String getLabel() {
        return label;
    }

    public Integer getSize() {
        return size;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private BufferedImage fetchIcon(String iconName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(String.format( "%s_%dpx.png", iconName, size));
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            return null;
        }
    }
}
