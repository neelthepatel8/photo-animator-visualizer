package model.commands;

import photoalbum.Canvas;
import shape.Shape;

/**
 * The type Change radius y command.
 */
public class ChangeRadiusYCommand implements Command {

  private final double radiusY;
  private final Shape shape;

  /**
   * Instantiates a new Change radius y command.
   *
   * @param radiusY   the radius y
   * @param shapeName the shape name
   */
  public ChangeRadiusYCommand(double radiusY, String shapeName) {
    this.radiusY = radiusY;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setRadiusY(radiusY);
  }
}
