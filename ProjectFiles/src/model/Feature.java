package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Feature {

    private BufferedImage icon;
    private Point location;
    private String label;
    private Integer size = 1;

    public Feature(String iconName, Point location, Integer size) {
        int ppp = Map.PIXELS_PER_POINT;
        this.location = new Point(location.x * ppp, location.y * ppp);
        this.icon = fetchIcon(iconName, size);
        this.size = size;

    }

    public Feature(String iconName, Point location, String label) {
        int ppp = Map.PIXELS_PER_POINT;
        this.location = new Point(location.x * ppp, location.y * ppp);
        this.icon = fetchIcon(iconName, size);
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

    private BufferedImage fetchIcon(String iconName, Integer size) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(iconName + "_24px.png");
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            return null;
        }
    }
}
