package model.photoalbum.canvas;

import java.util.List;

import model.exceptions.IllegalShapeException;
import model.shape.IShape;
import model.shape.Shape;

public interface ICanvas {
  void create(String shapeType, String shapeProperties) throws IllegalShapeException;
  void remove(String shapeName);
  List<IShape> getShapes();
}
