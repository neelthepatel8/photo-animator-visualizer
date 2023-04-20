package model.commands;

import model.photoalbum.canvas.Canvas;
import model.shape.IShape;

public class ChangeOvalSizeCommand implements Command{
  private final double radiusX;
  private final double radiusY;
  private final IShape shape;

  public ChangeOvalSizeCommand(double radiusX, double radiusY, String shapeName) {
    this.radiusX = radiusX;
    this.radiusY = radiusY;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setRadiusX(radiusX);
    shape.setRadiusY(radiusY);
  }
}
