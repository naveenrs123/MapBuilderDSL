package ast;

import java.awt.*;

public class Map extends Node{

    private final Color color;
    private String title;
    private final int width;
    private final int height;

    public Map(XYTuple dimensions, Color color, String title) {
        this.width = dimensions.getX();
        this.height = dimensions.getY();
        this.color = color;
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

    public String getTitle() {
        return title;
    }
    //endregion

    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return v.visit(context, this);
    }
}
