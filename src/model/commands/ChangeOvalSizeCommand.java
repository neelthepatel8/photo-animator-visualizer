package model.commands;

import model.photoalbum.Canvas;
import model.shape.Shape;

public class ChangeOvalSizeCommand implements Command{
  private final double radiusX;
  private final double radiusY;
  private final Shape shape;

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
