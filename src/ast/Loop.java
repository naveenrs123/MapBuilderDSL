package ast;

import helpers.ASTHelpers;
import java.util.List;
import java.util.Objects;

public class Loop extends NonTerminalStatement {

    private final String name;
    private final String variable;
    private final String start;
    private int start_int;
    private int stop_int;
    private final String stop;
    private final int counter;

    public Loop(String name, String variable, String start, String stop, int counter, List<Statement> statements) {
        super(statements);
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

    public int getStart_int() {
        return start_int;
    }

    public void setStart_int(int start_int) {
        this.start_int = start_int;
    }

    public int getStop_int() {
        return stop_int;
    }

    public void setStop_int(int stop_int) {
        this.stop_int = stop_int;
    }

    private void handleStartAndStop(String start, String stop) {
        if (ASTHelpers.isInteger(start)) {
            this.start_int = Integer.parseInt(start);
        }

        if (ASTHelpers.isInteger(stop)) {
            this.stop_int = Integer.parseInt(stop);
        }
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
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
