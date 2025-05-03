package com.gh.archlayer.service.filter;

import com.gh.archlayer.service.exception.ServiceExceptionFactory;

/**
 * This interface defines a filter that can be used to filter data based on a specific condition.
 * Implementations of this interface must provide a way to determine if a given operator is
 * supported.
 *
 * @param <T> the type of value being filtered
 */
public interface Filter<T> {
  /**
   * The field that this filter is operating on.
   *
   * @return the field
   */
  String getField();

  /**
   * Retrieves the value used by this filter.
   *
   * @return the value of type T that this filter is using
   */
  T getValue();

  /**
   * The operator used by this filter.
   *
   * @return the operator
   */
  Operator getOperator();

  /**
   * Determines if the given operator is supported by this filter implementation. Default
   * implementation is to always return true.
   *
   * @param operator the operator to check
   * @return true if the given operator is supported, false otherwise
   */
  static boolean supportOperator(final Operator operator) {
    return true;
  }

  /**
   * Creates a new filter with the given field, value and operator. Note that each implementation of
   * Filter must provide their own implementation of this method.
   *
   * @param field the field to filter on
   * @param rawValue the value to filter on
   * @param operator the operator to use
   * @return a new filter object
   */
  static Filter<?> newFilter(final String field, final String rawValue, final Operator operator) {
    throw ServiceExceptionFactory.newBadRequestException(null, null, null);
  }
}
