package eu.koflerdavid.forum.core;

public interface ForumThreadFactory<Impl> {
  ForumThread<Impl> newForumThread(String threadTitle, ForumAuthor<Impl> forumOpener, String textOfFirstPost);
}
