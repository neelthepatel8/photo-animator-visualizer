package model.commands;

import model.photoalbum.Canvas;
import model.shape.Shape;

/**
 * The type Change radius command.
 */
public class ChangeRadiusCommand implements Command {
  private final double radius;
  private final Shape shape;

  /**
   * Instantiates a new Change radius command.
   *
   * @param radius    the radius
   * @param shapeName the shape name
   */
  public ChangeRadiusCommand(double radius, String shapeName) {
    this.radius = radius;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setRadius(radius);

  }
}
