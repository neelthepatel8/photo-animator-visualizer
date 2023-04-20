package view.web;

public class HTMLFactory {

  public static String generateDiv(String className) {
    return String.format("\t<div class='%s'>\n", className);
  }

  public static String generateDiv() {
    return String.format("\t<div>\n");
  }

  public static String endDiv() {
    return "\t</div>\n";
  }

  public static String generateBody() {
    return String.format("\t<body>\n");
  }

  public static String endBody() {
    return "\t</body>\n";
  }

  public static String generateHead() {
    return String.format("\t<head>\n");
  }

  public static String endHead() {
    return "\t</head>\n";
  }
  public static String start() {
    return String.format("<html>\n");
  }

  public static String end() {
    return "</html>\n";
  }

  public static String generateTitle(String text) {
    return String.format("\t\t<title>%s</title>\n", text);
  }

  public static String linkStylesheet(String fileName) {
    return String.format("\t\t<link rel='stylesheet' href='%s' />\n", fileName);
  }

  public static String generateLargeHeading(String text) {
    return String.format("\t\t\t<h1>%s</h1>\n", text);
  }

  public static String generateMediumHeading(String text) {
    return String.format("\t\t\t<h2>%s</h2>\n", text);
  }

  public static String generateSmallHeading(String text) {
    return String.format("\t\t\t<h3>%s</h3>\n", text);
  }
}
