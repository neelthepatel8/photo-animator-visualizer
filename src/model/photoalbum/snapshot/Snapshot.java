package model.photoalbum.snapshot;

import java.sql.Timestamp;
import java.util.List;

import model.photoalbum.Canvas;
import model.shape.Shape;

/**
 * The type Snapshot.
 */
public class Snapshot {

  private Timestamp timestamp;
  private String id;
  private String description;
  private Canvas canvas;
  private List<Shape> shapes;

  /**
   * Instantiates a new Snapshot.
   *
   * @param description the description
   * @param canvas      the canvas
   */
  public Snapshot(String description, Canvas canvas, List<Shape> shapes) {
    this.description = description;
    this.canvas = canvas;
    this.shapes = shapes;
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

  public List<Shape> getShapes() {
    return shapes;
  }
}
