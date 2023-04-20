package app.model.photoalbum.model;

import java.util.List;

import app.model.commands.Command;
import app.model.exceptions.IllegalShapeException;
import app.model.photoalbum.canvas.ICanvas;
import app.model.photoalbum.snapshot.Snapshot;

public interface IModel {
  void execute(Command command) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException;
  ICanvas getCanvas();
  void snap(String description);
  void history();
  Snapshot getNextSnapshot();
  Snapshot getNextSnapshot(boolean first);
  Snapshot getPreviousSnapshot();
  Snapshot getSnapshotFromID(String id);
  List<Snapshot> getSnapshots();
}
