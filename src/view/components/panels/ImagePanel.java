package view.components.panels;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.photoalbum.snapshot.Snapshot;
import model.shape.Shape;
import view.components.labels.ImageLabel;

public class ImagePanel extends Panel {

  private Snapshot snap;
  private ImageLabel label;
  private int size;

  public ImagePanel() {
    this.setPreferredSize(new Dimension(600, 600));
    this.setBackground(Color.WHITE);
    this.snap = null;
    this.label = null;
    this.size = 0;
  }



  public void setShapes(Snapshot snap) {
    this.snap = snap;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public void paintComponent(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;

      for (Shape shape : snap.getShapes()) {
        shape.draw(g2d, size,600);
      }

  }

  public void setImage(String pathname) {
    if (this.label == null)  {
      this.label = new ImageLabel(pathname);
      this.add(this.label);
    }
    this.label.setImage(pathname);
  }


  public void saveImage(int snapNumber) throws IOException {
    BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    this.paintComponent(g);
    ImageIO.write(image, "png", new File("src/assets/snapshots/snap-" + snapNumber + ".png"));
  }

}
