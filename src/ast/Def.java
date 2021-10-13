package ast;

import java.util.HashSet;

public class Def extends Node {

    private HashSet<Function> functions;
    private HashSet<DefineFeature> featureDefinitions;

    public Def(HashSet<Function> functions, HashSet<DefineFeature> featureDefinitions) {
        this.functions = functions;
        this.featureDefinitions = featureDefinitions;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }

    public HashSet<Function> getFunctions() {
        return functions;
    }

    public HashSet<DefineFeature> getFeatureDefinitions() {
        return featureDefinitions;
    }
}
