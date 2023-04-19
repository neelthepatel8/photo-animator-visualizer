package model.photoalbum.snapshot;

import java.util.List;

import model.photoalbum.canvas.ICanvas;
import model.shape.Shape;

public interface ISnapshot {
  List<Shape> getShapes();
  void snap(ICanvas canvas, String description);
  String getId();
  String getDescription();
}
