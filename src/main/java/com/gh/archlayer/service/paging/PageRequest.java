package com.gh.archlayer.service.paging;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.List;

/**
 * Represents a page request, which includes the first result, maximum results, and ordering
 * information.
 */
public record PageRequest(int firstResult, int maxResults, List<Order> orders) {
  private static final String SPLITTER = ",";

  /**
   * Retrieves the index of the first result to return from the query, relative to the entire
   * dataset. A value of 0 will return the first result, 1 the second, and so on.
   *
   * @return The index of the first result to return.
   */
  public int getFirstResult() {
    return firstResult;
  }

  /**
   * Retrieves the maximum number of results to return from the query. A value of 0 is treated as
   * "no limit", and the entire dataset will be returned.
   *
   * @return The maximum number of results to return from the query.
   */
  public int getMaxResults() {
    return maxResults;
  }

  /**
   * Retrieves the list of orders to apply to the query, which will be used to order the results.
   * The list of orders is guaranteed to be non-null and non-empty. If no orders are specified, the
   * list will contain a single, ascending order on the primary key of the entity.
   *
   * @return The list of orders to apply to the query.
   */
  public List<Order> getOrders() {
    return orders;
  }

  /**
   * Parses the given page request attributes into a {@link PageRequest}.
   *
   * @param firstResult the first result to include in the page
   * @param maxResults the maximum number of results to include in the page
   * @param rawOrders the raw orders string
   * @return a {@link PageRequest} constructed from the given page request attributes
   */
  public static PageRequest parse(
      final int firstResult, final int maxResults, final String rawOrders) {
    if (isBlank(rawOrders)) {
      return new PageRequest(firstResult, maxResults, List.of());
    }
    return new PageRequest(
        firstResult, maxResults, stream(rawOrders.split(SPLITTER)).map(Order::parse).toList());
  }
}
