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
        Map map = new Map(200, 200, RegionType.DESERT.getColor(), "My Map");
        Region ocean = new Region(new Point(0, 0), 100, 200, RegionType.WATER, "ocean", false);
        Region forest = new Region(new Point(100, 100), 50, 100, RegionType.FOREST, "", false);
        Region forest2 = new Region(new Point(0, 150), 50, 200, RegionType.GRASS, "grass", false);
        Region dessert = new Region(new Point(0, 100), 50, 100, RegionType.DESERT, "hi", false);
        Feature mountain = new Feature("mountains", new Point(120, 120), "", 32);
        Feature sea = new Feature("waves", new Point(50, 50), "wave boi", 32);
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<Region> regions = new ArrayList<>();
        features.add(mountain);
        Feature mountainBoi = mountain;
        for (int i = 0; i<3; i++) {
            Feature newMountain = (Feature) mountainBoi.clone();
            newMountain.setLocation(new Point(mountainBoi.getLocation().x + mountainBoi.getSize() + 4, mountainBoi.getLocation().y));
            newMountain.setLabel("");
            features.add(newMountain);
            mountainBoi = newMountain;
        }
        features.add(sea);
        regions.add(ocean);
        regions.add(forest);
        regions.add(forest2);
        regions.add(dessert);
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
