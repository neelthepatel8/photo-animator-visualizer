package model.photoalbum;

import java.util.HashMap;

import model.commands.Command;
import model.exceptions.IllegalShapeException;
import model.photoalbum.snapshot.Snapshot;

/**
 * The type Photo album.
 */
public class PhotoAlbum {

  private final Canvas canvas;
  private final HashMap<Snapshot, String> snapshots;

  /**
   * Instantiates a new Photo album.
   */
  public PhotoAlbum() {
    this.canvas = new Canvas();
    this.snapshots = new HashMap<Snapshot, String>();
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
    canvas.execute(command);
  }

  /**
   * Snap.
   *
   * @param description the description
   */
  public void snap(String description) {
    Snapshot snapshot = new Snapshot(description, canvas);
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
  public Canvas getCanvas() {
    return canvas;
  }

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  public HashMap<Snapshot, String> getSnapshots() {
    return snapshots;
  }
}
