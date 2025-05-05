package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.math.BigInteger;

/** A filter for {@link BigInteger} values. */
public class IntegerFilter extends NumberFilter<BigInteger> {

  /** Constructor. */
  public IntegerFilter(final String field, final Operator operator, final BigInteger value) {
    super(field, operator, value);
  }

  /**
   * Determine if the given operator is supported by this filter implementation.
   *
   * <p>This method delegates to the super classes implementation.
   *
   * @param operator The operator to check.
   * @return {@code true} if the given operator is supported, otherwise {@code false}.
   */
  public static boolean supportOperator(final Operator operator) {
    return ComparableFilter.supportOperator(operator);
  }

  /**
   * Parse a given raw value into a {@link BigInteger}.
   *
   * <p>This method does not perform any validation or transformation on the given raw value.
   *
   * @param rawValue Value to parse.
   * @return Parsed value.
   */
  public static BigInteger parseValue(final String rawValue) {
    return new BigInteger(rawValue);
  }

  /**
   * Creates a new {@link IntegerFilter} for the given field, raw value, and operator.
   *
   * @param field Field to filter on.
   * @param operator Operator defining how the value should be compared.
   * @param rawValue Value to filter for.
   * @return A new {@link IntegerFilter} instance.
   */
  public static Filter<?> newFilter(
      final String field, final Operator operator, final String rawValue) {
    return new IntegerFilter(field, operator, parseValue(rawValue));
  }
}
