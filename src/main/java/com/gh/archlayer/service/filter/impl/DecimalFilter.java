package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.math.BigDecimal;

/** A filter for {@link BigDecimal} values. */
public class DecimalFilter extends NumberFilter<BigDecimal> {

  /** Constructor. */
  public DecimalFilter(final String field, final Operator operator, final BigDecimal value) {
    super(field, operator, value);
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
   * Parse a given raw value into a {@link BigDecimal}.
   *
   * <p>This method does not perform any validation or transformation on the given raw value.
   *
   * @param rawValue Value to parse.
   * @return Parsed value.
   */
  public static BigDecimal parseValue(final String rawValue) {
    return new BigDecimal(rawValue);
  }

  /**
   * Creates a new {@link DecimalFilter} for the given field, raw value, and operator.
   *
   * <p>This method parses the raw value into a {@link BigDecimal} and returns a new filter
   * instance.
   *
   * @param field Field to filter on.
   * @param operator Operator defining how the value should be compared.
   * @param rawValue Raw value to filter for, which will be parsed into a {@link BigDecimal}.
   * @return A new {@link DecimalFilter} instance.
   */
  public static Filter<?> newFilter(
      final String field, final Operator operator, final String rawValue) {
    return new DecimalFilter(field, operator, parseValue(rawValue));
  }
}
