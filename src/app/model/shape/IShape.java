package app.model.shape;

import app.util.IColor;

public interface IShape {
  int[] scale(String shapeType, int forCanvas, int toCanvas);
  double getX();
  double getY();
  IColor getColor();
  String getName();
  String getType();
  double getWidth();
  double getHeight();
  double getRadiusX();
  double getRadiusY();
  double getRadius();
  void setX(double x);
  void setY(double y);
  void setColor(IColor color);
  void setName(String name);
  void setType(String type);
  void setWidth(double width);
  void setHeight(double height);
  void setRadiusX(double radiusX);
  void setRadiusY(double radiusY);
  void setRadius(double radius);

}
