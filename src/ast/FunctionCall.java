package ast;

import java.util.ArrayList;
import java.util.Objects;

public class FunctionCall extends Statement {

    private final String functionName;
    private final ArrayList<String> paramValues;

    public FunctionCall(String functionName, ArrayList<String> paramValues) {
        this.functionName = functionName;
        this.paramValues = paramValues;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParamValues() {
        return paramValues;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionCall that = (FunctionCall) o;
        return functionName.equals(that.functionName) && paramValues.equals(that.paramValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionName, paramValues);
    }
}
