package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.time.LocalDateTime;

public class LocalDateTimeFilter extends ComparableFilter<LocalDateTime> {
  public LocalDateTimeFilter(
      final String field, final LocalDateTime value, final Operator operator) {
    super(field, value, operator);
  }

  public static boolean supportOperator(final Operator operator) {
    return ComparableFilter.supportOperator(operator);
  }

  public static LocalDateTime parseValue(final String rawValue) throws Exception {
    return LocalDateTime.parse(rawValue);
  }

  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new LocalDateTimeFilter(field, LocalDateTime.parse(rawValue), operator);
  }
}
