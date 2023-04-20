package app.model.commands;

import app.model.exceptions.IllegalShapeException;

/**
 * The interface Command.
 */
public interface Command {
  /**
   * Execute.
   *
   * @throws IllegalShapeException the illegal shape exception
   */
  void execute() throws IllegalShapeException, NoSuchFieldException, IllegalAccessException;
}
