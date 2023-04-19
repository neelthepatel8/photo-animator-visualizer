package controller;

import java.io.IOException;
import java.util.List;

public interface ICommandReader {
  List<String> read() throws IOException;
}
