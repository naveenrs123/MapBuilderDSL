package ast;

public class Primitive extends Node {

    public String text;

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
