package app.view.components.labels;

import javax.swing.*;

public class SnapshotLabel extends Label{
  public SnapshotLabel(String image) {
    super("src/resources.assets/snapshots/" + image + ".jpg", true);
  }

  public SnapshotLabel(ImageIcon image) {
    super(image);
  }
}
