package view;

import java.awt.event.MouseEvent;
import java.io.IOException;

import model.photoalbum.snapshot.Snapshot;

public interface IView {

  void changeImage(String filename);
  void dispose();
  void setVisible(boolean visible);
  void updatePicture(Snapshot snap, int size) throws IOException;
  void setImage(String path, boolean first);
  void setDescription(String description);
  void setId(String id);
  void showSelectOptions(MouseEvent e);
  void setInitials();
}
