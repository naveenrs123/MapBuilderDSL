package ast;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Objects;

public class FunctionCall extends Statement {

    private final String functionName;
    private final ArrayList<Variable<?>> parameters;

    public FunctionCall(String functionName, ArrayList<Variable<?>> parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<Variable<?>> getParameters() {
        return parameters;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
