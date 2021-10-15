package ast;

public class Comparison<X, Y> extends Statement {

    public static String[] STRING_OPERATORS = new String[] {"==", "!="};
    public static String[] NUM_OPERATORS = new String[] {"==", "!=", "<", ">", ">=", "<="};
    private String first;
    private String second;
    private X firstVal = null;
    private Y secondVal = null;
    private String operator;

    public Comparison(String first, String second, X firstVal, Y secondVal, String operator) {
        this(first, second, operator);
        this.firstVal = firstVal;
        this.secondVal = secondVal;
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

    public void setFirstVal(X firstVal) {
        this.firstVal = firstVal;
    }

    public void setSecondVal(Y secondVal) {
        this.secondVal = secondVal;
    }

    public boolean isFirstReference() {
        return this.firstVal != null;
    }

    public boolean isSecondReference() {
        return this.secondVal != null;
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
