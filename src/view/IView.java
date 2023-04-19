package view;

import java.io.IOException;
import java.util.List;

import model.shape.IShape;

public interface IView {

  void switchToNew(String imageName, String description, String id);
  void close();
  void savePicture(List<IShape> shapes, int size) throws IOException;
}
