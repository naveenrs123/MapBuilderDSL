package ast;

public class Assignment extends Statement {

    private String variableName;


    public Assignment(String variableName) {
        this.variableName = variableName;
    }


    @Override
    public <C,T> T accept(C context, MapVisitor<C,T> v) {
        return null;
    }
}
