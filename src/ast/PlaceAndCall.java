package ast;

import java.util.ArrayList;

public class PlaceAndCall extends Node {

    private ArrayList<Statement> statements;

    public PlaceAndCall(ArrayList<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }
}
