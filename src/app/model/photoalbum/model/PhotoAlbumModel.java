package app.model.photoalbum.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import app.model.commands.Command;
import app.model.exceptions.IllegalShapeException;
import app.model.photoalbum.canvas.Canvas;
import app.model.photoalbum.canvas.ICanvas;
import app.model.photoalbum.snapshot.ISnapshot;
import app.model.photoalbum.snapshot.Snapshot;
import app.model.shape.IShape;

/**
 * The type Photo album.
 */
public class PhotoAlbumModel implements IModel {

  private final ICanvas canvas;
  private final LinkedHashMap<ISnapshot, String> snapshots;
  private final ArrayList<ISnapshot> snapshotTrackerList;
  private int currentISnapshot = 0;

  /**
   * Instantiates a new Photo album.
   */
  public PhotoAlbumModel() {
    this.canvas = new Canvas();
    this.snapshots = new LinkedHashMap<>();
    this.snapshotTrackerList = new ArrayList<>();
  }

  /**
   * Execute.
   *
   * @param command the command
   * @throws IllegalShapeException  the illegal shape exception
   * @throws NoSuchFieldException   the no such field exception
   * @throws IllegalAccessException the illegal access exception
   */
  public void execute(Command command) throws IllegalShapeException, NoSuchFieldException, IllegalAccessException {
    command.execute();
  }

  /**
   * Snap.
   *
   * @param description the description
   */
  public void snap(String description) {
    List<IShape> snapshotShapes = new ArrayList<>(canvas.getShapes());
    ISnapshot snapshot = new Snapshot(description, canvas, snapshotShapes);
    snapshot.snap(canvas, description);
    snapshots.put(snapshot, snapshot.toString());
    snapshotTrackerList.add(snapshot);
  }

  /**
   * History.
   */
  public void history() {
    for (ISnapshot snapshot : snapshots.keySet()) {
      System.out.println(snapshots.get(snapshot));
    }
  }

  @Override
  public ISnapshot getNextSnapshot() {
    if (currentISnapshot + 1 >= snapshotTrackerList.size()) {
      return null;
    }
    currentISnapshot += 1;
    return snapshotTrackerList.get(currentISnapshot);
  }

  @Override
  public ISnapshot getNextSnapshot(boolean first) {
    if (currentISnapshot + 1 >= snapshotTrackerList.size() && snapshotTrackerList.size() != 1) {
      return null;
    }
    return snapshotTrackerList.get(0);
  }

  @Override
  public ISnapshot getPreviousSnapshot() {
    if (currentISnapshot - 1 < 0) {
      return null;
    }
    currentISnapshot -= 1;
    return snapshotTrackerList.get(currentISnapshot);
  }

  @Override
  public ISnapshot getSnapshotFromID(String id) {
    for (ISnapshot snapshot: snapshots.keySet()) {
      if (snapshot.getId().equalsIgnoreCase(id)) {
        currentISnapshot = snapshotTrackerList.indexOf(snapshot);
        return snapshot;
      }
    }
    return null;
  }

  @Override
  public List<ISnapshot> getSnapshots() {
    return this.snapshotTrackerList;
  }


  /**
   * Gets canvas.
   *
   * @return the canvas
   */
  public ICanvas getCanvas() {
    return canvas;
  }


}
