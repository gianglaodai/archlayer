package com.gh.archlayer.service.filter;

import com.gh.archlayer.service.exception.BaseServiceException;
import com.gh.archlayer.service.exception.ServiceExceptionFactory;
import java.util.Map;

/** Enum representing the different operators that can be used in a filter. */
public enum Operator {
  IS,
  EQUALS,
  NOT_EQUALS,
  GREATER_THAN,
  GREATER_THAN_OR_EQUAL,
  LESS_THAN,
  LESS_THAN_OR_EQUAL,
  LIKE,
  NOT_LIKE,
  IN;

  /**
   * Convert a string representation of an operator into an actual operator.
   *
   * <p>Supported string representations are:
   *
   * <ul>
   *   <li>"=" and "" for {@link Operator#EQUALS}
   *   <li>"!=" and "&lt;&gt;" for {@link Operator#NOT_EQUALS}
   *   <li>"&gt;" and "gt" for {@link Operator#GREATER_THAN}
   *   <li>"&gt;=" and "gte" for {@link Operator#GREATER_THAN_OR_EQUAL}
   *   <li>"&lt;" and "lt" for {@link Operator#LESS_THAN}
   *   <li>"&lt;=" and "lte" for {@link Operator#LESS_THAN_OR_EQUAL}
   *   <li>"like", and "~" for {@link Operator#LIKE}
   *   <li>"!like", "not_like", and "!~" for {@link Operator#NOT_LIKE}
   *   <li>"in" for {@link Operator#IN}
   * </ul>
   *
   * @param symbol the string representation of the operator
   * @return the operator
   * @throws BaseServiceException if the string representation is invalid
   */
  public static Operator fromSymbol(final String symbol) {
    return switch (symbol.strip().toLowerCase()) {
      case "is" -> Operator.IS;
      case "=", "" -> Operator.EQUALS;
      case "!=", "<>" -> Operator.NOT_EQUALS;
      case ">", "gt" -> Operator.GREATER_THAN;
      case ">=", "gte" -> Operator.GREATER_THAN_OR_EQUAL;
      case "<", "lt" -> Operator.LESS_THAN;
      case "<=", "lte" -> Operator.LESS_THAN_OR_EQUAL;
      case "like", "~" -> Operator.LIKE;
      case "!like", "not_like", "!~" -> Operator.NOT_LIKE;
      case "in", "[]" -> Operator.IN;
      default ->
          throw ServiceExceptionFactory.newBadRequestException(
              "filter.invalid_operator", Map.of("symbol", symbol), "Invalid operator: " + symbol);
    };
  }
}
