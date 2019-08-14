package eu.koflerdavid.forum.core;

import java.time.Instant;

public interface ForumPost<Impl> {

  ForumPostId getForumPostId();

  HasAuthorInformation getAuthorInformation();

  ForumThreadId getIdOfContainingForumThread();

  String getContent();

  Instant getInstantWhenPosted();

}
