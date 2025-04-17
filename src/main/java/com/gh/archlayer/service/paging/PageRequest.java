package com.gh.archlayer.service.paging;

import java.util.List;

/**
 * Represents a page request, which includes the first result, maximum results, and ordering
 * information.
 */
public interface PageRequest {
  /**
   * Retrieves the index of the first result to return from the query, relative to the entire
   * dataset. A value of 0 will return the first result, 1 the second, and so on.
   *
   * @return The index of the first result to return.
   */
  int getFirstResult();

  /**
   * Retrieves the maximum number of results to return from the query. A value of 0 is treated as
   * "no limit", and the entire dataset will be returned.
   *
   * @return The maximum number of results to return from the query.
   */
  int getMaxResults();

  /**
   * Retrieves the list of orders to apply to the query, which will be used to order the results.
   * The list of orders is guaranteed to be non-null and non-empty. If no orders are specified, the
   * list will contain a single, ascending order on the primary key of the entity.
   *
   * @return The list of orders to apply to the query.
   */
  List<Order> getOrders();
}
