package eu.koflerdavid.forum.core;

import org.jetbrains.annotations.Contract;

import java.util.Objects;
import java.util.UUID;

/**
 * Wrapper-Klasse, welche den Domaenen-Identifier (hier immer eine UUID),
 * der zum Identifizieren einer Entitaet benuetzt wird, kapselt.
 * Jede Entitaetsklasse sollte eine Subklasse erstellen,
 * um das versehentliche Vermischen dieser Identifier zu vermeiden.
 */
public abstract class AbstractEntityId {

  protected UUID uuid;

  @Contract("null -> fail")
  public AbstractEntityId(UUID uuid) {
    if (uuid == null) {
      throw new NullPointerException("Der UUID-Parameter war null");
    }

    this.uuid = uuid;
  }

  public UUID getUuid() {
    return uuid;
  }

  @Override
  public abstract String toString();

  @Contract(value = "null -> false", pure = true)
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractEntityId that = (AbstractEntityId) o;
    return Objects.equals(getUuid(), that.getUuid());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUuid());
  }

}
