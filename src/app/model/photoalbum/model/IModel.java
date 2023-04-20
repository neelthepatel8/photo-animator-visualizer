package app.model.photoalbum.model;

import java.util.List;

import app.model.commands.Command;
import app.model.exceptions.IllegalShapeException;
import app.model.photoalbum.canvas.ICanvas;
import app.model.photoalbum.snapshot.ISnapshot;

public interface IModel {
  void execute(Command command) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException;
  ICanvas getCanvas();
  void snap(String description);
  void history();
  ISnapshot getNextSnapshot();
  ISnapshot getNextSnapshot(boolean first);
  ISnapshot getPreviousSnapshot();
  ISnapshot getSnapshotFromID(String id);
  List<ISnapshot> getSnapshots();
}
