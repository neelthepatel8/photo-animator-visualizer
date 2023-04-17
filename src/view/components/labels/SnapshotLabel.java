package view.components.labels;

import java.awt.*;

import javax.swing.*;

public class SnapshotLabel extends Label{
  public SnapshotLabel(String image) {
    super("src/assets/snapshots/" + image + ".jpg", true);
  }

  public SnapshotLabel(ImageIcon image) {
    super(image);
  }
}
