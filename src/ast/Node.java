package ast;

public abstract class Node {
    abstract public <C,T> T accept(C context, MapVisitor<C,T> v);
}
