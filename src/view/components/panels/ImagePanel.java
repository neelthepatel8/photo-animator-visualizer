package view.components.panels;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.ImageIO;

import model.photoalbum.snapshot.Snapshot;
import model.shape.Shape;
import model.shape.SnapshotShape;

public class ImagePanel extends Panel {

  private Snapshot snap;

  public ImagePanel() {
    this.setPreferredSize(new Dimension(600, 600));
    this.snap = null;
  }

  public void setShapes(Snapshot snap) {
    this.snap = snap;
  }

  @Override
  public void paintComponent(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;

      for (Shape shape : snap.getShapes()) {
        shape.draw(g2d);
      }

  }


  public void saveImage(int snapNumber) throws IOException {
    BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    this.paintComponent(g);
    ImageIO.write(image, "png", new File("src/assets/snapshots/snap-" + snapNumber + ".png"));
  }

}
