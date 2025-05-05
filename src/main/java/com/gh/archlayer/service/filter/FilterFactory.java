package com.gh.archlayer.service.filter;

import com.gh.archlayer.service.exception.BaseServiceException;
import com.gh.archlayer.service.exception.ServiceExceptionFactory;
import com.gh.archlayer.service.filter.impl.BooleanFilter;
import com.gh.archlayer.service.filter.impl.DecimalFilter;
import com.gh.archlayer.service.filter.impl.InDecimalFilter;
import com.gh.archlayer.service.filter.impl.InIntegerFilter;
import com.gh.archlayer.service.filter.impl.InStringFilter;
import com.gh.archlayer.service.filter.impl.IntegerFilter;
import com.gh.archlayer.service.filter.impl.LocalDateFilter;
import com.gh.archlayer.service.filter.impl.LocalDateTimeFilter;
import com.gh.archlayer.service.filter.impl.StringFilter;
import com.gh.archlayer.utils.StringFormatter;
import java.lang.reflect.InvocationTargetException;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Factory class for creating filters. */
public class FilterFactory {
  private static final String SPLITTER = ":";
  private static final List<Class<? extends Filter<?>>> SUPPORTED_FILTERS =
      List.of(
          InIntegerFilter.class,
          IntegerFilter.class,
          InDecimalFilter.class,
          DecimalFilter.class,
          BooleanFilter.class,
          LocalDateFilter.class,
          LocalDateTimeFilter.class,
          InStringFilter.class,
          StringFilter.class);
  private static final Logger log = LoggerFactory.getLogger(FilterFactory.class);

  /**
   * Parses a list of raw filter strings into a list of Filter objects.
   *
   * @param rawFilters the list of raw filter strings, where each string is expected to be in the
   *     format: field:value:operator
   * @return a list of Filter objects parsed from the raw filter strings
   * @throws BaseServiceException if any of the raw filter strings are invalid
   */
  public static List<? extends Filter<?>> parseMany(final List<String> rawFilters) {
    return rawFilters.stream().map(FilterFactory::parseOne).toList();
  }

  /**
   * Parses a raw filter string into a Filter object.
   *
   * <p>The raw filter string is expected to be in the format: field:value:operator. This method
   * splits the string into its components, validates the format, and attempts to create a Filter
   * using reflection on supported filter classes.
   *
   * @param rawFilter the raw filter string to parse
   * @return a Filter object corresponding to the parsed filter string
   * @throws BaseServiceException if the raw filter string is invalid, if the operator is unknown,
   *     if no suitable filter is found, or if reflection fails
   */
  private static Filter<?> parseOne(final String rawFilter) {
    final boolean forceString = rawFilter.endsWith(":s");
    final String[] parts;
    if (forceString) {
      parts = rawFilter.substring(0, rawFilter.length() - 2).split(SPLITTER, 3);
    } else {
      parts = rawFilter.split(SPLITTER, 3);
    }

    if (parts.length != 3) {
      throw ServiceExceptionFactory.newBadRequestException(
          "filter.invalid_format",
          Map.of("raw", rawFilter),
          "Invalid filter format, expected format: field:value:operator:[s]");
    }

    final String field = parts[0];
    final String rawOperator = parts[1];
    final String rawValue = parts[2];

    final Operator operator;
    try {
      operator = Operator.fromSymbol(rawOperator);
    } catch (final IllegalArgumentException e) {
      throw ServiceExceptionFactory.newBadRequestException(
          "filter.invalid_operator",
          Map.of("symbol", rawOperator),
          "Unknown operator symbol: " + rawOperator);
    }

    if (forceString) {
      if (InStringFilter.supportOperator(operator)) {
        return InStringFilter.newFilter(field, operator, rawValue);
      }
      if (!StringFilter.supportOperator(operator)) {
        throw ServiceExceptionFactory.newBadRequestException(
            "filter.unsupported_filter",
            Map.of("field", field, "operator", operator.name(), "value", rawValue, "s", true),
            "No suitable filter found for given input.");
      }
      return StringFilter.newFilter(field, operator, rawValue);
    }

    for (final Class<? extends Filter<?>> filterClass : SUPPORTED_FILTERS) {
      try {
        final var supportOperatorMethod = filterClass.getMethod("supportOperator", Operator.class);
        final boolean isSupported = (boolean) supportOperatorMethod.invoke(null, operator);
        if (!isSupported) {
          continue;
        }
        return (Filter<?>)
            filterClass
                .getMethod("newFilter", String.class, Operator.class, String.class)
                .invoke(null, field, operator, rawValue);
      } catch (final InvocationTargetException e) {
        if (e.getCause() instanceof IllegalArgumentException
            || e.getCause() instanceof DateTimeParseException) {
          log.debug(
              "Filter {} rejected input field={}, value={}, operator={}",
              filterClass.getSimpleName(),
              field,
              rawValue,
              operator);
        } else {
          throw ServiceExceptionFactory.newInternalServerException(
              StringFormatter.format(
                  "Filter instantiation failed for {}", filterClass.getSimpleName()));
        }
      } catch (final Exception e) {
        throw ServiceExceptionFactory.newInternalServerException(
            StringFormatter.format(
                "Reflection failed for filter class: {}", filterClass.getSimpleName()));
      }
    }

    throw ServiceExceptionFactory.newBadRequestException(
        "filter.unsupported_filter",
        Map.of("field", field, "operator", operator.name(), "value", rawValue),
        "No suitable filter found for given input.");
  }
}
