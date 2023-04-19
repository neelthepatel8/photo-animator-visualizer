package model.shape;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Shape class has properties of a shape and methods.
 */
public class Shape implements DrawerFunction{

  private double x;
  private double y;
  private Color color;
  private String name;
  private String type;
  private double width;
  private double height;
  private double radiusX;
  private double radiusY;
  private double radius;
  private Function<Graphics, Void> drawFunction;

  /**
   * Instantiates a new Shape.
   */
  public Shape() {
    this.x = 0;
    this.y = 0;
    this.color = Color.BLACK;
    this.name = "";
    this.type = "";
    this.width = 0;
    this.height = 0;
    this.radiusX = 0;
    this.radiusY = 0;
    this.radius = 0;
    this.drawFunction = null;

  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public double getX() {
    return x;
  }

  public void draw(Graphics g, int forCanvas, int toCanvas) {
    g.setColor(color);
    int newX = (int) ((x / forCanvas) * toCanvas);
    int newY = (int) ((y / forCanvas) * toCanvas);
    int newWidth = (int) ((width / forCanvas) * toCanvas);
    int newHeight = (int) ((height / forCanvas) * toCanvas);
    int newRadiusX = (int) ((radiusX / forCanvas) * toCanvas);
    int newRadiusY = (int) ((radiusY / forCanvas) * toCanvas);
    int newRadius = (int) ((radius / forCanvas) * toCanvas);

    switch(type.toLowerCase()) {
      case "rectangle":
        g.fillRect(newX, newY, newWidth, newHeight);
      case "oval":
          g.fillOval(newX, newY, newRadiusX, newRadiusY);
      case "circle":
          g.fillOval(newX, newY, newRadius, newRadius);
    }
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public double getY() {
    return y;
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  public Color getColor() {
    return color;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Gets radius x.
   *
   * @return the radius x
   */
  public double getRadiusX() {
    return radiusX;
  }

  /**
   * Gets radius y.
   *
   * @return the radius y
   */
  public double getRadiusY() {
    return radiusY;
  }

  /**
   * Gets radius.
   *
   * @return the radius
   */
  public double getRadius() {
    return radius;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Sets color.
   *
   * @param color the color
   */
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(String type) {
    this.type = type;


  }

  /**
   * Sets width.
   *
   * @param width the width
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(double height) {
    this.height = height;
  }

  /**
   * Sets radius x.
   *
   * @param radiusX the radius x
   */
  public void setRadiusX(double radiusX) {
    this.radiusX = radiusX;
  }

  /**
   * Sets radius y.
   *
   * @param radiusY the radius y
   */
  public void setRadiusY(double radiusY) {
    this.radiusY = radiusY;
  }

  /**
   * Sets radius.
   *
   * @param radius the radius
   */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /**
   * TO string should print out stuff that is not null or 0.
   * if it is null or 0 dont return it in the string.
   *
   * @return
   */
  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    if (!name.isBlank())
      sb.append("Name: ").append(name);
    if (!type.isBlank())
      sb.append(" Type: ").append(type);
    if (x != 0)
      sb.append("\n| X: ").append(x);
    if (y != 0)
      sb.append(" | Y: ").append(y);
    if (color != null)
      sb.append(" | Color: ").append("(").append(color.getRed()).append(",").append(color.getGreen()).append(",").append(color.getBlue()).append(")");
    if (width != 0)
      sb.append(" | Width: ").append(width);
    if (height != 0)
      sb.append(" | Height: ").append(height);
    if (radiusX != 0)
      sb.append(" | RadiusX: ").append(radiusX);
    if (radiusY != 0)
      sb.append(" | RadiusY: ").append(radiusY);
    if (radius != 0)
      sb.append(" | Radius: ").append(radius);

    return sb.toString();
  }
}
