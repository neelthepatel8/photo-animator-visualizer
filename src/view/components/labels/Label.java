package view.components.labels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Label extends JLabel {
  public Label(String text) {
    super(text);
  }

  public Label(String normal, String hover) {
    super(generateIcon(normal));

    Icon defaultIcon = generateIcon(normal);
    Icon hoverIcon = generateIcon(hover);

    Label label = this;
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        label.setIcon(hoverIcon);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        label.setIcon(defaultIcon);
      }
    });
  }

  public void setImage(String imageName) {
    super.setIcon(generateIcon(imageName));
  }

  public Label(String image, boolean isSnapshot) {
      super(generateIcon(image));
  }

  public Label(ImageIcon image) {
      super(image);
  }

  private static Icon generateIcon(String filename) {
    return new ImageIcon(filename);
  }

}
