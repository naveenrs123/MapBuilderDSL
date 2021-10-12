package ast;

public class Program extends Node{

    /**
     * Different sections of a program. The def section is optional.
     */
    private final Map map;
    private Def def;
    private final PlaceAndCall placeAndCall;

    public Program(Map map, Def def, PlaceAndCall placeAndCall) {
        this(map, placeAndCall);
        this.def = def;
    }

    public Program(Map map, PlaceAndCall placeAndCall) {
        this.map = map;
        this.placeAndCall = placeAndCall;
    }

    public Map getMap() {
        return map;
    }

    public Def getDef() {
        return def;
    }

    public PlaceAndCall getPlaceAndCall() {
        return placeAndCall;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
