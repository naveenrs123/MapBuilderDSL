package parser;

import ast.*;
import org.antlr.v4.runtime.tree.*;

public class ParseTreeToAST extends AbstractParseTreeVisitor<Node> implements MapParserVisitor<Node>  {
    @Override
    public Program visitProgram(MapParser.ProgramContext ctx) {
        return null;
    }

    @Override
    public Map visitMap(MapParser.MapContext ctx) {
        return null;
    }

    @Override
    public Def visitDef(MapParser.DefContext ctx) {
        return null;
    }

    @Override
    public PlaceAndCall visitPlace_and_call(MapParser.Place_and_callContext ctx) {
        return null;
    }
}
