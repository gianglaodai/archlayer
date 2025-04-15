package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

public class BooleanFilter extends AbstractFilter<Boolean> {
  public BooleanFilter(final String field, final Boolean value, final Operator operator) {
    super(field, value, operator);
  }

  public static boolean supportOperator(final Operator operator) {
    return operator == Operator.EQUALS || operator == Operator.NOT_EQUALS;
  }

  public static Boolean parseValue(final String rawValue) throws Exception {
    return Boolean.parseBoolean(rawValue);
  }

  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new BooleanFilter(field, Boolean.parseBoolean(rawValue), operator);
  }
}
