package eu.koflerdavid.forum.core;

import org.jetbrains.annotations.Contract;

import java.util.UUID;

public class ForumThreadId extends AbstractEntityId {

  @Contract("null -> fail")
  public ForumThreadId(UUID uuid) {
    super(uuid);
  }

  @Override
  public String toString() {
    return "ForumThreadId{" +
            "uuid=" + uuid +
            '}';
  }

}
