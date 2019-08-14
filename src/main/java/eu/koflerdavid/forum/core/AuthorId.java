package eu.koflerdavid.forum.core;

import java.util.UUID;

public class AuthorId extends AbstractEntityId {

  public AuthorId(UUID uuid) {
    super(uuid);
  }

  @Override
  public String toString() {
    return "AuthorId{" +
            "uuid=" + uuid +
            '}';
  }

}
