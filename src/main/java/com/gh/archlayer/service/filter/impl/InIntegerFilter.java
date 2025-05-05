package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InIntegerFilter extends AbstractFilter<List<BigInteger>> {

  public InIntegerFilter(final String field, final List<BigInteger> value) {
    super(field, Operator.IN, value);
  }

  public static Filter<?> newFilter(
      final String field, final Operator operator, final String rawValue) {
    return new InIntegerFilter(field, parseValue(rawValue));
  }

  public static List<BigInteger> parseValue(final String rawValue) {
    return Arrays.stream(rawValue.split("\\|")).map(BigInteger::new).toList();
  }

  public static boolean supportOperator(final Operator operator) {
    return operator == Operator.IN;
  }
}
