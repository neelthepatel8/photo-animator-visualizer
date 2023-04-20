package app.view.web;

import java.io.IOException;
import java.util.List;

import app.model.photoalbum.snapshot.ISnapshot;

public interface IWebView {
  String loadPage() throws IOException;
  String loadPageWithoutID() throws IOException;
  void setSnapshots(List<ISnapshot> snapshots);
}
