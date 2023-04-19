package model.photoalbum;

import model.commands.Command;
import model.exceptions.IllegalShapeException;
import model.photoalbum.snapshot.ICanvas;
import model.photoalbum.snapshot.Snapshot;

public interface IModel {
  void execute(Command command) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException;
  ICanvas getCanvas();
  void snap(String description);
  void history();
  Snapshot getLastSnapshot();
}
