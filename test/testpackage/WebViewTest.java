package testpackage;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import app.util.Color;
import app.controller.IController;
import app.controller.PhotoAlbumController;
import app.model.exceptions.IllegalShapeException;
import app.model.exceptions.InvalidCommandException;
import app.view.web.IWebView;
import app.view.web.WebView;
import app.view.web.factories.HTMLFactory;
import app.view.web.factories.SVGFactory;

import static org.junit.Assert.*;

public class WebViewTest {

  private IWebView view;
  private IController controller;

  @Before
  public void setUp() throws Exception {

    controller = new PhotoAlbumController("src/resources/buildings.txt", "index", "web", "800", "800" );
    view = new WebView(800, 800, "test-output.html");

  }

  @Test
  public void testCorrectHTMLView() throws InvalidCommandException, IllegalShapeException, IOException, NoSuchFieldException, IllegalAccessException {
    view.setSnapshots(controller.generateAllSnapshots());
    String generatedHTML = view.loadPageWithoutID();
    System.out.println(generatedHTML);
    assertTrue(("<html lang=''>\n" +
            "\t<head>\n" +
            "\t\t<title>Photo Album</title>\n" +
            "<style>\n" +
            "\t\t\t* {\n" +
            "\t\t\t\tbackground-color: #FFFFF0;\n" +
            "\t\t\t}\n" +
            "\t\t\tbody {\n" +
            "\t\t\t\twidth: 80%;\n" +
            "\t\t\t\tmargin: auto;\n" +
            "\t\t\t}\n" +
            "\t\t\tbody {\n" +
            "\t\t\t\ttext-align: center;\n" +
            "\t\t\t\tfont-family: \"American Typewriter\";\n" +
            "\t\t\t\tfont-weight: normal;\n" +
            "\t\t\t}\n" +
            "\t\t\th3 {\n" +
            "\t\t\t\tfont-weight: normal;\n" +
            "\t\t\t\tfont-size: 2rem;\n" +
            "\t\t\t}\n" +
            "\t\t\t.image {\n" +
            "\t\t\t\tborder-bottom: 1px solid gray;\n" +
            "\t\t\t\tpadding-bottom: 30px;\n" +
            "\t\t\t}\n" +
            "\t\t\tsvg {\n" +
            "\t\t\t\tborder-radius: 12px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\th2 {\n" +
            "\t\t\t\tfont-weight: bold;\n" +
            "\t\t\t\tfont-size: 3rem;\n" +
            "\t\t\t}\n" +
            "\t\t\th1 {\n" +
            "\t\t\t\tpadding: 40px;\n" +
            "\t\t\t\tfont-size: 8rem;\n" +
            "\t\t\t}\n" +
            "\t\t\tsvg {\n" +
            "\t\t\t\tborder: 1px solid black;\n" +
            "\t\t\t}\n" +
            "\t\t</style>\t</head>\n" +
            "\t<body>\n" +
            "\t\t\t<h1>Photo Album</h1>\n" +
            "\t<div class='snapshots'>\n" +
            "\t<div class='image'>\n" +
            "\t\t\t<h2></h2>\n" +
            "\t\t<svg width='800' height='800'>\n" +
            "\t\t\t<rect x='0' y='0' width='800' height='800' fill='#215ef8'/>\n" +
            "\t\t\t<rect x='80' y='424' width='100' height='326' fill='#000000'/>\n" +
            "\t\t\t<rect x='260' y='365' width='100' height='385' fill='#000000'/>\n" +
            "\t\t\t<rect x='440' y='375' width='100' height='375' fill='#000000'/>\n" +
            "\t\t\t<rect x='620' y='445' width='100' height='305' fill='#000000'/>\n" +
            "\t\t\t<rect x='100' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='100' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\t<div class='image'>\n" +
            "\t\t\t<h2></h2>\n" +
            "\t\t<svg width='800' height='800'>\n" +
            "\t\t\t<rect x='0' y='0' width='800' height='800' fill='#215ef8'/>\n" +
            "\t\t\t<rect x='80' y='424' width='100' height='326' fill='#000000'/>\n" +
            "\t\t\t<rect x='260' y='365' width='100' height='385' fill='#000000'/>\n" +
            "\t\t\t<rect x='440' y='375' width='100' height='375' fill='#000000'/>\n" +
            "\t\t\t<rect x='620' y='445' width='100' height='305' fill='#000000'/>\n" +
            "\t\t\t<rect x='100' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='100' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\t<div class='image'>\n" +
            "\t\t\t<h2>Turn on the Lights!</h2>\n" +
            "\t\t<svg width='800' height='800'>\n" +
            "\t\t\t<rect x='0' y='0' width='800' height='800' fill='#215ef8'/>\n" +
            "\t\t\t<rect x='80' y='424' width='100' height='326' fill='#000000'/>\n" +
            "\t\t\t<rect x='260' y='365' width='100' height='385' fill='#000000'/>\n" +
            "\t\t\t<rect x='440' y='375' width='100' height='375' fill='#000000'/>\n" +
            "\t\t\t<rect x='620' y='445' width='100' height='305' fill='#000000'/>\n" +
            "\t\t\t<rect x='100' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='100' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='460' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='500' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='460' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='500' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='640' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='680' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='640' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='680' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<ellipse cx='200' cy='200' rx='100' ry='100' fill='#e5e5ff'/>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\t</div>\n" +
            "\t</body>\n" +
            "</html>\n").equalsIgnoreCase(generatedHTML));

  }

