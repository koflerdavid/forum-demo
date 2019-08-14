package eu.koflerdavid.forum.core;

import eu.koflerdavid.forum.simple.Simple;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ForumThreadRepository<Impl> {
  Collection<ForumThread<Simple>> getAllForumThreads();

  default Optional<ForumThread<Impl>> getForumThreadById(ForumThreadId forumThreadId) {
    return getForumThreadById(forumThreadId.getUuid());
  }

  default Optional<ForumThread<Impl>> getForumThreadById(UUID forumThreadUuid) {
    return getForumThreadById(new ForumThreadId(forumThreadUuid));
  }

  void saveForumThread(ForumThread<Impl> forumThread);

  void saveChangesToForumThread(ForumThread<Impl> forumThread);
}
