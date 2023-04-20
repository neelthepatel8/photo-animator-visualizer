package app.view.components.labels;

public class ImageLabel extends Label{
  public ImageLabel(String normal, String hover) {
    super("src/resources.assets/images/" + normal + ".png", "src/resources.assets/images/" + hover + ".png");
  }
  public ImageLabel(String path) {
    super("src/resources.assets/snapshots/" + path + ".png", true);
  }

  @Override
  public void setImage(String imageName) {
    super.setImage("src/resources.assets/snapshots/" + imageName + ".png");
  }
}