  @Test
  public void testPartiallyCorrectHTMLView() throws InvalidCommandException, IllegalShapeException, IOException, NoSuchFieldException, IllegalAccessException {
    view.setSnapshots(controller.generateAllSnapshots());
    String generatedHTML = view.loadPageWithoutID();
    System.out.println(generatedHTML);
    assertTrue(("<html lang=''>\n" +
            "\t<head>\n" +
            "\t\t<title>Photo Album</title>\n" +
            "<style>\n" +
            "\t\t\t* {\n" +
            "\t\t\t\tbackground-color: #FFFFF0;\n" +
            "\t\t\t}\n" +
            "\t\t\tbody {\n" +
            "\t\t\t\twidth: 80%;\n" +
            "\t\t\t\tmargin: auto;\n" +
            "\t\t\t}\n" +
            "\t\t\tbody {\n" +
            "\t\t\t\ttext-align: center;\n" +
            "\t\t\t\tfont-family: \"American Typewriter\";\n" +
            "\t\t\t\tfont-weight: normal;\n" +
            "\t\t\t}\n" +
            "\t\t\th3 {\n" +
            "\t\t\t\tfont-weight: normal;\n" +
            "\t\t\t\tfont-size: 2rem;\n" +
            "\t\t\t}\n" +
            "\t\t\t.image {\n" +
            "\t\t\t\tborder-bottom: 1px solid gray;\n" +
            "\t\t\t\tpadding-bottom: 30px;\n" +
            "\t\t\t}\n" +
            "\t\t\tsvg {\n" +
            "\t\t\t\tborder-radius: 12px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\th2 {\n" +
            "\t\t\t\tfont-weight: bold;\n" +
            "\t\t\t\tfont-size: 3rem;\n" +
            "\t\t\t}\n" +
            "\t\t\th1 {\n" +
            "\t\t\t\tpadding: 40px;\n" +
            "\t\t\t\tfont-size: 8rem;\n" +
            "\t\t\t}\n" +
            "\t\t\tsvg {\n" +
            "\t\t\t\tborder: 1px solid black;\n" +
            "\t\t\t}\n" +
            "\t\t</style>\t</head>\n" +
            "\t<body>\n" +
            "\t\t\t<h1>Photo Album</h1>\n" +
            "\t<div class='snapshots'>\n" +
            "\t<div class='image'>\n" +
            "\t\t\t<h2></h2>\n" +
            "\t\t<svg width='800' height='800'>\n" +
            "\t\t\t<rect x='0' y='0' width='800' height='800' fill='#215ef8'/>\n" +
            "\t\t\t<rect x='80' y='424' width='100' height='326' fill='#000000'/>\n" +
            "\t\t\t<rect x='260' y='365' width='100' height='385' fill='#000000'/>\n" +
            "\t\t\t<rect x='440' y='375' width='100' height='375' fill='#000000'/>\n" +
            "\t\t\t<rect x='620' y='445' width='100' height='305' fill='#000000'/>\n" +
            "\t\t\t<rect x='100' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='100' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\t<div class='image'>\n" +
            "\t\t\t<h2></h2>\n" +
            "\t\t<svg width='800' height='800'>\n" +
            "\t\t\t<rect x='0' y='0' width='800' height='800' fill='#215ef8'/>\n" +
            "\t\t\t<rect x='80' y='424' width='100' height='326' fill='#000000'/>\n" +
            "\t\t\t<rect x='260' y='365' width='100' height='385' fill='#000000'/>\n" +
            "\t\t\t<rect x='440' y='375' width='100' height='375' fill='#000000'/>\n" +
            "\t\t\t<rect x='620' y='445' width='100' height='305' fill='#000000'/>\n" +
            "\t\t\t<rect x='100' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='100' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\t<div class='image'>\n" +
            "\t\t\t<h2>Turn on the Lights!</h2>\n" +
            "\t\t<svg width='800' height='800'>\n" +
            "\t\t\t<rect x='0' y='0' width='800' height='800' fill='#215ef8'/>\n" +
            "\t\t\t<rect x='80' y='424' width='100' height='326' fill='#000000'/>\n" +
            "\t\t\t<rect x='260' y='365' width='100' height='385' fill='#000000'/>\n" +
            "\t\t\t<rect x='440' y='375' width='100' height='375' fill='#000000'/>\n" +
            "\t\t\t<rect x='620' y='445' width='100' height='305' fill='#000000'/>\n" +
            "\t\t\t<rect x='100' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='100' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='140' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='280' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='320' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='460' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='500' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='460' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='500' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='640' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='680' y='500' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='640' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<rect x='680' y='600' width='20' height='20' fill='#ffffff'/>\n" +
            "\t\t\t<ellipse cx='200' cy='200' rx='100' ry='100' fill='#e5e5ff'/>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\t</div>\n" +
            "\t</body>\n" +
            "</html>\n").equalsIgnoreCase(generatedHTML));

  }

  @Test
  public void testCorrectHTMLFactory() {
    assertTrue(HTMLFactory.generateDiv("test").trim().equalsIgnoreCase("\t<div class='test'>".trim()));
    assertTrue(HTMLFactory.endDiv().trim().equalsIgnoreCase("</div>".trim()));
    assertTrue(HTMLFactory.generateTitle("Title").trim().equalsIgnoreCase("\t<title>Title</title>".trim()));}

  @Test
  public void testCorrectSVGFactory() {
    assertTrue(SVGFactory.startSVG(800, 800).trim().equalsIgnoreCase("<svg width='800' height='800'>".trim()));
    assertTrue(SVGFactory.endSVG().trim().equalsIgnoreCase("</svg>".trim()));
    assertTrue(SVGFactory.generateRectangle(0, 0, 800, 800, new Color(255, 0, 0)).trim().equalsIgnoreCase("<rect x='0' y='0' width='800' height='800' fill='#ff0000'/>".trim()));
  }

}