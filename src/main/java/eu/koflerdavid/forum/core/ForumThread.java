package eu.koflerdavid.forum.core;

import java.util.List;

/**
 * Repraesentiert einen Forum/Thread dar, der aus einer Reihe von zeitlich sortierten Posts besteht.
 * Der erste Post hat eine Sonderstellung, da er den Thread einleitet und dessen Autor
 * Rechte zur Verwaltung des Threads haben sollte.
 *
 * @param <Impl> Parameter, der die konkrete Implementierung dieser Klasse bescchreibt.
 *               Damit kann sichergestellt werden, dass Objekte von inkompatiblen Implementierungen eingesetzt werden.
 *               Wenn das gewuenscht ist, muessen Wrapper-Klassen benutzt oder die Daten uebertragen werden.
 */
public interface ForumThread<Impl> {

  ForumThreadId getForumThreadId();

  String getTitle();

  List<ForumPost<Impl>> getPosts();

  HasAuthorInformation getAuthorOfFirstPost();

  /**
   * Factory-Methode zum Erstellen neuer Posts. Posts existieren immer in einem Thread-Kontext.
   * Es gibt keine Posts ohne den dazugehoerigen Thread.
   *
   * @param postAuthor Der Autor des neuen Posts.
   * @param content    Der Inhalt des neuen Posts.
   * @return einen neuen Post. Er gehoert bereits zu diesem Thread.
   */
  ForumPost<Impl> addPost(ForumAuthor<Impl> postAuthor, String content);
}
