package model.commands;

import model.photoalbum.Canvas;
import model.shape.Shape;

public class ChangeRectangleSizeCommand implements Command{
  private final double width;
  private final double height;
  private final Shape shape;

  public ChangeRectangleSizeCommand(double width, double height, String shapeName) {
    this.width = width;
    this.height = height;
    this.shape = Canvas.findShape(shapeName);
  }

  @Override
  public void execute() {
    shape.setWidth(width);
    shape.setHeight(height);
  }
}
