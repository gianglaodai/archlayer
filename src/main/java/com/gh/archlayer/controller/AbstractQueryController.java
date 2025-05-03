package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.api.QueryService;
import com.gh.archlayer.service.filter.FilterFactory;
import com.gh.archlayer.service.model.Identifiable;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Abstract base class for query controllers, providing common functionality for managing query
 * models.
 *
 * @param <T> the type of transfer object
 * @param <M> the type of query model
 */
public abstract class AbstractQueryController<
    T extends TransferObject & Identifiable, M extends QueryModel> {
  /**
   * Retrieves the query service associated with this controller.
   *
   * @return An instance of QueryService that provides query operations on query models.
   */
  public abstract QueryService<M> getService();

  /**
   * Retrieves the transfer object mapper associated with this controller.
   *
   * @return An instance of TransferObjectMapper that facilitates the conversion between query
   *     models and transfer objects.
   */
  public abstract TransferObjectMapper<T, M> getMapper();

  /**
   * Retrieves a transfer object by its unique identifier.
   *
   * @param id the unique identifier of the transfer object
   * @return An optional containing the transfer object if found, otherwise an empty optional
   */
  public Optional<T> getById(final long id) {
    return getService().findById(id).map(getMapper()::toTransferObject);
  }

  /**
   * Retrieves a transfer object by its unique identifier (UID).
   *
   * @param uid the unique identifier of the transfer object
   * @return An optional containing the transfer object if found, otherwise an empty optional
   */
  public Optional<T> getByUid(final String uid) {
    return getService().findByUid(uid).map(getMapper()::toTransferObject);
  }

  /**
   * Retrieves a list of all transfer objects that match the given filters and page request.
   *
   * @param firstResult the first result to include in the page
   * @param maxResults the maximum number of results to include in the page
   * @param rawOrders the raw orders string
   * @param filters the filters to apply to the query
   * @return a list of transfer objects that match the given filters, subject to the page request
   */
  public List<T> findAll(
      final int firstResult,
      final int maxResults,
      final String rawOrders,
      final List<String> filters) {
    return getService()
        .findAll(
            PageRequest.parse(firstResult, maxResults, rawOrders), FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  /**
   * Retrieves a list of transfer objects with the specified IDs, applying the given page request
   * and filters.
   *
   * @param ids the collection of IDs of the transfer objects to retrieve
   * @param firstResult the first result to include in the page
   * @param maxResults the maximum number of results to include in the page
   * @param rawOrders the raw orders string
   * @param filters the filters to apply to the query
   * @return a list of transfer objects with the specified IDs, subject to the page request and
   *     filters
   */
  public List<T> findByIds(
      final Collection<Long> ids,
      final int firstResult,
      final int maxResults,
      final String rawOrders,
      final List<String> filters) {
    return getService()
        .findByIds(
            ids,
            PageRequest.parse(firstResult, maxResults, rawOrders),
            FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  /**
   * Retrieves a list of transfer objects with the specified UIDs, applying the given page request
   * and filters.
   *
   * @param uids the collection of UIDs of the transfer objects to retrieve
   * @param firstResult the first result to include in the page
   * @param maxResults the maximum number of results to include in the page
   * @param rawOrders the raw orders string
   * @param filters the filters to apply to the query
   * @return a list of transfer objects with the specified UIDs, subject to the page request and
   *     filters
   */
  public List<T> findByUids(
      final Collection<String> uids,
      final int firstResult,
      final int maxResults,
      final String rawOrders,
      final List<String> filters) {
    return getService()
        .findByUids(
            uids,
            PageRequest.parse(firstResult, maxResults, rawOrders),
            FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  /**
   * Retrieves the count of transfer objects that match the given filters.
   *
   * @param filters the filters to apply to the query
   * @return the count of transfer objects that match the given filters
   */
  public long count(final List<String> filters) {
    return getService().count(FilterFactory.parseMany(filters));
  }
}
