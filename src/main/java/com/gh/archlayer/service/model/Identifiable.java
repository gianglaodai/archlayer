package com.gh.archlayer.service.model;

/** This interface represents an identifiable entity, which has a unique ID and UID. */
public interface Identifiable {
  /**
   * Gets the unique identifier of the entity.
   *
   * @return the ID of the entity
   */
  long getId();

  /**
   * Gets the unique identifier (UID) of the entity.
   *
   * @return the UID of the entity
   */
  String getUid();
}
