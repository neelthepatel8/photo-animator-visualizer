package controller;

import java.io.IOException;

import model.exceptions.IllegalShapeException;

public interface IController {
  void start() throws IOException, IllegalShapeException, NoSuchFieldException, IllegalAccessException ;
}
