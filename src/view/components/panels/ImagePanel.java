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
        int[] properties = shape.scale(shape.getType(), size, 600);
        this.draw(g2d, properties[0], properties[1], properties[2], properties[3], properties[4], shape.getType());
      }

  }

  private void draw(Graphics g, int newX, int newY, int newFirst, int newSecond, int color, String type) {
    g.setColor(new Color(color));

    switch(type.toLowerCase()) {
      case "rectangle":
        g.fillRect(newX, newY, newFirst, newSecond);
      case "oval":
        g.fillOval(newX, newY, newFirst, newSecond);
      case "circle":
        g.fillOval(newX, newY, newFirst, newSecond);
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
