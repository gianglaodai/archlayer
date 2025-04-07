package com.gh.archlayer.service.model;

import java.time.Instant;

public interface Auditable {
	/**
	 * Gets the instant at which the entity was created.
	 *
	 * @return the instant of creation
	 */
	Instant getCreatedAt();
	/**
	 * Gets the instant at which the entity was last updated.
	 *
	 * @return the instant of the last update
	 */
	Instant getUpdatedAt();
}
