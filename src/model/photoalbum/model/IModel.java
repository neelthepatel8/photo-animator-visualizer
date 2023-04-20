package model.photoalbum.model;

import java.util.List;

import model.commands.Command;
import model.exceptions.IllegalShapeException;
import model.photoalbum.canvas.ICanvas;
import model.photoalbum.snapshot.Snapshot;

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
