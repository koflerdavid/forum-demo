package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.*;

import java.time.Instant;

public class SimpleForumPost implements ForumPost<Simple> {

  private ForumPostId forumPostId;

  private ForumAuthor<Simple> author;

  private final String content;

  private Instant whenPosted;

  SimpleForumPost(ForumPostId forumPostId, ForumAuthor<Simple> author, String content) {
    this.forumPostId = forumPostId;
    this.author = author;
    this.content = content;
    this.whenPosted = Instant.now();
  }

  @Override
  public ForumPostId getForumPostId() {
    return forumPostId;
  }

  @Override
  public HasAuthorInformation getAuthorInformation() {
    return author;
  }

  @Override
  public ForumThreadId getIdOfContainingForumThread() {
    return null;
  }

  @Override
  public String getContent() {
    return content;
  }

  @Override
  public Instant getInstantWhenPosted() {
    return whenPosted;
  }

}
