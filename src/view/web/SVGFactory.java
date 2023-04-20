package view.web;

import java.awt.*;

public class SVGFactory {

  public static String generateRectangle(int x, int y, int height, int width, Color color) {
    return String.format("\t\t\t<rect x='%s' y='%s' width='%s' height='%s' fill='%s'/>\n", x, y, width, height, toHex(color));
  }

  public static String generateOval(int x, int y, int height, int width, Color color) {
    return String.format("\t\t\t<ellipse cx='%s' cy='%s' rx='%s' ry='%s' fill='%s'/>\n", x, y, width, height,  toHex(color));
  }

  public static String startSVG(int width, int height) {
    return String.format("\t\t<svg width='%s' height='%s'>\n", width, height);
  }

  public static String endSVG() {
    return "\t\t</svg>\n";
  }

  private static String toHex(Color color) {
    return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
  }

}
