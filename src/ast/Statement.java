package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Statement extends Node {

    private String functionName;
    private List<String> paramNames = new ArrayList<>();
    private Map<String, String> paramsToValues = new HashMap<>();
    private boolean evaluate = false;


    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Map<String, String> getParamsToValues() {
        return paramsToValues;
    }

    public void setParamsToValues(Map<String, String> paramsToValues) {
        this.paramsToValues = paramsToValues;
    }

    public void setParamsToValues(List<String> names, List<String> values) {
        assert names.size() == values.size();
        for (int i = 0; i < names.size(); i ++) {
            paramsToValues.put(names.get(i), values.get(i));
        }
    }

    public void addParamValue(String paramName, String paramValue) {
        this.paramsToValues.put(paramName, paramValue);
    }

    public List<String> getParamNames() {
        return paramNames;
    }

    public void setParamNames(List<String> paramNames) {
        this.paramNames = paramNames;
    }

    public void addParamName(String name) {
        this.paramNames.add(name);
    }

    public boolean isEvaluate() {
        return evaluate;
    }

    public void setEvaluate(boolean evaluate) {
        this.evaluate = evaluate;
    }
}
