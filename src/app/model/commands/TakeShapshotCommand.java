package app.model.commands;

import app.model.photoalbum.model.IModel;

/**
 * The type Take shapshot command.
 */
public class TakeShapshotCommand implements Command {
  private final String description;
  private final IModel photoAlbumIModel;

  /**
   * Instantiates a new Take shapshot command.
   *
   * @param description the description
   * @param photoAlbumIModel  the photo album
   */
  public TakeShapshotCommand(String description, IModel photoAlbumIModel) {
    this.description = description;
    this.photoAlbumIModel = photoAlbumIModel;
  }

  @Override
  public void execute() {
    photoAlbumIModel.snap(description);
  }
}
