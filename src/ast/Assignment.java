package ast;

public class Assignment extends Statement {

    private String variableName;


    public Assignment(String variableName) {
        this.variableName = variableName;
    }
    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
