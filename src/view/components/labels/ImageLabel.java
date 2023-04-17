package view.components.labels;

public class ImageLabel extends Label{
  public ImageLabel(String normal, String hover) {
    super("src/assets/images/" + normal + ".png", "src/assets/images/" + hover + ".png");
  }
}
