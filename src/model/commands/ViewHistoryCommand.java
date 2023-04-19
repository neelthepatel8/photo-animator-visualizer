package model.commands;

import model.photoalbum.model.IModel;

/**
 * The type View history command.
 */
public class ViewHistoryCommand implements Command {
  private final IModel photoAlbumIModel;

  /**
   * Instantiates a new View history command.
   *
   * @param photoAlbumIModel the photo album
   */
  public ViewHistoryCommand(IModel photoAlbumIModel) {
    this.photoAlbumIModel = photoAlbumIModel;
  }

  @Override
  public void execute() {
    photoAlbumIModel.history();
  }
}
