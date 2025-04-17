package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.time.LocalDate;

/** A filter for {@link LocalDate} values. */
public class LocalDateFilter extends ComparableFilter<LocalDate> {
  /** Constructor. */
  public LocalDateFilter(final String field, final LocalDate value, final Operator operator) {
    super(field, value, operator);
  }

  /**
   * Determines if the given operator is supported by this filter implementation.
   *
   * <p>This method delegates to the super classes implementation.
   *
   * @param operator the operator to check
   * @return true if the given operator is supported, false otherwise
   */
  public static boolean supportOperator(final Operator operator) {
    return ComparableFilter.supportOperator(operator);
  }

  /**
   * Parse a given raw value into a {@link LocalDate}.
   *
   * <p>This method does not perform any validation or transformation on the given raw value.
   *
   * @param rawValue Value to parse.
   * @return Parsed value.
   */
  public static LocalDate parseValue(final String rawValue) {
    return LocalDate.parse(rawValue);
  }

  /**
   * Creates a new {@link LocalDateFilter} for the given field, raw value, and operator.
   *
   * <p>This method parses the raw value into a {@link LocalDate} and returns a new filter instance.
   *
   * @param field Field to filter on.
   * @param rawValue Raw value to filter for, which will be parsed into a {@link LocalDate}.
   * @param operator Operator defining how the value should be compared.
   * @return A new {@link LocalDateFilter} instance.
   */
  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new LocalDateFilter(field, LocalDate.parse(rawValue), operator);
  }
}
