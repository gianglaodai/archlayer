package com.gh.archlayer.service.model;

import java.time.Instant;

/**
 * Represents a data model with versioning and auditing information.
 *
 * <p>This class provides a basic structure for data models that require versioning and auditing. It
 * includes fields for version, creation time, and update time.
 */
public abstract class DataModel extends QueryModel implements Auditable {
  private final int version;
  private final Instant createdAt;
  private final Instant updatedAt;

  /**
   * Constructs a new DataModel instance with the given parameters.
   *
   * @param id the ID of the data model
   * @param uid the unique ID of the data model
   * @param version the version of the data model
   * @param createdAt the creation time of the data model
   * @param updatedAt the update time of the data model
   */
  public DataModel(
      final long id,
      final String uid,
      final int version,
      final Instant createdAt,
      final Instant updatedAt) {
    super(id, uid);
    this.version = version;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  /**
   * Retrieves the version number of the data model.
   *
   * @return the version number of the data model.
   */
  @Override
  public int getVersion() {
    return version;
  }

  /**
   * Retrieves the creation time of the data model.
   *
   * @return the creation time of the data model as an Instant.
   */
  @Override
  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Retrieves the update time of the data model.
   *
   * @return the update time of the data model as an Instant.
   */
  @Override
  public Instant getUpdatedAt() {
    return updatedAt;
  }
}
