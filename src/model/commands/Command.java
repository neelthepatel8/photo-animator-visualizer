package model.commands;

import model.exceptions.IllegalShapeException;

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
