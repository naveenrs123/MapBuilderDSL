package ast;

public class XYTupleWithVariables extends XYTuple {

    private String x_str;
    private String y_str;

    public XYTupleWithVariables(int x, int y) {
        super(x, y);
        this.x_str = Integer.toString(x);
        this.y_str = Integer.toString(y);
    }

    public XYTupleWithVariables(int x, int y, String x_str, String y_str) {
        super(x, y);
        this.x_str = x_str;
        this.y_str = y_str;
    }

    public String getX_str() {
        return x_str;
    }

    public String getY_str() {
        return y_str;
    }
}
