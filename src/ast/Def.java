package ast;

import java.util.ArrayList;

public class Def extends Node {

    public static ArrayList<Function> functions;
    public static ArrayList<DefineFeature> featureDefinitions;

    public Def(ArrayList<Function> functions, ArrayList<DefineFeature> featureDefinitions) {
        Def.functions = functions;
        Def.featureDefinitions = featureDefinitions;
    }

    @Override
    public <T> T accept(MapVisitor<T> v) {
        return v.visit(this);
    }
}
