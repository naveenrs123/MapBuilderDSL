package ast;

import java.util.List;

public class NonTerminalStatement extends Statement {

    protected List<Statement> statements;

    public NonTerminalStatement(List<Statement> statements ) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
