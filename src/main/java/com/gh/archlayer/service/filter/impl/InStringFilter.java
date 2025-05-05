package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.util.List;

public class InStringFilter extends AbstractFilter<List<String>> {
  public InStringFilter(final String field, final List<String> value) {
    super(field, Operator.IN, value);
  }

  public static Filter<?> newFilter(
      final String field, final Operator operator, final String rawValue) {
    return new InStringFilter(field, parseValue(rawValue));
  }

  public static List<String> parseValue(final String rawValue) {
    return List.of(rawValue.split("\\|"));
  }

  public static boolean supportOperator(final Operator operator) {
    return operator == Operator.IN;
  }
}
