package ast;

import java.util.ArrayList;

public class PlaceAndCall extends Node {

    private final ArrayList<Statement> placeStatements;

    public PlaceAndCall(ArrayList<Statement> placeStatements) {
        this.placeStatements = placeStatements;
    }

    public ArrayList<Statement> getPlaceStatements() {
        return placeStatements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
