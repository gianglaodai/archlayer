package com.gh.archlayer.service.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface QueryService<T extends QueryModel> {
    /**
     * Checks if an entity with the specified ID exists.
     *
     * @param id the ID of the entity to check for existence
     * @return true if an entity with the given ID exists, false otherwise
     */
	boolean existsById(long id);
	/**
	 * Retrieves an entity with the specified ID.
	 *
	 * @param id the ID of the entity to retrieve
	 * @return the entity with the given ID, or an empty optional if none exists
	 */
	Optional<T> findById(long id);
	/**
	 * Retrieves an entity with the specified UID.
	 *
	 * @param uid the UID of the entity to retrieve
	 * @return the entity with the given UID, or an empty optional if none exists
	 */
	Optional<T> findByUid(String uid);
	/**
	 * Retrieves all entities that match the given filters and page request.
	 *
	 * @param pageRequest the page request that specifies the desired page and optional ordering
	 * @param filters the filters to apply to the query
	 * @return a collection of entities that match the given filters, subject to the page request
	 */
	Collection<T> findAll(PageRequest pageRequest, List<Filter<?>> filters);
	/**
	 * Retrieves a collection of entities with the specified IDs,
	 * applying the given page request and filters.
	 *
	 * @param ids the collection of IDs of the entities to retrieve
	 * @param pageRequest the page request that specifies pagination and ordering
	 * @param filters the filters to apply to the query
	 * @return a collection of entities with the specified IDs, subject to the page request and filters
	 */
	Collection<T> findByIds(Collection<Long> ids, PageRequest pageRequest, List<Filter<?>> filters);
	/**
	 * Retrieves a collection of entities with the specified UIDs,
	 * applying the given page request and filters.
	 *
	 * @param uids the collection of UIDs of the entities to retrieve
	 * @param pageRequest the page request that specifies pagination and ordering
	 * @param filters the filters to apply to the query
	 * @return a collection of entities with the specified UIDs, subject to the page request and filters
	 */
	Collection<T> findByUids(Collection<String> uids, PageRequest pageRequest, List<Filter<?>> filters);
	/**
	 * Counts the number of entities that match the given filters.
	 *
	 * @param filters the filters to apply to the query
	 * @return the number of entities that match the given filters
	 */
	long count(List<Filter<?>> filters);
}
