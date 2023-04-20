package app.model.commands;

import app.model.photoalbum.canvas.Canvas;
import app.model.shape.IShape;

public class ChangeCircleSizeCommand implements Command{
  private final double radius;
  private final IShape shape;

  public ChangeCircleSizeCommand(double radius, String shapeName) {
    this.radius = radius;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setRadius(radius);
  }
}
