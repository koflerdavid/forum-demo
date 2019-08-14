package eu.koflerdavid.forum.core.test;

import eu.koflerdavid.forum.core.DefaultForumThreadFactory;
import eu.koflerdavid.forum.core.ForumThread;
import eu.koflerdavid.forum.simple.ForumThreadFactory;
import org.apache.openwebbeans.junit5.Cdi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

@Cdi(classes = DefaultForumThreadFactory.class)
public class ForumThreadTest {

  private @Inject ForumThreadFactory forumThreadFactory;

  @ParameterizedTest
  @ValueSource(strings = {"Thread-Titel 1", "Thread-Titel 2", "Thread-Titel 3"})
  public void forumShouldSaveTitle(String threadTitle) {
    ForumThread thread = forumThreadFactory.newForumThread(threadTitle);

    Assertions.assertEquals(threadTitle, thread.getTitle(), "Thread title does not match");
  }

}
