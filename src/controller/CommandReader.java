package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandReader implements ICommandReader {

  private String path;

  public CommandReader(String path) {
    this.path = path;
  }

  public List<String> read() throws IOException {

    List<String> commands = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(path));

    String line;
    while ((line = reader.readLine()) != null) {

      // If line is empty or a comment, ignore it.
      if (line.startsWith("#") || line.isEmpty())
        continue;

      commands.add(line.strip());
    }

    return commands;

  }
}
