package model.photoalbum.snapshot;

import java.sql.Timestamp;

import model.photoalbum.Canvas;

/**
 * The type Snapshot.
 */
public class Snapshot {

  private Timestamp timestamp;
  private String id;
  private String description;
  private Canvas canvas;

  /**
   * Instantiates a new Snapshot.
   *
   * @param description the description
   * @param canvas      the canvas
   */
  public Snapshot(String description, Canvas canvas) {
    this.description = description;
    this.canvas = canvas;
  }

  /**
   * Snap.
   *
   * @param canvas      the canvas
   * @param description the description
   */
  public void snap(Canvas canvas, String description) {
    this.timestamp = new Timestamp(System.currentTimeMillis());
    this.id = timestamp.toString() + "." + (int) (Math.random() * 25000);
    this.description = description;
    this.canvas = canvas;
  }

  @Override
  public String toString() {

    return "Snapshot ID: " + id + "\n" +
            "Timestamp: " + timestamp + "\n" +
            "Description: " + description + "\n" +
            canvas.toString();
  }
}
