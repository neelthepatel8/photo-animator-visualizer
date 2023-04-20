package app.model.shape;

import app.util.IColor;

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
    if (x < 0) {
      throw new IllegalArgumentException("x cannot be negative");
    }
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
    if (y < 0) {
      throw new IllegalArgumentException("y cannot be negative");
    }
    shape.setY(y);
    return this;
  }

  /**
   * Sets color.
   *
   * @param color the color
   * @return the color
   */
  public ShapeBuilder setColor(IColor color) {
    if (color == null) {
      throw new IllegalArgumentException("color cannot be null");
    }
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
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("name cannot be null");
    }
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
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("type cannot be null");
    }
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
    if (width < 0) {
      throw new IllegalArgumentException("width cannot be negative");
    }
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
    if (height < 0) {
      throw new IllegalArgumentException("height cannot be negative");
    }
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
    if (radiusX < 0) {
      throw new IllegalArgumentException("radiusX cannot be negative");
    }
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
    if (radiusY < 0) {
      throw new IllegalArgumentException("radiusY cannot be negative");
    }
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
    if (radius < 0) {
      throw new IllegalArgumentException("radius cannot be negative");
    }
    shape.setRadius(radius);
    return this;
  }
}
