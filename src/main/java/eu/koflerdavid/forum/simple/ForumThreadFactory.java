package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.ForumThread;

public interface ForumThreadFactory {
  ForumThread newForumThread(String threadTitle);
}
