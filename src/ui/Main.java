package ui;

import ast.MapVariableChecker;
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
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        MapLexer lexer = new MapLexer(CharStreams.fromFileName("example3.tdot"));
        for (Token token : lexer.getAllTokens()) {
            System.out.println(token);
        }
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        System.out.println("Done tokenizing");

        MapParser parser = new MapParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Program parsedProgram = visitor.visitProgram(parser.program());
        System.out.println("Done parsing");

        // Static Check
        MapVariableChecker checker = new MapVariableChecker();
        Map<String, Boolean> variables = new HashMap<>();
        String errors = checker.visit(variables, parsedProgram);
        if (!errors.isEmpty()) {
            System.out.println("Static Checks Failed:\n" + errors);
            System.exit(1);
        }

        MapEvaluator e = new MapEvaluator();
        StringBuilder s = new StringBuilder();
        // Dynamic Check
        parsedProgram.accept(s,e);
        if (!s.isEmpty()) {
            System.out.println("Dynamic check failed: \n" + s.toString());
            System.exit(1);
        }
        System.out.println("Evaluation completed successfully");
        Renderer renderer = new Renderer(MapEvaluator.map, MapEvaluator.features, MapEvaluator.regions, MapEvaluator.placements);

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