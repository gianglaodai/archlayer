package com.gh.archlayer.service.filter;

public interface Filter<T> {
  String getField();

  T getValue();

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
    throw new UnsupportedOperationException("Not implemented");
  }
}
