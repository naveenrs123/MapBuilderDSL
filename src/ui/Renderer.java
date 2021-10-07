package ui;

import model.Feature;
import model.Map;
import model.Region;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer {

    private Map map;
    private Integer ppp = Map.PIXELS_PER_POINT;


    public Renderer(Map map) {
        this.map = map;
    }

    public BufferedImage renderMap(ArrayList<Region> regions,
                                   ArrayList<Feature> features) {

        for (Region region: regions) {
            renderRegion(region);
        }
        for (Feature feature: features) {
            renderFeature(feature);
        }
        //drawGrid();
        return map.getImage();
    }

    private void renderFeature(Feature feature) {
        BufferedImage image = map.getImage();
        Graphics2D g2d = image.createGraphics();
        int x = feature.getLocation().x;
        int y = feature.getLocation().y;
        g2d.drawImage(feature.getIcon(), null, x, y);
        g2d.setPaint(new Color(255, 255, 255));
        String label = feature.getLabel();
        Font font = g2d.getFont();
        int featureHeight = 24; // size of feature in pixels
        g2d.setFont(new Font(font.getName(), font.getStyle(), getScaledFontSize(featureHeight)));
        g2d.drawString(label, x, y - ppp);
    }


    private void renderRegion(Region region) {
        BufferedImage image = map.getImage();
        Graphics2D g2d = image.createGraphics();
        int x = region.getCorner().x;
        int y = region.getCorner().y;
        g2d.setPaint(region.getRegionType().getColor());
        g2d.fillRect(x, y, region.getWidth(), region.getHeight());
        g2d.setPaint(new Color(255, 255, 255));
        String label = region.getLabel();
        Font font = g2d.getFont();
        int fontSizePixels = (int) (map.getHeight() * 0.05); // 5% of map height as size of font in pixels for region label
        int fontSize = getScaledFontSize(fontSizePixels);
        g2d.setFont(new Font(font.getName(), font.getStyle(), fontSize));
        g2d.drawString(label, x + (region.getWidth() / 2) - (fontSize),
                y + (region.getHeight())/2);
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
