package model;

import java.awt.*;

public enum RegionType {

    OCEAN("Ocean", new Color(134, 197, 218)),
    FOREST("Forest", new Color(0, 153, 77)),
    DESSERT("Dessert", new Color(244, 215, 180));

    private final String type;
    private final Color color;

    RegionType(String type, Color color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
