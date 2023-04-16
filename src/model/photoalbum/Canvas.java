package model.photoalbum;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.commands.Command;
import model.exceptions.IllegalShapeException;
import model.shape.Shape;
import model.shape.ShapeBuilder;

/**
 * The type Canvas.
 */
public class Canvas {

  private static List<Shape> shapes = null;

  /**
   * Instantiates a new Canvas.
   */
  public Canvas() {
    shapes = new ArrayList<>();
  }

  /**
   * Execute.
   *
   * @param command the command
   * @throws IllegalShapeException  the illegal shape exception
   * @throws NoSuchFieldException   the no such field exception
   * @throws IllegalAccessException the illegal access exception
   */
  public void execute(Command command) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    command.execute();
  }

  /**
   * Shape create that uses the shape builder based on the
   * shape type sets the required values.
   *
   * @param shapeType       :       the type of shape to be created
   * @param shapeProperties : the properties of the shape to be created
   * @throws IllegalShapeException  the illegal shape exception
   * @throws NoSuchFieldException   the no such field exception
   * @throws IllegalAccessException the illegal access exception
   */
  public void create(String shapeType, String shapeProperties) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    String[] properties = shapeProperties.split(" ");

    // Set common properties:
    shapeBuilder
            .start()
            .setName(properties[0])
            .setX(Double.parseDouble(properties[1]))
            .setY(Double.parseDouble(properties[2]))
            .setColor((Color) Color.class.getField(properties[3]).get(null));

    // Set shape specific properties:
    switch (shapeType.toLowerCase()) {
      case "rectangle":
        shapeBuilder
                .setWidth(Double.parseDouble(properties[4]))
                .setHeight(Double.parseDouble(properties[5]));
        break;
      case "oval":
        shapeBuilder
                .setRadiusX(Double.parseDouble(properties[4]))
                .setRadiusY(Double.parseDouble(properties[5]));
        break;
      case "circle":
        shapeBuilder
                .setRadius(Double.parseDouble(properties[4]));
        break;

      default:
        throw new IllegalShapeException("Shape type not supported");
    }
    shapes.add(shapeBuilder.build());
  }


  /**
   * Remove a shape from the list of shapes
   * Should check for shape name
   *
   * @param shapeName : the name of the shape to be removed
   */
  public void remove(String shapeName) {
    shapes.removeIf(shape -> shape.getName().equals(shapeName));
  }


  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  public List<Shape> getShapes() {
    return shapes;
  }

  /**
   * Find shape shape.
   *
   * @param shapeName the shape name
   * @return the shape
   */
  public static Shape findShape(String shapeName) {
    for (Shape shape : shapes) {
      if (shape.getName().equalsIgnoreCase(shapeName)) {
        return shape;
      }
    }
    return null;
  }


  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Shape Information: \n");
    for (Shape shape : shapes) {
      result.append(shape.toString());
      result.append("\n\n");
    }
    return result.toString();
  }

}
