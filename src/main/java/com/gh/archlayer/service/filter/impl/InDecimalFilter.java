package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InDecimalFilter extends AbstractFilter<List<BigDecimal>> {
  public InDecimalFilter(final String field, final List<BigDecimal> value) {
    super(field, Operator.IN, value);
  }

  public static Filter<?> newFilter(
      final String field, final Operator operator, final String rawValue) {
    return new InDecimalFilter(field, parseValue(rawValue));
  }

  public static List<BigDecimal> parseValue(final String rawValue) {
    return Arrays.stream(rawValue.split("\\|")).map(BigDecimal::new).toList();
  }

  public static boolean supportOperator(final Operator operator) {
    return operator == Operator.IN;
  }
}
