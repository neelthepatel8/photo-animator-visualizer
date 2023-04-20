package view.components.panels;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.List;

import model.shape.IShape;
import model.shape.Shape;
import view.components.labels.ImageLabel;

public class ImagePanel extends Panel {

  private List<IShape> shapes;
  private ImageLabel label;
  private int size;

  public ImagePanel() {
    this.setPreferredSize(new Dimension(600, 600));
    this.setBackground(Color.WHITE);
    this.shapes = null;
    this.label = null;
    this.size = 0;
  }



  public void setShapes(List<IShape> shapes) {
    this.shapes = shapes;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public void paintComponent(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;

      for (IShape shape : shapes) {
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


}
