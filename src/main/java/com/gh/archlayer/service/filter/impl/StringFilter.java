package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

public class StringFilter extends AbstractFilter<String> {
  public StringFilter(final String field, final String value, final Operator operator) {
    super(field, value, operator);
  }

  public static boolean supportOperator(final Operator operator) {
    return switch (operator) {
      case EQUALS, NOT_EQUALS, LIKE, NOT_LIKE -> true;
      default -> false;
    };
  }

  public static String parseValue(final String rawValue) throws Exception {
    return rawValue;
  }

  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new StringFilter(field, rawValue, operator);
  }
}
