package com.gh.archlayer.service.filter;

public enum Operator {
	EQUALS,
	NOT_EQUALS,
	GREATER_THAN,
	GREATER_THAN_OR_EQUAL,
	LESS_THAN,
	LESS_THAN_OR_EQUAL,
	LIKE,
	NOT_LIKE;

	/**
	 * Convert a string representation of an operator into an actual operator.
	 * <p>
	 * Supported string representations are:
	 * <ul>
	 * <li>"=" and "" for {@link Operator#EQUALS}</li>
	 * <li>"!=" and "&lt;&gt;" for {@link Operator#NOT_EQUALS}</li>
	 * <li>"&gt;" and "gt" for {@link Operator#GREATER_THAN}</li>
	 * <li>"&gt;=" and "gte" for {@link Operator#GREATER_THAN_OR_EQUAL}</li>
	 * <li>"&lt;" and "lt" for {@link Operator#LESS_THAN}</li>
	 * <li>"&lt;=" and "lte" for {@link Operator#LESS_THAN_OR_EQUAL}</li>
	 * <li>"LIKE", "like", and "~" for {@link Operator#LIKE}</li>
	 * <li>"NOT_LIKE", "!LIKE", "!like", "not_like", and "!~" for {@link Operator#NOT_LIKE}</li>
	 * </ul>
	 *
	 * @param symbol the string representation of the operator
	 * @return the operator
	 * @throws IllegalArgumentException if the string representation is invalid
	 */
	public static Operator fromSymbol(final String symbol) {
		return switch (symbol) {
			case "=", "" -> Operator.EQUALS;
			case "!=", "<>" -> Operator.NOT_EQUALS;
			case ">", "gt" -> Operator.GREATER_THAN;
			case ">=", "gte" -> Operator.GREATER_THAN_OR_EQUAL;
			case "<", "lt" -> Operator.LESS_THAN;
			case "<=", "lte" -> Operator.LESS_THAN_OR_EQUAL;
			case "LIKE", "like", "~" -> Operator.LIKE;
			case "NOT_LIKE", "!LIKE", "!like", "not_like", "!~" -> Operator.NOT_LIKE;
			default -> throw new IllegalArgumentException("Invalid operator symbol: " + symbol);
		};

	}
}
