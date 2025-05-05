package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.time.LocalDateTime;

/** A filter for {@link LocalDateTime} values. */
public class LocalDateTimeFilter extends ComparableFilter<LocalDateTime> {

  /** Constructor. */
  public LocalDateTimeFilter(
      final String field, final Operator operator, final LocalDateTime value) {
    super(field, operator, value);
  }

  /**
   * Checks if the given operator is supported by this filter type.
   *
   * <p>This method is overridden from the super class to provide documentation.
   *
   * @param operator the operator to check
   * @return true if the given operator is supported, false otherwise
   */
  public static boolean supportOperator(final Operator operator) {
    return ComparableFilter.supportOperator(operator);
  }

  /**
   * Parse a given raw value into a {@link LocalDateTime}.
   *
   * <p>This method does not perform any validation or transformation on the given raw value.
   *
   * @param rawValue Value to parse.
   * @return Parsed value.
   */
  public static LocalDateTime parseValue(final String rawValue) {
    return LocalDateTime.parse(rawValue);
  }

  /**
   * Create a new {@link LocalDateTimeFilter} from given field, raw value, and operator.
   *
   * @param field Field to filter on.
   * @param operator Operator defining how the value should be compared.
   * @param rawValue Value to filter for.
   * @return A new {@link LocalDateTimeFilter} instance.
   */
  public static Filter<?> newFilter(
      final String field, final Operator operator, final String rawValue) {
    return new LocalDateTimeFilter(field, operator, parseValue(rawValue));
  }
}
