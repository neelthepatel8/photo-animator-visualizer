package app.model.photoalbum.canvas;

import java.util.List;

import app.model.exceptions.IllegalShapeException;
import app.model.shape.IShape;

public interface ICanvas {
  void create(String shapeType, String shapeProperties) throws IllegalShapeException;
  void remove(String shapeName);
  List<IShape> getShapes();
}
