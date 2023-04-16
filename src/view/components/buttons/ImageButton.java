package view.components.buttons;

import java.awt.*;
import java.io.IOException;

import view.components.Image;

public class ImageButton extends Button {

  private int height;
  private int width;

  public ImageButton(String filename, int width, int height) throws IOException {
    super();
    this.width = width;
    this.height = height;
    this.setIcon(new Image(filename, true, width - 50, height - 50).getIcon());
    this.setMargin(new Insets(20, 20, 20, 20));
  }

  public ImageButton(String filename) throws IOException {
    super();
    this.setIcon(new Image(filename, true, 100 - 20, 200 - 40).getIcon());
    this.setMargin(new Insets(40, 40, 40, 40));
  }

}
