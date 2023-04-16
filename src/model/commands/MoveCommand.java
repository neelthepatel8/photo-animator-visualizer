package model.commands;

import model.photoalbum.Canvas;
import model.shape.Shape;

/**
 * The type Move command.
 */
public class MoveCommand implements Command {
  private final double x;
  private final double y;
  private final Shape shape;

  /**
   * Instantiates a new Move command.
   *
   * @param x         the x
   * @param y         the y
   * @param shapeName the shape name
   */
  public MoveCommand(double x, double y, String shapeName) {
    this.x = x;
    this.y = y;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setX(x);
    shape.setY(y);
  }
}
