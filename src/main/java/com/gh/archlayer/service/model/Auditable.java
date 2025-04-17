package com.gh.archlayer.service.model;

import java.time.Instant;

/**
 * This interface represents an auditable entity, which has a version and creation and update
 * timestamps.
 */
public interface Auditable {
  /**
   * Retrieves the version number of the auditable entity.
   *
   * @return the version number.
   */
  int getVersion();

  /**
   * Retrieves the creation timestamp of the auditable entity.
   *
   * @return the creation timestamp as an Instant.
   */
  Instant getCreatedAt();

  /**
   * Retrieves the update timestamp of the auditable entity.
   *
   * @return the update timestamp as an Instant.
   */
  Instant getUpdatedAt();
}
