package ui;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
//import parser.MapParser;
import parser.MapLexer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MismatchedTokenException {
        MapLexer lexer = new MapLexer(CharStreams.fromFileName("testExpressionAndConditional.tdot"));
        for (Token token : lexer.getAllTokens()) {
            System.out.println(token);
        }
        lexer.reset();
//        TokenStream tokens = new CommonTokenStream(lexer);
        System.out.println("Done tokenizing");

//        MapParser parser = new MapParser(tokens);
//        System.out.println(parser.program());
//        ParseTreeToAST visitor = new ParseTreeToAST();
//        String parsedProgram = visitor.visitProgram(parser.program());
//        System.out.println("Done parsing");
    }

}