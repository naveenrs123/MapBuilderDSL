// Generated from /Users/kaicycle/bike-boy-does-school/CS410/Project1Group8/ProjectFiles/src/parser/MapParser.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MapParser}.
 */
public interface MapParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MapParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MapParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MapParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(MapParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(MapParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(MapParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(MapParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapParser#place_and_call}.
	 * @param ctx the parse tree
	 */
	void enterPlace_and_call(MapParser.Place_and_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapParser#place_and_call}.
	 * @param ctx the parse tree
	 */
	void exitPlace_and_call(MapParser.Place_and_callContext ctx);
}