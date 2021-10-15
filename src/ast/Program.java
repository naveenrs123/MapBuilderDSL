package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Program extends Node{

    /**
     * Different sections of a program. The def section is optional.
     */
    private final Map map;
    private final PlaceAndCall placeAndCall;
    private final ArrayList<Def> defs;

    public Program(Map map, PlaceAndCall placeAndCall, ArrayList<Def> defs) {
        this.map = map;
        this.placeAndCall = placeAndCall;
        this.defs = defs;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Def> getDefs() {
        return defs;
    }

    public PlaceAndCall getPlaceAndCall() {
        return placeAndCall;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
