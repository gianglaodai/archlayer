package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;
import java.time.LocalDate;

public class LocalDateFilter extends ComparableFilter<LocalDate> {
  public LocalDateFilter(final String field, final LocalDate value, final Operator operator) {
    super(field, value, operator);
  }

  public static boolean supportOperator(final Operator operator) {
    return ComparableFilter.supportOperator(operator);
  }

  public static LocalDate parseValue(final String rawValue) throws Exception {
    return LocalDate.parse(rawValue);
  }

  public static Filter<?> newFilter(
      final String field, final String rawValue, final Operator operator) {
    return new LocalDateFilter(field, LocalDate.parse(rawValue), operator);
  }
}
