package ast;

public class XYTuple extends Node {

    /**
     * Represents the first value in an x-y pair. Typically, width.
     */
    private final int x;

    /**
     * Represents the second value in an x-y pair. Typically, height.
     */
    private final int y;

    public XYTuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return null;
    }
}
