package app.controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import app.model.exceptions.IllegalShapeException;
import app.model.exceptions.InvalidCommandException;
import app.model.photoalbum.snapshot.ISnapshot;

public interface IController {
  void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException, InvalidCommandException;

  boolean handleNext(MouseEvent e);
  boolean handlePrevious(MouseEvent e);
  void handleSelect(MouseEvent e);
  void handleClose(MouseEvent e);
  boolean handleSnapshotSelection(String id);
  List<ISnapshot> generateAllSnapshots() throws IOException, InvalidCommandException, IllegalShapeException, NoSuchFieldException, IllegalAccessException;

}
