package ast;

import java.util.Map;
import java.util.HashMap;

public class MapVariableChecker implements MapVisitor<Map<String, Boolean>, String> {
    @Override
    public String visit(Map<String, Boolean> status, Program p) {
        StringBuilder buf = new StringBuilder();
        buf.append(p.getMap().accept(status,this));
        for (Def def: p.getDefs()) {
            buf.append(def.accept(status, this));
        }
        buf.append(p.getPlaceAndCall().accept(status,this));
        return buf.toString();
    }

    @Override
    public String visit(Map<String, Boolean> context, ast.Map p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, Def p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, DefineFeature p) {
        String featureIcon = p.getIcon();
        if (featureIcon.equals("wave") || featureIcon.equals("mountain") || featureIcon.equals("castle")) {
            return "";
        }
        return "Undefined icon " + featureIcon + "\n";
    }

    @Override
    public String visit(Map<String, Boolean> status, DefineFunction p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, Loop p) {
        return null;
    }

    @Override
    public String visit(Map<String, Boolean> status, Conditional p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, Variable<?> p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, PlaceAndCall p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, PlaceRegion p) {
        return "";
    }

    @Override
    public String visit(Map<String, Boolean> status, PlaceFeature p) {
        String featureType = p.getFeatureType();
        Boolean varStatus = status.get(featureType);
        if (varStatus == null) {
            return "Undeclared feature type " + featureType + "\n";
        } else if (varStatus) {
            return "";
        } else {
            return "Undeclared feature type " + featureType + "\n";
        }
    }

    @Override
    public String visit(Map<String, Boolean> status, FunctionCall p) {
        return "";
    }
}
