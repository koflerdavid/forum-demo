package eu.koflerdavid.forum.simple;

import eu.koflerdavid.forum.core.ForumThread;

public class DefaultForumThread implements ForumThread {

  private String title;

  public DefaultForumThread(String title) {
    this.title = title;
  }

  @Override
  public String getTitle() {
    return title;
  }

}
