package model.commands;

import model.photoalbum.canvas.ICanvas;

/**
 * The type Remove shape command.
 */
public class RemoveShapeCommand implements Command {
  private final String shapeName;
  private final ICanvas canvas;

  /**
   * Instantiates a new Remove shape command.
   *
   * @param shapeName the shape name
   * @param canvas    the canvas
   */
  public RemoveShapeCommand(String shapeName, ICanvas canvas) {
    this.shapeName = shapeName;
    this.canvas = canvas;
  }

  @Override
  public void execute() {
    canvas.remove(shapeName);
  }
}
