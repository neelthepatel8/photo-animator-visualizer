package app;

import java.io.IOException;

import app.cli.CLI;
import app.controller.IController;
import app.controller.PhotoAlbumController;
import app.model.exceptions.IllegalShapeException;
import app.model.exceptions.InvalidCommandException;

public class PhotoAlbumMain {

  public static void main(String[] args)
          throws
          IOException,
          IllegalShapeException,
          NoSuchFieldException,
          IllegalAccessException,
          InvalidCommandException
  {

    if (args.length < 4) {
      CLI.insufficient();
      CLI.help();
      return;
    }

    String[] processedArgs = CLI.process(args);
    if (processedArgs == null) return;

    IController controller = new PhotoAlbumController(
            processedArgs[0],
            processedArgs[1],
            processedArgs[2],
            processedArgs[3],
            processedArgs[4]
            );
    controller.start();
  }
}
