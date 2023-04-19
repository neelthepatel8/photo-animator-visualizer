package model.commands;

import java.awt.Color;

import model.photoalbum.canvas.Canvas;
import model.shape.Shape;

/**
 * The type Change color command.
 */
public class ChangeColorCommand implements Command {
  private final Color color;
  private final Shape shape;

  /**
   * Instantiates a new Change color command.
   *
   * @param color     the color
   * @param shapeName the shape name
   */
  public ChangeColorCommand(Color color, String shapeName) {
    this.color = color;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setColor(color);
  }
}
