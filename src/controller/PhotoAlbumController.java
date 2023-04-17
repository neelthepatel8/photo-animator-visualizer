package controller;

import java.io.IOException;

import model.photoalbum.PhotoAlbum;
import view.PhotoAlbumView;
import view.View;

public class PhotoAlbumController {

  private View view;
  private PhotoAlbum model;

  public PhotoAlbumController() throws IOException {

    this.view = new PhotoAlbumView(700, 1000, this);
    this.model = new PhotoAlbum();
    view.setVisible(true);
  }



  public static void main(String[] args) throws IOException {
    PhotoAlbumController controller = new PhotoAlbumController();
  }
}
