package model.photoalbum;

import java.util.LinkedHashMap;

import model.commands.Command;
import model.exceptions.IllegalShapeException;
import model.photoalbum.snapshot.Snapshot;

public interface IModel {
  void execute(Command command) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException;
  Canvas getCanvas();
  void snap(String description);
  void history();
  LinkedHashMap<Snapshot, String> getSnapshots();
  Snapshot getLastSnapshot();
}
