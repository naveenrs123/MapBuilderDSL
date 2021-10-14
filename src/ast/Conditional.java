package ast;

import java.util.List;

public class Conditional extends Statement {

    private List<Statement> ifStatements;
    private List<Statement> elseStatements;
    private Comparison<?, ?> condition;

    public Conditional(List<Statement> ifStatements,
                       List<Statement> elseStatements,
                       Comparison<?, ?> condition) {
        this.ifStatements = ifStatements;
        this.elseStatements = elseStatements;
        this.condition = condition;
    }

    public List<Statement> getIfStatements() {
        return ifStatements;
    }

    public List<Statement> getElseStatements() {
        return elseStatements;
    }

    public Comparison<?, ?> getCondition() {
        return condition;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
