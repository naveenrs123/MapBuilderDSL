package ast;

/**
 *
 * @param <Y> Represents type of the value in the variable.
 */
public class Variable<Y> extends Statement {

    private String name;
    private Y value;
    private String referencedVariable = null;

    public Variable(String name, Y value, String referencedVariable) {
        this(name, value);
        this.referencedVariable = referencedVariable;
    }

    public Variable(String name, Y value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Y getValue() {
        return value;
    }

    public String getReferencedVariable() {
        return referencedVariable;
    }

    public boolean referencesOtherVariable() {
        return referencedVariable != null && !referencedVariable.isEmpty();
    }

    public String getValueType() {
       return this.value.getClass().getSimpleName();
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return null;
    }
}
