package com.gh.archlayer.service.api;

import com.gh.archlayer.service.model.DataModel;

public interface CommandService<T extends DataModel> {
	/**
	 * Saves the given entity. If the entity's ID is null, a new entity is created.
	 * If the entity's ID is not null and exists, the existing entity is updated.
	 *
	 * @param entity the entity to be saved.
	 * @return the saved entity.
	 */
	T save(T entity);
	/**
	 * Deletes the entity with the given ID.
	 *
	 * @param id the ID of the entity to be deleted.
	 */
	void delete(long id);

	void delete(String uid);
}
