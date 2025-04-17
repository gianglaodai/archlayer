package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * This interface defines the contract for a query accessor, which is responsible for executing
 * queries on data models.
 *
 * @param <M> the type of data model that this accessor operates on
 */
public interface QueryAccessor<M extends QueryModel> {
  /**
   * Determines if a data model with the given id exists.
   *
   * @param id the id of the data model
   * @return true if a data model with the given id exists, false otherwise
   */
  boolean existsById(long id);

  /**
   * Checks if a data model with the specified UID exists.
   *
   * @param uid the UID of the data model to check for existence
   * @return true if a data model with the specified UID exists, false otherwise
   */
  boolean existsByUid(String uid);

  /**
   * Checks if any data model matches the given filters.
   *
   * @param filters a list of filters to apply to the query
   * @return true if any data model matches the given filters, false otherwise
   */
  boolean exists(List<? extends Filter<?>> filters);

  /**
   * Finds a data model by its id.
   *
   * @param id the id of the data model to find
   * @return an Optional containing the data model if found, or an empty Optional if not found
   */
  Optional<M> findById(long id);

  /**
   * Finds a data model by its UID.
   *
   * @param uid the UID of the data model to find
   * @return an Optional containing the data model if found, or an empty Optional if not found
   */
  Optional<M> findByUid(String uid);

  /**
   * Retrieves a collection of data models that match the given filters and page request.
   *
   * @param pageRequest the page request that specifies pagination and ordering
   * @param filters the filters to apply to the query
   * @return a collection of data models that match the given filters, subject to the page request
   */
  Collection<M> findMany(PageRequest pageRequest, List<? extends Filter<?>> filters);

  /**
   * Retrieves a single data model that matches the given filters.
   *
   * @param filters the filters to apply to the query
   * @return an Optional containing the single data model if found, or an empty Optional if no data
   *     model matches the given filters.
   */
  Optional<M> findSingle(List<? extends Filter<?>> filters);

  /**
   * Retrieves a collection of data models with the specified IDs, applying the given page request
   * and filters.
   *
   * @param ids the collection of IDs of the data models to retrieve
   * @param pageRequest the page request that specifies pagination and ordering
   * @param filters the filters to apply to the query
   * @return a collection of data models with the specified IDs, subject to the page request and
   *     filters
   */
  Collection<M> findByIds(
      Collection<Long> ids, PageRequest pageRequest, List<? extends Filter<?>> filters);

  /**
   * Retrieves a collection of data models with the specified UIDs, applying the given page request
   * and filters.
   *
   * @param uids the collection of UIDs of the data models to retrieve
   * @param pageRequest the page request that specifies pagination and ordering
   * @param filters the filters to apply to the query
   * @return a collection of data models with the specified UIDs, subject to the page request and
   *     filters.
   */
  Collection<M> findByUids(
      Collection<String> uids, PageRequest pageRequest, List<? extends Filter<?>> filters);

  /**
   * Counts the number of data models that match the given filters.
   *
   * @param filters the filters to apply to the query
   * @return the number of data models that match the given filters
   */
  long count(List<? extends Filter<?>> filters);
}
