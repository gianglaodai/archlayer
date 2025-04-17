package com.gh.archlayer.service.api;

import com.gh.archlayer.service.model.DataModel;

/**
 * This interface defines the contract for a command service, which is responsible for executing
 * CRUD (Create, Read, Update, Delete) operations on data models.
 *
 * @param <T> the type of data model that this service operates on
 */
public interface CommandService<T extends DataModel> {
  /**
   * Saves a data model to the data store.
   *
   * @param entity the data model to be saved
   * @return the saved data model
   */
  T save(T entity);

  /**
   * Deletes a data model identified by its ID.
   *
   * @param id the ID of the data model to be deleted
   */
  void delete(long id);

  /**
   * Deletes a data model identified by its UID.
   *
   * @param uid the UID of the data model to be deleted
   */
  void delete(String uid);
}
