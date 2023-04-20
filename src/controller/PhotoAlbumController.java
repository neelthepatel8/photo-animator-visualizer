package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.reader.CommandReader;
import controller.reader.ICommandReader;
import model.commands.CommandFactory;
import model.exceptions.IllegalShapeException;
import model.exceptions.InvalidCommandException;
import model.photoalbum.model.IModel;
import model.photoalbum.model.PhotoAlbumModel;
import model.photoalbum.snapshot.Snapshot;
import view.graphical.IView;
import view.graphical.GraphicalView;
import view.web.IWebView;
import view.web.WebView;


public class PhotoAlbumController implements IController{

  private final IView view;
  private final IWebView webView;
  private final IModel model;

  public PhotoAlbumController() throws IOException {
    this.view = new GraphicalView(1000, 1000, this);
    this.model = new PhotoAlbumModel();
    this.webView = new WebView(800, 800, "index");
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

  private void runCommands(List<String> commands, int size)
          throws IllegalShapeException,
          NoSuchFieldException,
          IllegalAccessException,
          IOException, InvalidCommandException {

    for (String command : commands) {

      // Keep executing commands one after the other.
      this.model.execute(CommandFactory.createCommand(command, this.model));

    }
  }

  public void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException, InvalidCommandException {

    // Parse commands from the input file.
    List<String> commands = this.parseCommands("src/assets/inputfiles/buildings.txt");

    // If the file has a canvas size, get it.
    int size = this.findCanvasSize(commands.get(0));

    // Execute the commands from the file.
    this.runCommands(commands, size);

    webView.setSnapshots(this.model.getSnapshots());
    webView.loadPage();
//    Snapshot firstSnap = this.model.getNextSnapshot(true);
//    this.view.initialize(firstSnap.getShapes(), firstSnap.getDescription(), firstSnap.getId(), size);
  }

  @Override
  public boolean handleNext(MouseEvent e) {
    Snapshot nextSnap = this.model.getNextSnapshot();
    if (nextSnap == null) return false;
    this.view.switchToNew(nextSnap.getShapes(), nextSnap.getDescription(), nextSnap.getId());
    return true;
  }

  @Override
  public boolean handlePrevious(MouseEvent e) {
    Snapshot prevSnap = this.model.getPreviousSnapshot();
    if (prevSnap == null) return false;
    this.view.switchToNew(prevSnap.getShapes(), prevSnap.getDescription(), prevSnap.getId());
    return true;
  }

  @Override
  public void handleSelect(MouseEvent e) {
    List<String> snapshotIDs = new ArrayList<>();
    this
            .model
            .getSnapshots()
            .stream()
            .forEach(
                    snapshot ->
                    {
                      snapshotIDs
                              .add(snapshot
                                      .getId()
                              );
                    }
            );

    this.view.displaySnapshotList(snapshotIDs, e);
  }

  @Override
  public void handleClose(MouseEvent e) {
    this.view.close();
  }

  @Override
  public boolean handleSnapshotSelection(String id) {
    Snapshot found = this.model.getSnapshotFromID(id);
    if (found == null) return false;
    this.view.switchToNew(found.getShapes(), found.getDescription(), found.getId());
    return true;
  }

  public static void main(String[] args) throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException, InvalidCommandException {
    IController controller = new PhotoAlbumController();
    controller.start();
  }
}
