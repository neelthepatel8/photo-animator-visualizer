package app.model.commands;

import app.util.Color;

import app.model.exceptions.InvalidCommandException;
import app.model.photoalbum.canvas.Canvas;
import app.model.photoalbum.model.IModel;
import app.model.photoalbum.canvas.ICanvas;

public class CommandFactory {

  public static Command createCommand(String commandString, IModel model) throws InvalidCommandException {

    ICanvas canvas = model.getCanvas();

    String[] commandParts = commandString.trim().split("\\s+");
    String commandType = commandParts[0];

    switch (commandType.toLowerCase()) {
      case "shape":
        String shapeName = commandParts[1];
        String shapeType = commandParts[2];
        String properties = commandString.replace(commandType, "").replace(" " + shapeType + " ", " ").trim();
        return new CreateShapeCommand(canvas, shapeType, properties);
      case "move":
        shapeName = commandParts[1];
        return new MoveCommand(Double.parseDouble(commandParts[2]), Double.parseDouble(commandParts[3]), shapeName);
      case "resize":
        shapeName = commandParts[1];
        shapeType = Canvas.findShape(shapeName).getType();
        switch(shapeType) {
          case "rectangle":
            return new ChangeRectangleSizeCommand(Double.parseDouble(commandParts[2]), Double.parseDouble(commandParts[3]), shapeName);
          case "circle":
            return new ChangeCircleSizeCommand(Double.parseDouble(commandParts[2]), shapeName);
          case "oval":
            return new ChangeOvalSizeCommand(Double.parseDouble(commandParts[2]), Double.parseDouble(commandParts[3]), shapeName);
        }
      case "color":
        shapeName = commandParts[1];

        return new ChangeColorCommand(new Color(
                Integer.parseInt(commandParts[2]),
                Integer.parseInt(commandParts[3]),
                Integer.parseInt(commandParts[4])), shapeName);
      case "remove":
        shapeName = commandParts[1];
        return new RemoveShapeCommand(shapeName, canvas);
      case "snapshot":
        String description = commandString.replace(commandType, "").trim();
        return new TakeShapshotCommand(description, model);
      case "history":
        return new ViewHistoryCommand(model);
      default:
        throw new InvalidCommandException("Invalid command");
    }
  }
}
