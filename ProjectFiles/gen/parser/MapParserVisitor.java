// Generated from /Users/kaicycle/bike-boy-does-school/CS410/Project1Group8/ProjectFiles/src/parser/MapParser.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MapParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MapParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MapParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MapParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(MapParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(MapParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapParser#place_and_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_and_call(MapParser.Place_and_callContext ctx);
}