package com.gh.archlayer.service.api;

import com.gh.archlayer.service.model.Model;

public interface CommandService<T extends Model> {
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
}
