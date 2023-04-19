package model.commands;

import model.photoalbum.Model;
import model.photoalbum.PhotoAlbumModel;

/**
 * The type Take shapshot command.
 */
public class TakeShapshotCommand implements Command {
  private final String description;
  private final Model photoAlbumModel;

  /**
   * Instantiates a new Take shapshot command.
   *
   * @param description the description
   * @param photoAlbumModel  the photo album
   */
  public TakeShapshotCommand(String description, Model photoAlbumModel) {
    this.description = description;
    this.photoAlbumModel = photoAlbumModel;
  }

  @Override
  public void execute() {
    photoAlbumModel.snap(description);
  }
}
