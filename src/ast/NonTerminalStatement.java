package ast;

import java.util.List;

public class NonTerminalStatement extends Statement {

    public List<Statement> statements;

    public NonTerminalStatement(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
