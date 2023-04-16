package model.commands;

import photoalbum.Canvas;
import shape.Shape;

/**
 * The type Change radius x command.
 */
public class ChangeRadiusXCommand implements Command {
  private final double radiusX;
  private final Shape shape;

  /**
   * Instantiates a new Change radius x command.
   *
   * @param radiusX   the radius x
   * @param shapeName the shape name
   */
  public ChangeRadiusXCommand(double radiusX, String shapeName) {
    this.radiusX = radiusX;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setRadiusX(radiusX);
  }
}
