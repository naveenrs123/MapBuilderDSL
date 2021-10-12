package ast;

public class PlaceAndCall extends Node{
    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
