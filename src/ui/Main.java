package ui;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import parser.MapLexer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MismatchedTokenException {
        MapLexer lexer = new MapLexer(CharStreams.fromFileName("testExpressionAndConditional.tdot"));
        for (Token token : lexer.getAllTokens()) {
            System.out.println(token);
        }
        lexer.reset();
        System.out.println("Done tokenizing");
    }

}