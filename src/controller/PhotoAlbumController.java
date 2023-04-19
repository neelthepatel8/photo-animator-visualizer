package controller;

import java.io.IOException;
import java.util.List;

import controller.reader.CommandReader;
import controller.reader.ICommandReader;
import model.commands.CommandFactory;
import model.exceptions.IllegalShapeException;
import model.photoalbum.IModel;
import model.photoalbum.PhotoAlbumModel;
import view.IView;
import view.PhotoAlbumView;


public class PhotoAlbumController implements IController{

  private final IView view;
  private final IModel model;

  public PhotoAlbumController() throws IOException {
    this.view = new PhotoAlbumView(1000, 1000, this);
    this.model = new PhotoAlbumModel();
  }

  private List<String> parseCommands(String fileName) throws IOException {
    ICommandReader reader = new CommandReader(fileName);
    return reader.read();
  }

  private int findCanvasSize(String command) {
    int size = 800;
    if (command.startsWith("#") && command.contains("canvas")) {
      size = Integer.parseInt(command.split("\\s+")[4]);
    }
    return size;
  }

  private void runCommands(List<String> commands, int size) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException, IOException {

    for (String command : commands) {

      // Keep executing commands one after the other.
      this.model.execute(CommandFactory.createCommand(command, this.model));

      // Update picture everytime there is a snapshot.
      if (command.split("\\s+")[0].equalsIgnoreCase("snapshot")) {
        this.view.updatePicture(this.model.getLastSnapshot(), size);
      }
    }
  }

  public void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException {

    // Parse commands from the input file.
    List<String> commands = this.parseCommands("src/assets/inputfiles/buildings.txt");

    // If the file has a canvas size, get it.
    int size = this.findCanvasSize(commands.get(0));

    // Execute the commands from the file.
    this.runCommands(commands, size);

    // Set the first image and description.
    this.view.setInitials();

  }

  public static void main(String[] args) throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    IController controller = new PhotoAlbumController();
    controller.start();
  }
}
