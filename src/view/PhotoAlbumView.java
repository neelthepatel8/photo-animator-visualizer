package view;

import java.awt.*;

import javax.swing.*;

import model.photoalbum.PhotoAlbum;

public class PhotoAlbumView extends JFrame implements View {

  private Panel mainPanel;

  public PhotoAlbumView(int width, int height) {
    this.setTitle("Photo Album");
    this.setSize(new Dimension(width, height));

    mainPanel = new Panel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));



  }

}
