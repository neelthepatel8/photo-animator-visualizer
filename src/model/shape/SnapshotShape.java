package model.shape;

public class SnapshotShape extends Shape {
  private int num;
  public SnapshotShape(int num) {
    this.num = num;
  }

  public int getNum() {
    return num;
  }

  @Override
  public String toString() {
    return "SnapshotShape{" +
            "num=" + num +
            '}';
  }
}
