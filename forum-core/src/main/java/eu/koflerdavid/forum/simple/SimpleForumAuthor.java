package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.AuthorId;
import eu.koflerdavid.forum.core.ForumAuthor;

import java.util.UUID;

public class SimpleForumAuthor implements ForumAuthor<Simple> {
  private AuthorId authorId;

  private String displayName;

  public SimpleForumAuthor(UUID authorId, String displayName) {
    this.authorId = new AuthorId(authorId);
    this.displayName = displayName;
  }

  @Override
  public AuthorId getAuthorId() {
    return authorId;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }
}
