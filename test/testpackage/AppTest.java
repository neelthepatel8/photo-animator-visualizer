package testpackage;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import app.PhotoAlbumMain;
import app.model.exceptions.IllegalShapeException;
import app.model.exceptions.InvalidCommandException;

public class AppTest {

  @Test (expected = FileNotFoundException.class)
  public void testCommandLineArgs() throws InvalidCommandException, IllegalShapeException, IOException, NoSuchFieldException, IllegalAccessException {
    String[] args = "-in buildings.txt -out index2.html -view web 800 800".split("\\s+");
    PhotoAlbumMain.main(args);
  }

  @Test (expected = FileNotFoundException.class)
  public void testIncorrectFile() throws InvalidCommandException, IllegalShapeException, IOException, NoSuchFieldException, IllegalAccessException {
    String[] args = "-in blahhhhh.txt -view jbka -out index2.html 800 800".split("\\s+");
    PhotoAlbumMain.main(args);
  }

  @Test
  public void testCommandLineArgsEmpty() throws InvalidCommandException, IllegalShapeException, IOException, NoSuchFieldException, IllegalAccessException {
    String[] args = "  ".split("\\s+");
    PhotoAlbumMain.main(args);
  }
}
