package view;

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
  void updatePicture(Snapshot snaps) throws IOException;
}
