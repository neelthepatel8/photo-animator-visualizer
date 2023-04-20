package app.view.components.labels;

public class ImageLabel extends Label{
  public ImageLabel(String normal, String hover) {
    super("src/assets/images/" + normal + ".png", "src/assets/images/" + hover + ".png");
  }
  public ImageLabel(String path) {
    super("src/assets/snapshots/" + path + ".png", true);
  }

  @Override
  public void setImage(String imageName) {
    super.setImage("src/assets/snapshots/" + imageName + ".png");
  }
}
