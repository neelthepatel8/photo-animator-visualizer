package model.shape;

import java.awt.Color;

/**
 * The type Shape builder.
 */
public class ShapeBuilder {

  private Shape shape;
  private static final ShapeBuilder instance = new ShapeBuilder();

  private ShapeBuilder() {
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static ShapeBuilder getInstance() {
    return instance;
  }

  /**
   * Start shape builder.
   *
   * @return the shape builder
   */
  public ShapeBuilder start() {
    shape = new Shape();
    return this;
  }

  /**
   * Build shape.
   *
   * @return the shape
   */
  public Shape build() {
    return shape;
  }

  /**
   * Sets x.
   *
   * @param x the x
   * @return the x
   */
  public ShapeBuilder setX(double x) {
    shape.setX(x);
    return this;
  }

  /**
   * Sets y.
   *
   * @param y the y
   * @return the y
   */
  public ShapeBuilder setY(double y) {
    shape.setY(y);
    return this;
  }

  /**
   * Sets color.
   *
   * @param color the color
   * @return the color
   */
  public ShapeBuilder setColor(Color color) {
    shape.setColor(color);
    return this;
  }

  /**
   * Sets name.
   *
   * @param name the name
   * @return the name
   */
  public ShapeBuilder setName(String name) {
    shape.setName(name);
    return this;
  }

  /**
   * Sets type.
   *
   * @param type the type
   * @return the type
   */
  public ShapeBuilder setType(String type) {
    shape.setType(type);
    return this;
  }

  /**
   * Sets width.
   *
   * @param width the width
   * @return the width
   */
  public ShapeBuilder setWidth(double width) {
    shape.setWidth(width);
    return this;
  }

  /**
   * Sets height.
   *
   * @param height the height
   * @return the height
   */
  public ShapeBuilder setHeight(double height) {
    shape.setHeight(height);
    return this;
  }

  /**
   * Sets radius x.
   *
   * @param radiusX the radius x
   * @return the radius x
   */
  public ShapeBuilder setRadiusX(double radiusX) {
    shape.setRadiusX(radiusX);
    return this;
  }

  /**
   * Sets radius y.
   *
   * @param radiusY the radius y
   * @return the radius y
   */
  public ShapeBuilder setRadiusY(double radiusY) {
    shape.setRadiusY(radiusY);
    return this;
  }

  /**
   * Sets radius.
   *
   * @param radius the radius
   * @return the radius
   */
  public ShapeBuilder setRadius(double radius) {
    shape.setRadius(radius);
    return this;
  }
}
