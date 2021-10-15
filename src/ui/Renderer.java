package ui;

import model.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;

public class Renderer {

    private final WorldMap map;
    private final Map<String, Feature> features;
    private final Map<String, Region> regions;
    private final ArrayList<Placement> placements;
    private final Integer ppp = WorldMap.PIXELS_PER_POINT;


    public Renderer(WorldMap map,
                    Map<String, Feature> features,
                    Map<String, Region> regions,
                    ArrayList<Placement> placements) {
        this.map = map;
        this.features = features;
        this.regions = regions;
        this.placements = placements;
    }

    public BufferedImage renderMap() {

        for (Placement placement: placements) {
            if (placement instanceof Region) {
                renderRegion((Region) placement);
            } else {
                renderFeature((FeaturePlacement) placement);
            }
        }
        return map.getImage();
    }


    private void renderFeature(FeaturePlacement placement) {
        String id = placement.getId();
        Feature feature = features.get(id);
        BufferedImage image = map.getImage();
        Graphics2D g2d = image.createGraphics();
        int x;
        int y;
        if (!Objects.equals(placement.getRegion(), "map")) {
            Region region = regions.get(placement.getRegion());
            Point regionCorner = region.getCorner();
            x = placement.getLocation().x + regionCorner.x;
            y = placement.getLocation().y + regionCorner.y;
        } else {
            x = placement.getLocation().x;
            y = placement.getLocation().y;
        }
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
        if (region.isShowLabel()) {
            g2d.setPaint(determineLabelColor(region.getRegionType().getColor()));
            String label = region.getLabel();
            int fontSizePixels = (int) (map.getHeight() * 0.06); // 5% of map height as size of font in pixels for region label
            int fontSize = getScaledFontSize(fontSizePixels);
            drawLabel(label, g2d, fontSize, startX + (region.getWidth() / 2) - (fontSize), startY + (region.getHeight())/2);
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
