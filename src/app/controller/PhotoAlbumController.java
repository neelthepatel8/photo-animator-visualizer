package app.controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.controller.reader.CommandReader;
import app.controller.reader.ICommandReader;
import app.model.commands.CommandFactory;
import app.model.exceptions.IllegalShapeException;
import app.model.exceptions.InvalidCommandException;
import app.model.photoalbum.model.IModel;
import app.model.photoalbum.model.PhotoAlbumModel;
import app.model.photoalbum.snapshot.ISnapshot;
import app.view.graphical.IGraphicalView;
import app.view.graphical.GraphicalView;
import app.view.web.IWebView;
import app.view.web.WebView;

public class PhotoAlbumController implements IController{

  /** Fields **/
  private final String inputFile;

  /** MVC **/
  private IGraphicalView view;
  private IWebView webView;
  private final IModel model;

  public PhotoAlbumController(String inputFile, String outputFile, String viewType, String xmax, String ymax) throws IOException {

    int xMax = Integer.parseInt(xmax);
    int yMax = Integer.parseInt(ymax);
    this.inputFile = inputFile;

    if (viewType.equalsIgnoreCase("graphical"))
      this.view = new GraphicalView(xMax, yMax, this);

    if (viewType.equalsIgnoreCase("web"))
      this.webView = new WebView(xMax, yMax, outputFile);

    this.model = new PhotoAlbumModel();
  }

  @Override
  public void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException, InvalidCommandException {

    List<String> commands = this.parseCommands(inputFile);

    int size = this.findCanvasSize(commands.get(0));

    List<ISnapshot> snapshots = this.generateAllSnapshots();

    if (webView != null) {
      webView.setSnapshots(snapshots);
      webView.loadPage();
    }
    else if (view != null) {
      ISnapshot firstSnap = this.model.getNextSnapshot(true);
      this.view.initialize(firstSnap.getShapes(), firstSnap.getDescription(), firstSnap.getId(), size);
    }
  }

  @Override
  public List<ISnapshot> generateAllSnapshots() throws IOException, InvalidCommandException, IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    List<String> commands = this.parseCommands(inputFile);

    int size = this.findCanvasSize(commands.get(0));

    this.runCommands(commands, size);

    return this.model.getSnapshots();
  }

  @Override
  public boolean handleNext(MouseEvent e) {
    ISnapshot nextSnap = this.model.getNextSnapshot();
    if (nextSnap == null) return false;
    this.view.switchToNew(nextSnap.getShapes(), nextSnap.getDescription(), nextSnap.getId());
    return true;
  }

  @Override
  public boolean handlePrevious(MouseEvent e) {
    ISnapshot prevSnap = this.model.getPreviousSnapshot();
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
    ISnapshot found = this.model.getSnapshotFromID(id);
    if (found == null) return false;
    this.view.switchToNew(found.getShapes(), found.getDescription(), found.getId());
    return true;
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
          InvalidCommandException {

    for (String command : commands) {

      // Keep executing commands one after the other.
      this.model.execute(CommandFactory.createCommand(command, this.model));

    }
  }
}
