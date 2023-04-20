package app.cli;

public class CLI {
    public static void help() {
      System.out.println("Usage: -in \"name-of-command-file\" -view \"type-of-view\" [-out \"where-output-should-go\"] [xmax] [ymax] \n");
    }

    public static void insufficient() {
      System.out.println("Insufficient Arguments. Please try again!");
    }

    public static String[] process(String[] args) {

      // Setup defaults
      String inputFile = null;
      String outputFile = "index.html";
      String viewType = null;
      String xmax = "1000";
      String ymax = "1000";

      for (int i = 0; i < args.length; i++) {
        switch (args[i].toLowerCase()) {
          case "-in":
            inputFile = args[i + 1];
            break;
          case "-view":
            viewType = args[i + 1];
            break;
          case "-v":
            viewType = args[i + 1];
            break;
          case "-out":
            outputFile = args[i + 1];
            break;
        }
      }

      xmax = getNumber(args[args.length - 2], xmax);
      ymax = getNumber(args[args.length - 1], ymax);

      if (inputFile == null) {
        System.out.println("Please specify an input file!");
        return null;
      }

      if (viewType == null) {
        System.out.println("Please specify a view type!");
        return null;
      }

      return new String[]{inputFile, outputFile, viewType, xmax, ymax};
    }

    private static String getNumber(String maybe, String fallback) {
      if (maybe.matches("\\d+")) {
        return maybe;
      }
      return fallback;
    }
}
