package eu.koflerdavid.forum.core;

import eu.koflerdavid.forum.simple.DefaultForumThread;
import eu.koflerdavid.forum.simple.ForumThreadFactory;

public class DefaultForumThreadFactory implements ForumThreadFactory {
  @Override
  public ForumThread newForumThread(String threadTitle) {
    return new DefaultForumThread(threadTitle);
  }
}
