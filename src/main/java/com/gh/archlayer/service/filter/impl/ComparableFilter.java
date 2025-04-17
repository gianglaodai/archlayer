package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Operator;

/** An abstract base class for filters that operate on {@link Comparable} values. */
public abstract class ComparableFilter<T extends Comparable<? super T>> extends AbstractFilter<T> {

  /** Constructor. */
  public ComparableFilter(final String field, final T value, final Operator operator) {
    super(field, value, operator);
  }

  /**
   * Determines if the specified operator is supported by this filter.
   *
   * <p>This implementation supports the following operators:
   *
   * <ul>
   *   <li>{@link Operator#EQUALS}
   *   <li>{@link Operator#NOT_EQUALS}
   *   <li>{@link Operator#GREATER_THAN}
   *   <li>{@link Operator#GREATER_THAN_OR_EQUAL}
   *   <li>{@link Operator#LESS_THAN}
   *   <li>{@link Operator#LESS_THAN_OR_EQUAL}
   * </ul>
   *
   * @param operator The operator to check.
   * @return {@code true} if the specified operator is supported, otherwise {@code false}.
   */
  public static boolean supportOperator(final Operator operator) {
    return switch (operator) {
      case EQUALS, NOT_EQUALS, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL ->
          true;
      default -> false;
    };
  }
}
