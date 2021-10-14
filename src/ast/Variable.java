package ast;

public class Variable<Y> extends Node {

    private String name;
    private Y value;

    public Variable(String name, Y value) {
        this.name = name;
        this.value = value;

    }

    public String getName() {
        return name;
    }

    public Y getValue() {
        return value;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
