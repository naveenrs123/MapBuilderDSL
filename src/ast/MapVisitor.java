package ast;

public interface MapVisitor<T> {
    T visit(Program p);
    T visit(Map p);
    T visit(DefineFeature p);
    T visit(Function p);
    T visit(Statement p);
    T visit(Loop p);
    T visit(PlaceAndCall p);
    T visit(PlaceRegion p);
    T visit(PlaceFeature p);
    T visit(FunctionCall p);
}
