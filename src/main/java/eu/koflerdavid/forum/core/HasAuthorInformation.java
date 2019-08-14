package eu.koflerdavid.forum.core;

/**
 * Repraesentiert ein Objekt, das als Forum-Thread-Autor gespeichert sein kann.
 * Diese Informationen werden zum Anzeigen eines Posts benoetigt.
 */
public interface HasAuthorInformation {
  AuthorId getAuthorId();

  String getDisplayName();
}
