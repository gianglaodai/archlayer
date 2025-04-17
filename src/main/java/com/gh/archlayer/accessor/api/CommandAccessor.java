package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.DataModel;
import java.util.Collection;
import java.util.List;

/**
 * This interface defines the contract for a command accessor, which is responsible for executing
 * CRUD (Create, Read, Update, Delete) operations on data models.
 *
 * @param <M> the type of data model that this accessor operates on
 */
public interface CommandAccessor<M extends DataModel> {
  /**
   * Save a data model.
   *
   * @param model the data model to save
   * @return the saved data model
   */
  M save(M model);

  /**
   * Save a collection of data models.
   *
   * @param models the collection of data models to save
   * @return the collection of saved data models
   */
  Collection<M> save(Collection<M> models);

  /**
   * Delete a data model by its ID.
   *
   * @param id the ID of the data model to delete
   */
  void deleteById(long id);

  /**
   * Delete a data model by its UID.
   *
   * @param uid the UID of the data model to delete
   */
  void deleteByUid(String uid);

  /**
   * Delete a collection of data models by their IDs.
   *
   * @param ids the IDs of the data models to delete
   */
  void deleteByIds(Collection<Long> ids);

  /**
   * Delete a collection of data models by their UIDs.
   *
   * @param uids the UIDs of the data models to delete
   */
  void deleteByUids(Collection<String> uids);

  /**
   * Delete all data models which match the given filters.
   *
   * @param filters the filters which must be matched by the data models to be deleted
   */
  void delete(List<? extends Filter<?>> filters);
}
