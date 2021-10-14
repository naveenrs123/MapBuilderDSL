package ui;

import model.Feature;
import model.FeaturePlacement;
import model.Map;
import model.Region;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Renderer {

    private final Map map;
    private final java.util.Map<String, Feature> features;
    private final java.util.Map<String, Region> regions;
    private final java.util.Map<String, java.util.Map<String, ArrayList<FeaturePlacement>>> featurePlacements;
    private final Integer ppp = Map.PIXELS_PER_POINT;


    public Renderer(Map map,
                    java.util.Map<String, Feature> features,
                    java.util.Map<String, Region> regions,
                    java.util.Map<String, java.util.Map<String, ArrayList<FeaturePlacement>>> featurePlacements) {
        this.map = map;
        this.features = features;
        this.regions = regions;
        this.featurePlacements = featurePlacements;
    }

    public BufferedImage renderMap() {

        for (Region region: regions.values()) {
            renderRegion(region);
        }
        renderMapFeatures();
        return map.getImage();
    }

    private void renderMapFeatures() {
        java.util.Map<String, ArrayList<FeaturePlacement>> placements = featurePlacements.get("map");
        for (java.util.Map.Entry<String, ArrayList<FeaturePlacement>> entry: placements.entrySet()) {
            String featureName = entry.getKey();
            Feature feature = features.get(featureName);
            for (FeaturePlacement placement: entry.getValue()) {
                renderFeature(feature, placement);
            }
        }
    }

    private void renderFeature(Feature feature, FeaturePlacement placement) {
        BufferedImage image = map.getImage();
        Graphics2D g2d = image.createGraphics();
        int x = placement.getLocation().x;
        int y = placement.getLocation().y;
        g2d.drawImage(feature.getIcon(), null, x, y);
        g2d.setPaint(determineLabelColor(new Color(image.getRGB(x, y))));
        String label = placement.getLabel();
        int featureHeight = 24; // size of feature in pixels
        int fontSize = getScaledFontSize(featureHeight);
        if (placement.isShowLabel()) {
            drawLabel(label, g2d, fontSize, x - feature.getSize()/3, y - ppp);
        }
    }


    private void renderRegion(Region region) {
        BufferedImage image = map.getImage();
        Graphics2D g2d = image.createGraphics();
        int startX = region.getCorner().x;
        int startY = region.getCorner().y;
        g2d.setPaint(region.getRegionType().getColor());
        for (int x = startX; x<startX+ region.getWidth(); x+=ppp) {
            for (int y = startY; y<startY + region.getHeight(); y+=ppp) {
                Random rand = new Random();
                if ((rand.nextInt() % region.getRegionType().getRandFactor()) == 0) {
                    g2d.setPaint(region.getRegionType().getSecondaryColor());
                }
                g2d.fillRect(x, y, ppp, ppp);
                g2d.setPaint(region.getRegionType().getColor());
            }
        }
        if (featurePlacements.containsKey(region.getLabel())) {
            renderContainedFeatures(region);
        }
        if (region.isShowLabel()) {
            g2d.setPaint(determineLabelColor(region.getRegionType().getColor()));
            String label = region.getLabel();
            int fontSizePixels = (int) (map.getHeight() * 0.06); // 5% of map height as size of font in pixels for region label
            int fontSize = getScaledFontSize(fontSizePixels);
            drawLabel(label, g2d, fontSize, startX + (region.getWidth() / 2) - (fontSize), startY + (region.getHeight())/2);
        }
    }

    private void renderContainedFeatures(Region region) {
        java.util.Map<String, ArrayList<FeaturePlacement>> placements =featurePlacements.get(region.getLabel());
        Point regionCorner = region.getCorner();
        for (java.util.Map.Entry<String, ArrayList<FeaturePlacement>> entry: placements.entrySet()) {
            String featureName = entry.getKey();
            Feature feature = features.get(featureName);
            for (FeaturePlacement placement: entry.getValue()) {
                Point point = placement.getLocation();
                placement.setLocation(new Point(regionCorner.x + point.x, regionCorner.y + point.y));
                renderFeature(feature, placement);
            }
        }

    }

    private void drawLabel(String label, Graphics2D g2d, int fontSize, int x, int y) {
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font font = g2d.getFont();
        g2d.setFont(new Font(font.getName(), font.getStyle(), fontSize));
        g2d.drawString(label, x, y);
    }

    private Color determineLabelColor(Color color) {
        int colorBrightness = getBrightness(color);
        int blackBrightness = getBrightness(Color.black);
        int whiteBrightness = getBrightness(Color.white);
        int whiteContrast = Math.abs(colorBrightness - whiteBrightness);
        int blackContrast = Math.abs(colorBrightness - blackBrightness);
        if (whiteContrast > blackContrast) {
            return Color.white;
        } else {
            return Color.black;
        }
    }

    private int getBrightness(Color color) {
        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();
        return (299*R + 587*G + 114*B) / 1000;
    }


    private void drawGrid() {
        Graphics2D g2d = map.getImage().createGraphics();
        g2d.setPaint(new Color(0,0,0));
        for (int y = 0; y< map.getHeight(); y += ppp) {
            for (int x = 0; x< map.getWidth(); x+= ppp) {
                g2d.drawRect(x, y, ppp, ppp);
            }
        }
    }

    private int getScaledFontSize(int pixels) {
        return (72 * pixels / Toolkit.getDefaultToolkit().getScreenResolution());
    }
}
