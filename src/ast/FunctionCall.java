package ast;

import java.util.ArrayList;

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
}
