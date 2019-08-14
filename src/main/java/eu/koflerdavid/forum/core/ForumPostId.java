package eu.koflerdavid.forum.core;

import org.jetbrains.annotations.Contract;

import java.util.UUID;

public class ForumPostId extends AbstractEntityId {
  @Contract("null -> fail")
  public ForumPostId(UUID uuid) {
    super(uuid);
  }

  @Override
  public String toString() {
    return "ForumPostId{" +
            "uuid=" + getUuid() +
            '}';
  }
}
