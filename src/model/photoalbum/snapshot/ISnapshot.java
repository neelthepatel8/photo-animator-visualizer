package model.photoalbum.snapshot;

import java.util.List;

import model.photoalbum.canvas.ICanvas;
import model.shape.IShape;

public interface ISnapshot {
  List<IShape> getShapes();
  void snap(ICanvas canvas, String description);
  String getId();
  String getDescription();
}
