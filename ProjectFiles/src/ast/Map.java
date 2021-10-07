package ast;

public class Map extends Node{
    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
