package ast;

import java.util.ArrayList;

public class Function extends Node {

    private final String functionName;
    private final ArrayList<String> paramNames;
    private final ArrayList<Statement> functionStatements;

    public Function(String functionName, ArrayList<String> paramNames, ArrayList<Statement> functionStatements) {
        this.functionName = functionName;
        this.paramNames = paramNames;
        this.functionStatements = functionStatements;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParamNames() {
        return paramNames;
    }

    public ArrayList<Statement> getFunctionStatements() {
        return functionStatements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
