package ui;

import ast.MapEvaluator;
import ast.Program;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import parser.MapParser;
import parser.MapLexer;
import parser.ParseTreeToAST;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //MapLexer lexer = new MapLexer(CharStreams.fromFileName("testExpressionAndConditional.tdot"));
        MapLexer lexer = new MapLexer(CharStreams.fromFileName("testRendering.tdot"));
        for (Token token : lexer.getAllTokens()) {
            System.out.println(token);
        }
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        System.out.println("Done tokenizing");

        MapParser parser = new MapParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Program parsedProgram = visitor.visitProgram(parser.program());
        for (String error : visitor.errors) {
            System.out.println(error);
        }
        MapEvaluator<Void> evaluator = new MapEvaluator<>();
        parsedProgram.accept(evaluator);
        Renderer renderer = new Renderer(MapEvaluator.map, MapEvaluator.features, MapEvaluator.regions, MapEvaluator.featurePlacements);
        System.out.println("Done parsing");

        JFrame frame = new JFrame();
        int mapWidth = MapEvaluator.map.getWidth();
        int mapHeight = MapEvaluator.map.getHeight();
        BufferedImage image = renderer.renderMap();
        JLabel label = new JLabel(new ImageIcon(image));
        JLabel title = new JLabel(MapEvaluator.map.getTitle());
        title.setSize(mapWidth + 100, 100);
        title.setHorizontalTextPosition(JLabel.CENTER);
        frame.add(title);
        frame.add(label);
        frame.setSize(mapWidth + 100, mapHeight + 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}