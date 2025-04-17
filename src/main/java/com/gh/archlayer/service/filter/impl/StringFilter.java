package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

/** A filter for {@link String} values. */
public class StringFilter extends AbstractFilter<String> {

  /** Constructor. */
  public StringFilter(final String field, final String value, final Operator operator) {
    super(field, value, operator);
  }

  /**
   * Determine if the given operator is supported by this filter implementation.
   *
   * <p>This implementation supports the following operators:
   *
   * <ul>
   *   <li>{@link Operator#EQUALS}
   *   <li>{@link Operator#NOT_EQUALS}
   *   <li>{@link Operator#LIKE}
   *   <li>{@link Operator#NOT_LIKE}
   * </ul>
   *
   * @param operator The operator to check.
   * @return {@code true} if the given operator is supported, otherwise {@code false}.
   */
  public static boolean supportOperator(final Operator operator) {
    return switch (operator) {
      case EQUALS, NOT_EQUALS, LIKE, NOT_LIKE -> true;
      default -> false;
    };
  }

  /**
   * Parse a given raw value into a {@link String}.
   *
   * <p>This method does not perform any validation or transformation on the given raw value.
   *
   * @param rawValue Value to parse.
   * @return Parsed value.
   */
  public static String parseValue(final String rawValue) {
    return rawValue;
  }

  /**
   * Creates a new {@link StringFilter} for the given field, raw value, and operator.
   *
   * @param field Field to filter on.
   * @param rawValue Value to filter for.
   * @param operator Operator defining how the value should be compared.
   * @return A new {@link StringFilter} instance.
   */
  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new StringFilter(field, rawValue, operator);
  }
}
