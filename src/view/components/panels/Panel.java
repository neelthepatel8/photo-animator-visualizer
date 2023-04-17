package view.components.panels;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Panel extends JPanel {
//  private final String image = "background";
//  private Image backgroundImage = ImageIO.read(new File("src/assets/backgrounds/" + image + ".jpg"));

  public Panel(LayoutManager layout) throws IOException {
    super(layout);

  }

//  @Override
//  protected void paintComponent(Graphics g) {
//    super.paintComponent(g);
//    if (backgroundImage != null) {
//      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//    }
//  }

  public Panel() throws IOException {

  }


}
