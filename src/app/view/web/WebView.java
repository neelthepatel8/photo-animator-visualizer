package app.view.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import app.model.photoalbum.snapshot.ISnapshot;
import app.model.shape.IShape;
import app.view.IView;
import app.view.web.factories.HTMLFactory;
import app.view.web.factories.SVGFactory;

public class WebView implements IWebView, IView {

  private List<ISnapshot> snapshots;
  private final int width;
  private final int height;
  private final String outputFile;

  public WebView(int width, int height, String outputFile) {
    this.width = width;
    this.height = height;
    this.outputFile = outputFile;
  }

  private void writeToFile(String html) throws IOException {

    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    writer.write(html);
    writer.close();

  }

  public String loadPage() throws IOException {
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

    return html.toString();
  }

  public String loadPageWithoutID() throws IOException {
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
            .append(this.generateSnapshotsWithoutID())
            .append(HTMLFactory.endDiv())
            .append(HTMLFactory.endBody())
            .append(HTMLFactory.end());
    this.writeToFile(html.toString());

    return html.toString();
  }

  @Override
  public void setSnapshots(List<ISnapshot> snapshots) {
    this.snapshots = snapshots;
  }


  private String generateSnapshots() {
    StringBuilder allSVGs = new StringBuilder();
    for (ISnapshot snapshot: snapshots) {
      allSVGs.append(HTMLFactory.generateDiv("image"));
      allSVGs.append(HTMLFactory.generateMediumHeading(snapshot.getDescription()));
      allSVGs.append(HTMLFactory.generateSmallHeading(snapshot.getId()));
      allSVGs.append(this.generateSVG(snapshot.getShapes(), this.width, this.height));
      allSVGs.append(HTMLFactory.endDiv());
    }
    return allSVGs.toString();
  }

  private String generateSnapshotsWithoutID() {
    StringBuilder allSVGs = new StringBuilder();
    for (ISnapshot snapshot: snapshots) {
      allSVGs.append(HTMLFactory.generateDiv("image"));
      allSVGs.append(HTMLFactory.generateMediumHeading(snapshot.getDescription()));
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
          break;
        case "oval":
          svg.append(SVGFactory.generateOval(
                  (int) shape.getX(),
                  (int) shape.getY(),
                  (int) shape.getRadiusX(),
                  (int) shape.getRadiusY(),
                  shape.getColor()
          ));
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    svg.append(SVGFactory.endSVG());
    return svg.toString();
  }

  @Override
  public String getViewType() {
    return "WEB";
  }
}
