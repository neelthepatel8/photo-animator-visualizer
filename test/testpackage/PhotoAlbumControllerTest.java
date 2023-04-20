package testpackage;

import org.junit.Test;

import java.io.IOException;

import app.controller.IController;
import app.controller.PhotoAlbumController;
import app.model.exceptions.IllegalShapeException;
import app.model.exceptions.InvalidCommandException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PhotoAlbumControllerTest {

  @Test
  public void testConstructor() throws IOException {
    IController controller = new PhotoAlbumController("test.txt", "index", "web", "800", "800" );
    assertNotNull(controller);
  }

  @Test
  public void testStart() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException, InvalidCommandException, InvalidCommandException, IllegalShapeException {
    IController controller = new PhotoAlbumController("test.txt", "index", "web", "800", "800" );
    controller.start();
    assertEquals(1, 1);
  }

}