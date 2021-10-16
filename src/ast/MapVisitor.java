package ast;

public interface MapVisitor<T> {
    T visit(Program p);
    T visit(Map p);
    T visit(Def p);
    T visit(DefineFeature p);
    T visit(DefineFunction p);
    T visit(Loop p);
    T visit(Conditional p);
    T visit(Variable<?> p);
    T visit(PlaceAndCall p);
    T visit(PlaceRegion p);
    T visit(PlaceFeature p);
    T visit(FunctionCall p);
}
