package ast;

import java.util.ArrayList;
import java.util.HashSet;

public class Def extends Node {

    public static HashSet<Function> functions;
    public static HashSet<DefineFeature> featureDefinitions;

    public Def(HashSet<Function> functions, HashSet<DefineFeature> featureDefinitions) {
        Def.functions = functions;
        Def.featureDefinitions = featureDefinitions;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
