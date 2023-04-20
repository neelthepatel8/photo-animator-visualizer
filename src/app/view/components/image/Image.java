package app.view.components.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Image  {

  private BufferedImage image;
  private ImageIcon icon;

  public Image(String fileName, boolean resize, int height, int width) throws IOException {
    image = ImageIO.read(new File(fileName));
    this.icon = new ImageIcon(image);

    if (resize) {
      this.icon = new ImageIcon(image.getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT));
    }

  }

  public ImageIcon getIcon() {
    return this.icon;
  }

}

