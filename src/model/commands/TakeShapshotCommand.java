package model.commands;

import model.photoalbum.PhotoAlbum;

/**
 * The type Take shapshot command.
 */
public class TakeShapshotCommand implements Command {
  private final String description;
  private final PhotoAlbum photoAlbum;

  /**
   * Instantiates a new Take shapshot command.
   *
   * @param description the description
   * @param photoAlbum  the photo album
   */
  public TakeShapshotCommand(String description, PhotoAlbum photoAlbum) {
    this.description = description;
    this.photoAlbum = photoAlbum;
  }

  @Override
  public void execute() {
    photoAlbum.snap(description);
  }
}
