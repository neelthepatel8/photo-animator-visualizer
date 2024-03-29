package app.model.commands;

import app.model.exceptions.IllegalShapeException;
import app.model.photoalbum.canvas.ICanvas;

/**
 * The type Create shape command.
 */
public class CreateShapeCommand implements Command {
  private final ICanvas canvas;
  private final String shapeType;
  private final String shapeProperties;

  /**
   * Instantiates a new Create shape command.
   *
   * @param canvas          the canvas
   * @param shapeType       the shape type
   * @param shapeProperties the shape properties
   */
  public CreateShapeCommand(ICanvas canvas, String shapeType, String shapeProperties) {
    this.canvas = canvas;
    this.shapeType = shapeType;
    this.shapeProperties = shapeProperties;
  }

  @Override
  public void execute() throws IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    canvas.create(shapeType, shapeProperties);
  }
}
