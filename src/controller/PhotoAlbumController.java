package controller;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.commands.CommandFactory;
import model.exceptions.IllegalShapeException;
import model.photoalbum.Model;
import model.photoalbum.PhotoAlbumModel;
import view.PhotoAlbumView;
import view.View;


public class PhotoAlbumController {

  private View view;
  private Model model;

  public PhotoAlbumController() throws IOException {

    this.view = new PhotoAlbumView(1000, 1000, this);
    this.model = new PhotoAlbumModel();
  }

  public void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException {

    CommandReader reader = new CommandReader("src/assets/inputfiles/buildings.txt");
    ArrayList<String> commands = reader.read();

    int size = 800;
    String setupCommand = commands.get(0);
    if (setupCommand.startsWith("#") && setupCommand.contains("canvas")) {
      size = Integer.parseInt(setupCommand.split("\\s+")[4]);
    }
    for (String command : commands) {
      this.model.execute(CommandFactory.createCommand(command, this.model));
      if (command.split("\\s+")[0].equalsIgnoreCase("snapshot")) {
        this.view.updatePicture(this.model.getLastSnapshot(), size);
      }
    }

    this.view.setImage("snap-0", true);

    this.view.setVisible(true);
  }



  public static void main(String[] args) throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    PhotoAlbumController controller = new PhotoAlbumController();
    controller.start();

  }
}
