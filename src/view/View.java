package view;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import model.photoalbum.snapshot.Snapshot;
import model.shape.Shape;
import model.shape.SnapshotShape;

public interface View {

  void changeImage(String filename);
  void dispose();
  void setVisible(boolean visible);
  void updatePicture(Snapshot snap, int size) throws IOException;
  void setImage(String path, boolean first);
  void setDescription(String description);
  void setId(String id);
  void showSelectOptions(MouseEvent e);
}
