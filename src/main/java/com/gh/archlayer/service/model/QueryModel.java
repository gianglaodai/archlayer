package com.gh.archlayer.service.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a query model that implements the Identifiable and Model interfaces. This class
 * provides a basic structure for query models that require a unique identifier (ID) and a unique
 * identifier (UID).
 */
public abstract class QueryModel implements Identifiable, Model {
  private final long id;
  private final String uid;

  /**
   * Constructs a new QueryModel instance with the given ID and UID.
   *
   * @param id the unique identifier of the entity
   * @param uid the unique identifier (UID) of the entity
   */
  public QueryModel(final long id, final String uid) {
    this.id = id;
    this.uid = uid;
  }

  /**
   * Gets the unique identifier of the entity.
   *
   * @return the ID of the entity
   */
  @Override
  public long getId() {
    return id;
  }

  /**
   * Gets the unique identifier (UID) of the entity.
   *
   * @return the UID of the entity
   */
  @Override
  public String getUid() {
    return uid;
  }

  /**
   * Compares this QueryModel to the specified object. The result is {@code true} if and only if the
   * argument is not {@code null}, is a QueryModel object, and has the same ID as this object.
   *
   * @param o the object to compare this QueryModel against
   * @return {@code true} if the given object represents a QueryModel with the same ID as this one,
   *     {@code false} otherwise
   */
  @Override
  public boolean equals(final Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final QueryModel that = (QueryModel) o;
    return id == that.id;
  }

  /**
   * Returns the hash code of the object. The hash code is the same as the one returned by {@link
   * Long#hashCode(long)}.
   *
   * @return the hash code of this object
   */
  @Override
  public int hashCode() {
    return Long.hashCode(id);
  }

  /**
   * Returns a string representation of this QueryModel.
   *
   * <p>The returned string is of the form {@code QueryModel{super=<super>, id=<id>, uid=<uid>}},
   * where {@code <super>} is the string representation of the superclass, {@code <id>} is the value
   * returned by {@link #getId()}, and {@code <uid>} is the value returned by {@link #getUid()}.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .appendSuper(super.toString())
        .append("id", id)
        .append("uid", uid)
        .toString();
  }
}
