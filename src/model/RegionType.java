package model;

import java.awt.*;

public enum RegionType {

    WATER("ocean", new Color(134, 197, 218), new Color(106, 176, 232), 4),
    OCEAN("water", new Color(3, 148, 194), new Color(6, 176, 132), 4),
    FOREST("forest", new Color(21, 154, 88), new Color(18, 128, 86), 2),
    GRASS("grass", new Color(135, 211, 123, 228), new Color(116, 159, 79), 12),
    DESERT("desert", new Color(244, 215, 180), new Color(208, 150, 80), 8),
    SNOW("snow", new Color(218, 253, 253), new Color(229, 232, 232), 16);

    private final String type;
    private final Color color;
    private final Color secondaryColor;
    private final int randFactor;

    RegionType(String type, Color color, Color secondaryColor, int randFactor) {
        this.type = type;
        this.color = color;
        this.secondaryColor = secondaryColor;
        this.randFactor = randFactor;
    }

    public String getType() {
        return type;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public int getRandFactor() {
        return randFactor;
    }

    public Color getColor() {
        return color;
    }
}
