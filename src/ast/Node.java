package ast;

public abstract class Node {
    abstract public <T> T accept(MapVisitor<T> v);
}
