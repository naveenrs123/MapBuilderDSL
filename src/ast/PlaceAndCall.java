package ast;

import java.util.ArrayList;

public class PlaceAndCall extends Node {

    private ArrayList<Statement> statements;

    public PlaceAndCall(ArrayList<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return v.visit(context, this);
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }
}
