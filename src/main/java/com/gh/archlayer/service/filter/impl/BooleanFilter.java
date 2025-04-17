package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

/** A filter for {@link Boolean} values. */
public class BooleanFilter extends AbstractFilter<Boolean> {

  /** Constructors. */
  public BooleanFilter(final String field, final Boolean value, final Operator operator) {
    super(field, value, operator);
  }

  /**
   * Determines if the given operator is supported by this filter implementation.
   *
   * <p>This implementation supports the following operators:
   *
   * <ul>
   *   <li>{@link Operator#EQUALS}
   *   <li>{@link Operator#NOT_EQUALS}
   * </ul>
   *
   * @param operator the operator to check
   * @return true if the given operator is supported, false otherwise
   */
  public static boolean supportOperator(final Operator operator) {
    return operator == Operator.EQUALS || operator == Operator.NOT_EQUALS;
  }

  /**
   * Parse a given raw value into a {@link Boolean}.
   *
   * <p>This method does not perform any validation or transformation on the given raw value.
   *
   * @param rawValue Value to parse.
   * @return Parsed value.
   */
  public static Boolean parseValue(final String rawValue) {
    return Boolean.parseBoolean(rawValue);
  }

  /**
   * Creates a new {@link BooleanFilter} for the given field, raw value, and operator.
   *
   * <p>This method parses the raw value into a {@link Boolean} and returns a new filter instance.
   *
   * @param field Field to filter on.
   * @param rawValue Raw value to filter for, which will be parsed into a {@link Boolean}.
   * @param operator Operator defining how the value should be compared.
   * @return A new {@link BooleanFilter} instance.
   */
  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new BooleanFilter(field, Boolean.parseBoolean(rawValue), operator);
  }
}
