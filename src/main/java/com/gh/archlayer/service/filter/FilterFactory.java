package com.gh.archlayer.service.filter;

import com.gh.archlayer.service.filter.impl.BooleanFilter;
import com.gh.archlayer.service.filter.impl.DecimalFilter;
import com.gh.archlayer.service.filter.impl.IntegerFilter;
import com.gh.archlayer.service.filter.impl.LocalDateFilter;
import com.gh.archlayer.service.filter.impl.LocalDateTimeFilter;
import com.gh.archlayer.service.filter.impl.StringFilter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FilterFactory {
  private static final String SPLITTER = ":";
  private static final List<Class<? extends Filter<?>>> SUPPORTED_FILTERS =
      List.of(
          IntegerFilter.class,
          DecimalFilter.class,
          LocalDateFilter.class,
          LocalDateTimeFilter.class,
          BooleanFilter.class,
          StringFilter.class);

  public static List<? extends Filter<?>> parseMany(final List<String> rawFilters) {
    return rawFilters.stream().map(FilterFactory::parseOne).toList();
  }

  private static Filter<?> parseOne(final String rawFilter) {
    final String[] parts = rawFilter.split(SPLITTER, 3);
    if (parts.length != 3) {
      throw new IllegalArgumentException("Invalid filter format: " + rawFilter);
    }

    final String field = parts[0];
    final String rawValue = parts[1];
    final String rawOperator = parts[2];
    final Operator operator = Operator.fromSymbol(rawOperator);

    for (final Class<? extends Filter<?>> filterClass : SUPPORTED_FILTERS) {
      try {
        return (Filter<?>)
            filterClass
                .getMethod("newFilter", String.class, String.class, Operator.class)
                .invoke(null, field, rawValue, operator);
      } catch (final InvocationTargetException e) {
        if (e.getCause() instanceof IllegalArgumentException) {
          // ignore this filter class
        } else {
          throw new RuntimeException(e);
        }
      } catch (final Exception e) {
        throw new RuntimeException(e);
      }
    }
    throw new IllegalArgumentException(
        "No compatible filter found for field="
            + field
            + ", operator="
            + operator
            + ", value="
            + rawValue);
  }
}
