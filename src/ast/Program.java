package ast;

public class Program extends Node{
    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
