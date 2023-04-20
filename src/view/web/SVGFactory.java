package view.web;

import java.awt.*;

public class SVGFactory {

  public static String generateRectangle(int x, int y, int height, int width, Color color) {
    return String.format("<rect x='%s' y='%s' width='%s' height='%s' fill='%s'/>", x, y, width, height, toHex(color));
  }

  public static String generateOval(int x, int y, int height, int width, Color color) {
    return String.format("<ellipse cx='%s' cy='%s' rx='%s' ry='%s' fill='%s'/>", x, y, width, height,  toHex(color));
  }

  public static String startSVG(int width, int height) {
    return String.format("<svg width='%s' height='%s'>", width, height);
  }

  public static String endSVG() {
    return "</svg>";
  }

  private static String toHex(Color color) {
    return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
  }

}
