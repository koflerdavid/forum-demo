package eu.koflerdavid.forum.core.test;

import eu.koflerdavid.forum.core.*;
import eu.koflerdavid.forum.simple.Simple;
import eu.koflerdavid.forum.simple.SimpleForumAuthor;
import eu.koflerdavid.forum.simple.SimpleForumThreadRepository;
import org.apache.openwebbeans.junit5.Cdi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Cdi(classes = SimpleForumThreadRepository.class)
class ForumThreadTest {

  private @Inject
  ForumThreadFactory<Simple> forumThreadFactory;

  private @Inject
  ForumThreadRepository<Simple> forumRepository;

  private ForumAuthor<Simple> defaultAuthor;

  @BeforeEach
  void init() {
    defaultAuthor = new SimpleForumAuthor(UUID.randomUUID(), "David Kofler");
  }

  @ParameterizedTest
  @ValueSource(strings = {"Thread-Titel 1", "Thread-Titel 2", "Thread-Titel 3"})
  void derTitelDesForumsSollteGespeichertWerden(String threadTitle) {
    ForumThreadId forumThreadId = createAndSaveForumThread(threadTitle, "Anfangstext");

    Optional<ForumThread<Simple>> forumThreadById = forumRepository.getForumThreadById(forumThreadId);

    Assertions.assertTrue(forumThreadById.isPresent());
    assertEquals(threadTitle, forumThreadById.get().getTitle(),
            "Thread title does not match");
  }

  @ParameterizedTest
  @ValueSource(strings = {"Text 1", "Text 2"})
  void derTextDesErstenPostsSollteGespeichertWerden(String textOfFirstPost) {
    ForumThreadId forumThreadId = createAndSaveForumThread("Testthread", textOfFirstPost);

    Optional<ForumThread<Simple>> forumThreadById = forumRepository.getForumThreadById(forumThreadId);

    Assertions.assertTrue(forumThreadById.isPresent());
    assertEquals(textOfFirstPost, forumThreadById.get().getPosts().get(0).getContent(),
            "Text of first post does not match");
  }

  @ParameterizedTest
  @ValueSource(strings = {"Text 1", "Text 2"})
  void hinzufuegenEinesNeuenPostsFunktioniert(String contentOfNewPost) {
    ForumThread<Simple> thread = forumThreadFactory.newForumThread("Ein Titel", defaultAuthor, "Erster Post");
    thread.addPost(defaultAuthor, contentOfNewPost);
    forumRepository.saveChangesToForumThread(thread);

    List<ForumPost<Simple>> posts = thread.getPosts();
    assertEquals(2, posts.size());
    assertEquals("Erster Post", posts.get(0).getContent());
    assertEquals(contentOfNewPost, posts.get(1).getContent());
  }

  private ForumThreadId createAndSaveForumThread(String threadTitle, String firstPostContent) {
    ForumThread<Simple> thread = forumThreadFactory.newForumThread(threadTitle, defaultAuthor, firstPostContent);
    forumRepository.saveForumThread(thread);
    return thread.getForumThreadId();
  }

}
