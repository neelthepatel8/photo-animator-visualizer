package model.commands;

import photoalbum.Canvas;
import shape.Shape;

/**
 * The type Change height command.
 */
public class ChangeHeightCommand implements Command {
  private final double height;
  private final Shape shape;

  /**
   * Instantiates a new Change height command.
   *
   * @param height    the height
   * @param shapeName the shape name
   */
  public ChangeHeightCommand(double height, String shapeName) {
    this.height = height;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setHeight(height);
  }
}
