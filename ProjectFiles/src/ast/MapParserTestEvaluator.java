package ast;

public class MapParserTestEvaluator implements MapVisitor{
    @Override
    public Object visit(Program p) {
        System.out.println("Program \n");
        return null;
    }

    @Override
    public Object visit(Map p) {
        System.out.println("Map \n");
        return null;
    }

    @Override
    public Object visit(Def p) {
        System.out.println("Def \n");
        return null;
    }

    @Override
    public Object visit(PlaceAndCall p) {
        System.out.println("PlaceAndCall \n");
        return null;
    }
}
