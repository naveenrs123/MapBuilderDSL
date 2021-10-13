package ast;

import java.util.List;

public class Conditional extends Statement {

    private List<Statement> ifStatements;
    private List<Statement> elseStatements;

    public Conditional(List<Statement> ifStatements,
                       List<Statement> elseStatements) {
        this.ifStatements = ifStatements;
        this.elseStatements = elseStatements;
    }

    public List<Statement> getIfStatements() {
        return ifStatements;
    }

    public List<Statement> getElseStatements() {
        return elseStatements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
