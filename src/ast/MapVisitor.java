package ast;

public interface MapVisitor<C,T> {
    T visit(C context, Program p);
    T visit(C context, Map p);
    T visit(C context, Def p);
    T visit(C context, DefineFeature p);
    T visit(C context, DefineFunction p);
    T visit(C context, Loop p);
    T visit(C context, Conditional p);
    T visit(C context, Variable<?> p);
    T visit(C context, PlaceAndCall p);
    T visit(C context, PlaceRegion p);
    T visit(C context, PlaceFeature p);
    T visit(C context, FunctionCall p);
}
