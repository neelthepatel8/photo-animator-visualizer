package app.model.commands;

import app.model.photoalbum.canvas.Canvas;
import app.model.shape.IShape;

/**
 * The type Change name command.
 */
public class ChangeNameCommand implements Command {
  private final String name;
  private final IShape shape;

  /**
   * Instantiates a new Change name command.
   *
   * @param name      the name
   * @param shapeName the shape name
   */
  public ChangeNameCommand(String name, String shapeName) {
    this.name = name;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setName(name);
  }
}
