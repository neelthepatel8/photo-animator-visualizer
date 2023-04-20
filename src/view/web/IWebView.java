package view.web;

import java.io.IOException;
import java.util.List;

import model.photoalbum.snapshot.Snapshot;

public interface IWebView {
  void loadPage() throws IOException;
  void setSnapshots(List<Snapshot> snapshots);
}
