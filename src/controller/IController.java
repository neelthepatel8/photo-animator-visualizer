package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;

import model.exceptions.IllegalShapeException;
import model.exceptions.InvalidCommandException;

public interface IController {
  void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException, InvalidCommandException;

  boolean handleNext(MouseEvent e);
  boolean handlePrevious(MouseEvent e);
  void handleSelect(MouseEvent e);
  void handleClose(MouseEvent e);
  boolean handleSnapshotSelection(String id);


}
