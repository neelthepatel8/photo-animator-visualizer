package model.commands;

import photoalbum.Canvas;

/**
 * The type Remove shape command.
 */
public class RemoveShapeCommand implements Command {
  private final String shapeName;
  private final Canvas canvas;

  /**
   * Instantiates a new Remove shape command.
   *
   * @param shapeName the shape name
   * @param canvas    the canvas
   */
  public RemoveShapeCommand(String shapeName, Canvas canvas) {
    this.shapeName = shapeName;
    this.canvas = canvas;
  }

  @Override
  public void execute() {
    canvas.remove(shapeName);
  }
}
