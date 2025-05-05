package com.gh.archlayer.service.api;

import com.gh.archlayer.accessor.api.QueryAccessor;
import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Abstract base class for query services, providing common functionality for executing queries on
 * data models.
 *
 * @param <T> the type of data model that this service operates on
 */
public abstract class AbstractQueryService<T extends QueryModel> implements QueryService<T> {
  /**
   * Retrieves the query accessor associated with this service.
   *
   * @return An instance of QueryAccessor responsible for executing queries on data models.
   */
  protected abstract QueryAccessor<T> getAccessor();

  /**
   * Finds a data model by its ID.
   *
   * @param id the ID of the data model to find
   * @return an Optional containing the data model if found, or an empty Optional if not found
   */
  @Override
  public Optional<T> findById(final long id) {
    return getAccessor().findById(id);
  }

  /**
   * Checks if a data model with the given ID exists.
   *
   * @param id the ID of the data model to check for existence
   * @return true if a data model with the given ID exists, false otherwise
   */
  @Override
  public boolean existsById(final long id) {
    return getAccessor().existsById(id);
  }

  /**
   * Finds a data model by its UID.
   *
   * @param uid the UID of the data model to find
   * @return an Optional containing the data model if found, or an empty Optional if not found
   */
  @Override
  public Optional<T> findByUid(final String uid) {
    return getAccessor().findByUid(uid);
  }

  /**
   * Retrieves all data models that match the given filters and page request.
   *
   * @param pageRequest the page request that specifies the desired page and optional ordering
   * @param filters the filters to apply to the query
   * @return a collection of data models that match the given filters, subject to the page request
   */
  @Override
  public Collection<T> findAll(
      final Collection<Long> ids,
      final Collection<String> uids,
      final PageRequest pageRequest,
      final List<? extends Filter<?>> filters) {
    return getAccessor().findMany(pageRequest, filters);
  }

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
  @Override
  public Collection<T> findByIds(
      final Collection<Long> ids,
      final PageRequest pageRequest,
      final List<? extends Filter<?>> filters) {
    return getAccessor().findByIds(ids, pageRequest, filters);
  }

  /**
   * Retrieves a collection of data models with the specified UIDs, applying the given page request
   * and filters.
   *
   * @param uids the collection of UIDs of the data models to retrieve
   * @param pageRequest the page request that specifies pagination and ordering
   * @param filters the filters to apply to the query
   * @return a collection of data models with the specified UIDs, subject to the page request and
   *     filters
   */
  @Override
  public Collection<T> findByUids(
      final Collection<String> uids,
      final PageRequest pageRequest,
      final List<? extends Filter<?>> filters) {
    return getAccessor().findByUids(uids, pageRequest, filters);
  }

  /**
   * Counts the number of data models that match the given filters.
   *
   * @param filters the filters to apply to the query
   * @return the number of data models that match the given filters
   */
  @Override
  public long count(final List<? extends Filter<?>> filters) {
    return getAccessor().count(filters);
  }
}
