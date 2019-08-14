package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.AuthorId;
import eu.koflerdavid.forum.core.HasAuthorInformation;

public class SimpleAuthor implements HasAuthorInformation {

  private AuthorId authorId;

  private String displayName;

  @Override
  public AuthorId getAuthorId() {
    return authorId;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }
}
