package model.photoalbum;

import java.util.LinkedHashMap;
import java.util.Map;

import model.commands.Command;
import model.exceptions.IllegalShapeException;
import model.photoalbum.snapshot.ICanvas;
import model.photoalbum.snapshot.Snapshot;

/**
 * The type Photo album.
 */
public class PhotoAlbumModel implements IModel {

  private final ICanvas canvas;
  private final LinkedHashMap<Snapshot, String> snapshots;

  /**
   * Instantiates a new Photo album.
   */
  public PhotoAlbumModel() {
    this.canvas = new Canvas();
    this.snapshots = new LinkedHashMap<>();
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
    Snapshot snapshot = new Snapshot(description, canvas, canvas.getShapes());
    snapshot.snap(canvas, description);
    snapshots.put(snapshot, snapshot.toString());
  }

  /**
   * History.
   */
  public void history() {
    for (Snapshot snapshot : snapshots.keySet()) {
      System.out.println(snapshots.get(snapshot));
    }
  }

  /**
   * Gets canvas.
   *
   * @return the canvas
   */
  public ICanvas getCanvas() {
    return canvas;
  }

  public Snapshot getLastSnapshot() {
    Map.Entry<Snapshot, String> lastSnap = snapshots
            .entrySet()
            .stream()
            .reduce((first, second) -> second)
            .orElse(null);

    return lastSnap.getKey();
  }
}
