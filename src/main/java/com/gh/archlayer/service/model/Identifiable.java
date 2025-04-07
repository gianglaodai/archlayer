package com.gh.archlayer.service.model;

public interface Identifiable {
	/**
	 * Retrieves the unique identifier of the entity.
	 *
	 * @return the ID of the entity.
	 */
	Long getId();
	/**
	 * Retrieves the unique identifier (UID) of the entity.
	 *
	 * @return the UID of the entity.
	 */
	String getUid();
}
