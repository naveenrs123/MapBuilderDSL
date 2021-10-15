package ast;

public class TerminalStatement extends Statement {

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
