package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommandReader {

  private String path;

  public CommandReader(String path) {
    this.path = path;
  }

  public ArrayList<String> read() throws IOException {

    ArrayList<String> commands = new ArrayList<String>();

    BufferedReader reader = new BufferedReader(new FileReader(path));
    String line = null;

    while ((line = reader.readLine()) != null) {
      if (line.startsWith("#") || line.isEmpty())
        continue;
      commands.add(line.strip());
    }
    return commands;

  }

  public static void main(String[] args) {
    try {
      CommandReader reader = new CommandReader("src/assets/inputfiles/demo_input.txt");
      ArrayList<String> commands = reader.read();
        System.out.println(commands);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
