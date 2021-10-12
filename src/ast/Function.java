package ast;

import Helpers.ExecutionOrderContext;

import java.util.ArrayList;
import java.util.Objects;

public class Function extends Node {

    private final String functionName;
    private final ArrayList<String> paramNames;
    private final ArrayList<ExecutionOrderContext> executionOrder;

    public Function(String functionName, ArrayList<String> paramNames, ArrayList<ExecutionOrderContext> executionOrder) {
        this.functionName = functionName;
        this.paramNames = paramNames;
        this.executionOrder = executionOrder;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParamNames() {
        return paramNames;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function function = (Function) o;
        return functionName.equals(function.functionName) && Objects.equals(paramNames, function.paramNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionName, paramNames);
    }
}
