package Helpers;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTHelpers {

    public static void handleParamList(ArrayList<String> paramValues, List<TerminalNode> textList) {
        List<TerminalNode> params = textList.size() > 1
                ? textList.subList(1, textList.size())
                : null;

        if (params != null) {
            for (TerminalNode param : params) {
                paramValues.add(param.getText());
            }
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
