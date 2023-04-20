package app.model.photoalbum.snapshot;

import java.util.List;

import app.model.photoalbum.canvas.ICanvas;
import app.model.shape.IShape;

public interface ISnapshot {
  List<IShape> getShapes();
  void snap(ICanvas canvas, String description);
  String getId();
  String getDescription();
}
