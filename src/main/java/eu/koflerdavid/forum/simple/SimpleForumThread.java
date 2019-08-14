package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SimpleForumThread implements ForumThread<Simple> {

  private ForumThreadId forumThreadId;

  private String title;

  private List<ForumPost<Simple>> posts;

  SimpleForumThread(ForumThreadId forumThreadId, String title, SimpleForumPost firstPost) {
    this.forumThreadId = forumThreadId;
    this.title = title;
    this.posts = new ArrayList<>();
    posts.add(firstPost);
  }

  @Override
  public ForumThreadId getForumThreadId() {
    return forumThreadId;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public List<ForumPost<Simple>> getPosts() {
    return Collections.unmodifiableList(posts);
  }

  @Override
  public HasAuthorInformation getAuthorOfFirstPost() {
    return null;
  }

  @Override
  public SimpleForumPost addPost(ForumAuthor<Simple> postAuthor, String content) {
    ForumPostId forumPostId = new ForumPostId(UUID.randomUUID());
    SimpleForumPost newPost = new SimpleForumPost(forumPostId, forumThreadId, postAuthor, content);
    posts.add(newPost);
    return newPost;
  }
}
