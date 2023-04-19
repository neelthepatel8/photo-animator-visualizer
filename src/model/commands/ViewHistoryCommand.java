package model.commands;

import model.photoalbum.Model;
import model.photoalbum.PhotoAlbumModel;

/**
 * The type View history command.
 */
public class ViewHistoryCommand implements Command {
  private final Model photoAlbumModel;

  /**
   * Instantiates a new View history command.
   *
   * @param photoAlbumModel the photo album
   */
  public ViewHistoryCommand(Model photoAlbumModel) {
    this.photoAlbumModel = photoAlbumModel;
  }

  @Override
  public void execute() {
    photoAlbumModel.history();
  }
}
