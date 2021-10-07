package ast;

public interface MapVisitor<T> {
    T visit(Program p);
    T visit(Map p);
    T visit(Def p);
    T visit(PlaceAndCall p);
}
