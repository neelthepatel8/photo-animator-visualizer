package model.commands;

import model.photoalbum.PhotoAlbum;

/**
 * The type View history command.
 */
public class ViewHistoryCommand implements Command {
  private final PhotoAlbum photoAlbum;

  /**
   * Instantiates a new View history command.
   *
   * @param photoAlbum the photo album
   */
  public ViewHistoryCommand(PhotoAlbum photoAlbum) {
    this.photoAlbum = photoAlbum;
  }

  @Override
  public void execute() {
    photoAlbum.history();
  }
}
