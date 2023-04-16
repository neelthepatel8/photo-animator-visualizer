package model.commands;

import model.photoalbum.Canvas;
import model.shape.Shape;

/**
 * The type Change width command.
 */
public class ChangeWidthCommand implements Command {
  private final double width;
  private final Shape shape;

  /**
   * Instantiates a new Change width command.
   *
   * @param width     the width
   * @param shapeName the shape name
   */
  public ChangeWidthCommand(double width, String shapeName) {
    this.width = width;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setWidth(width);
  }
}
