package ast;

import java.util.List;

public class Conditional extends NonTerminalStatement {

    private Comparison<?, ?> condition;
    private int pivotIndex;

    public Conditional(Comparison<?, ?> condition,
                       List<Statement> statements,
                       int pivotIndex) {
        super(statements);
        this.condition = condition;
        this.pivotIndex = pivotIndex;
        statements.subList(0, pivotIndex);
    }

    public List<Statement> getIfStatements() {
        return statements.subList(0, pivotIndex);
    }

    public List<Statement> getElseStatements() {
        return statements.subList(pivotIndex, statements.size());
    }

    public Comparison<?, ?> getCondition() {
        return condition;
    }

    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return v.visit(context, this);
    }
}
