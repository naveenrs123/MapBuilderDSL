package ast;

import java.util.ArrayList;
import java.util.Objects;

public class DefineFunction extends Def {

    private final String functionName;
    private final ArrayList<String> paramNames;
    private ArrayList<Statement> statements;

    public DefineFunction(String functionName,
                          ArrayList<String> paramNames,
                          ArrayList<Statement> statements) {
        this.functionName = functionName;
        this.paramNames = paramNames;
        this.statements = statements;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParamNames() {
        return paramNames;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefineFunction function = (DefineFunction) o;
        return functionName.equals(function.functionName) && Objects.equals(paramNames, function.paramNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionName, paramNames);
    }
}
