package controller;

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

    CommandReader reader = new CommandReader("src/assets/inputfiles/demo_input.txt");
    ArrayList<String> commands = reader.read();

    for (String command : commands) {

      this.model.execute(CommandFactory.createCommand(command, this.model));
      if (command.split("\\s+")[0].equalsIgnoreCase("snapshot")) {
        System.out.println(command);
        this.view.updatePicture(this.model.getLastSnapshot());
      }
    }

    this.view.setVisible(true);
  }

  public static void main(String[] args) throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    PhotoAlbumController controller = new PhotoAlbumController();
    controller.start();

  }
}
