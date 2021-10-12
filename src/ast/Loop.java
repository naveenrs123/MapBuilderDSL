package ast;

import java.util.Objects;

public class Loop extends Node {

    private final String name;
    private final String variable;
    private final String start;
    private final String stop;
    private final int counter;

    public Loop(String name, String variable, String start, String stop, int counter) {
        this.name = name;
        this.variable = variable;
        this.start = start;
        this.stop = stop;
        this.counter = counter;
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
