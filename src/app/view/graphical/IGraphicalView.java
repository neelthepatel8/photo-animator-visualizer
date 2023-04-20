package app.view.graphical;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import app.model.shape.IShape;

public interface IGraphicalView {
  void switchToNew(List<IShape> shapes, String description, String id);
  void close();
  void loadSnapshot(List<IShape> shapes, int size) throws IOException;
  void initialize(List<IShape> shapes, String desc, String id, int size);
  void displaySnapshotList(List<String> snapshotIDs, MouseEvent e);
  void error();
}
