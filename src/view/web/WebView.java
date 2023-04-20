package view.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML;

import model.photoalbum.snapshot.Snapshot;
import model.shape.IShape;

public class WebView implements IWebView {

  private List<Snapshot> snapshots;
  private final int width;
  private final int height;
  private String outputFile;

  public WebView(int widht, int height, String outputFile) {
    this.width = widht;
    this.height = height;
    this.outputFile = outputFile;
  }

  private void writeToFile(String html) throws IOException {

    BufferedWriter writer = new BufferedWriter(new FileWriter("src/view/web/" + outputFile + ".html"));
    writer.write(html);
    writer.close();

  }

  public void loadPage() throws IOException {
    StringBuilder html = new StringBuilder();
    html
            .append(HTMLFactory.start())
            .append(HTMLFactory.generateHead())
            .append(HTMLFactory.generateTitle("Photo Album"))
            .append(HTMLFactory.linkStylesheet("main.css"))
            .append(HTMLFactory.endHead())
            .append(HTMLFactory.generateBody())
            .append(HTMLFactory.generateLargeHeading("Photo Album"))
            .append(HTMLFactory.generateDiv("snapshots"))
            .append(this.generateSnapshots())
            .append(HTMLFactory.endDiv())
            .append(HTMLFactory.endBody())
            .append(HTMLFactory.end());
    this.writeToFile(html.toString());
  }

  @Override
  public void setSnapshots(List<Snapshot> snapshots) {
    this.snapshots = snapshots;
  }


  private String generateSnapshots() {
    StringBuilder allSVGs = new StringBuilder();
    for (Snapshot snapshot: snapshots) {
      allSVGs.append(HTMLFactory.generateDiv("image"));
      allSVGs.append(HTMLFactory.generateMediumHeading(snapshot.getDescription()));
      allSVGs.append(HTMLFactory.generateSmallHeading(snapshot.getId()));
      allSVGs.append(this.generateSVG(snapshot.getShapes(), this.width, this.height));
      allSVGs.append(HTMLFactory.endDiv());
    }
    return allSVGs.toString();
  }


  private String generateSVG(List<IShape> shapes, int width, int height) {
    StringBuilder svg = new StringBuilder();
    svg.append(SVGFactory.startSVG(width, height));

    for (IShape shape: shapes) {
      switch (shape.getType().toLowerCase()) {
        case "rectangle":
          svg.append(SVGFactory.generateRectangle(
                  (int) shape.getX(),
                  (int) shape.getY(),
                  (int) shape.getHeight(),
                  (int) shape.getWidth(),
                  shape.getColor()
          ));
        case "oval":
          svg.append(SVGFactory.generateOval(
                  (int) shape.getX(),
                  (int) shape.getY(),
                  (int) shape.getRadiusX(),
                  (int) shape.getRadiusY(),
                  shape.getColor()
          ));
      }
    }
    svg.append(SVGFactory.endSVG());
    return svg.toString();
  }

}
