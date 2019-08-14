package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.*;
import org.jetbrains.annotations.Contract;

import java.util.*;

public class SimpleForumThreadRepository implements ForumThreadFactory<Simple>, ForumThreadRepository<Simple> {

  private Map<UUID, ForumThread<Simple>> allForumThreads = new HashMap<>();

  @Override
  public SimpleForumThread newForumThread(String threadTitle, ForumAuthor<Simple> forumOpener, String textOfFirstPost) {
    ForumThreadId forumThreadId = new ForumThreadId(UUID.randomUUID());
    SimpleForumPost firstPost = new SimpleForumPost(new ForumPostId(UUID.randomUUID()), forumOpener, textOfFirstPost);

    return new SimpleForumThread(forumThreadId, threadTitle, firstPost);
  }

  @Override
  public Collection<ForumThread<Simple>> getAllForumThreads() {
    return allForumThreads.values();
  }

  @Contract("null -> fail")
  @Override
  public void saveForumThread(ForumThread<Simple> forumThread) {
    if (forumThread == null) {
      throw new NullPointerException("Es muss ein Forum-Thread uebergeben werden");
    }

    allForumThreads.put(forumThread.getForumThreadId().getUuid(), forumThread);
  }

  @Override
  public Optional<ForumThread<Simple>> getForumThreadById(UUID forumThreadUuid) {
    return Optional.ofNullable(allForumThreads.get(forumThreadUuid));
  }

  @Override
  public void saveChangesToForumThread(ForumThread forumThread) {
    // ... nichts zu erledigen.
  }
}
