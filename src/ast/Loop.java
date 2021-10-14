package ast;

import java.util.List;
import java.util.Objects;

public class Loop extends Statement {

    private final String name;
    private final String variable;
    private final String start;
    private final String stop;
    private final int counter;
    private final List<Statement> statements;

    public Loop(String name, String variable, String start, String stop, int counter, List<Statement> statements) {
        this.name = name;
        this.variable = variable;
        this.start = start;
        this.stop = stop;
        this.counter = counter;
        this.statements = statements;
    }

    public String getName() {
        return name;
    }

    public String getVariable() {
        return variable;
    }

    public String getStart() {
        return start;
    }

    public String getStop() {
        return stop;
    }

    public int getCounter() {
        return counter;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loop loop = (Loop) o;
        return name.equals(loop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
