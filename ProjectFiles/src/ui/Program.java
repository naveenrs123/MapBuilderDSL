package ui;

import model.Feature;
import model.Map;
import model.Region;
import model.RegionType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Map map = new Map(200, 200, RegionType.DESSERT.getColor(), "My Map");
        Region ocean = new Region(new Point(0, 0), 100, 200, RegionType.OCEAN, "ocean");
        Region forest = new Region(new Point(100, 100), 50, 100, RegionType.FOREST, "");
        Feature feature = new Feature("mountains", new Point(120, 120), "rocky");
        Feature sea = new Feature("waves", new Point(50, 50), "");
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<Region> regions = new ArrayList<>();
        features.add(feature);
        features.add(sea);
        regions.add(ocean);
        regions.add(forest);
        Renderer renderer = new Renderer(map);
        BufferedImage image = renderer.renderMap(regions, features);
        JLabel label = new JLabel(new ImageIcon(image));
        JLabel title = new JLabel(map.getTitle());
        title.setSize(600, 100);
        title.setHorizontalTextPosition(JLabel.CENTER);
        frame.add(title);
        frame.add(label);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
