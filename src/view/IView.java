package view;

import java.awt.event.MouseEvent;
import java.io.IOException;

import model.photoalbum.snapshot.Snapshot;

public interface IView {

  void switchToNew(String imageName, String description, String id);
  void close();
  void updatePicture(Snapshot snap, int size) throws IOException;
}
