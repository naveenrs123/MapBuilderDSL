package ast;

public class Comparison<X, Y> extends Node {

    private String first;
    private String second;
    private X firstVal;
    private Y secondVal;
    private String operator;
    private boolean hasMissingValues = true;

    public Comparison(String first, String second, X firstVal, Y secondVal, String operator) {
        this(first, second, operator);
        this.firstVal = firstVal;
        this.secondVal = secondVal;
        if (this.firstVal != null && this.secondVal != null) {
            this.hasMissingValues = false;
        }
    }

    public Comparison(String first, String second, String operator) {
        this.first = first;
        this.second = second;
        this.operator = operator;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public X getFirstVal() {
        return firstVal;
    }

    public Y getSecondVal() {
        return secondVal;
    }

    public String getOperator() {
        return operator;
    }

    public boolean hasMissingValues() {
        return hasMissingValues;
    }

    public void setFirstVal(X firstVal) {
        this.firstVal = firstVal;
    }

    public void setSecondVal(Y secondVal) {
        this.secondVal = secondVal;
    }

    public String getFirstValType() {
        return this.firstVal.getClass().getSimpleName();
    }

    public String getSecondValType() {
        return this.secondVal.getClass().getSimpleName();
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
