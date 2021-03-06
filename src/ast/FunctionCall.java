package ast;

import java.util.ArrayList;

public class FunctionCall extends Statement {

    private final String functionName;
    private ArrayList<String> parameterValueStrings;

    public FunctionCall(String functionName, ArrayList<String> parameterValueStrings) {
        this.functionName = functionName;
        this.parameterValueStrings = parameterValueStrings;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParameterValueStrings() {
        return parameterValueStrings;
    }

    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return v.visit(context, this);
    }
}
