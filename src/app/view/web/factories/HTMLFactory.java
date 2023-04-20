package app.view.web.factories;

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
    return String.format("<html lang=''>\n");
  }

  public static String end() {
    return "</html>\n";
  }

  public static String generateTitle(String text) {
    return String.format("\t\t<title>%s</title>\n", text);
  }

  public static String linkStylesheet(String fileName) {
    return """
            <style>
            \t\t\t* {
            \t\t\t\tbackground-color: #FFFFF0;
            \t\t\t}
            \t\t\tbody {
            \t\t\t\twidth: 80%;
            \t\t\t\tmargin: auto;
            \t\t\t}
            \t\t\tbody {
            \t\t\t\ttext-align: center;
            \t\t\t\tfont-family: "American Typewriter";
            \t\t\t\tfont-weight: normal;
            \t\t\t}
            \t\t\th3 {
            \t\t\t\tfont-weight: normal;
            \t\t\t\tfont-size: 2rem;
            \t\t\t}
            \t\t\t.image {
            \t\t\t\tborder-bottom: 1px solid gray;
            \t\t\t\tpadding-bottom: 30px;
            \t\t\t}
            \t\t\tsvg {
            \t\t\t\tborder-radius: 12px;
            \t\t\t}

            \t\t\th2 {
            \t\t\t\tfont-weight: bold;
            \t\t\t\tfont-size: 3rem;
            \t\t\t}
            \t\t\th1 {
            \t\t\t\tpadding: 40px;
            \t\t\t\tfont-size: 8rem;
            \t\t\t}
            \t\t\tsvg {
            \t\t\t\tborder: 1px solid black;
            \t\t\t}
            \t\t</style>""";
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
