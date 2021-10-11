package ast;

import java.util.ArrayList;

public class Def extends Node {

    private final ArrayList<Function> functions;
    private final ArrayList<DefineFeature> featureDefinitions;

    public Def(ArrayList<Function> functions, ArrayList<DefineFeature> featureDefinitions) {
        this.functions = functions;
        this.featureDefinitions = featureDefinitions;
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public ArrayList<DefineFeature> getFeatureDefinitions() {
        return featureDefinitions;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
