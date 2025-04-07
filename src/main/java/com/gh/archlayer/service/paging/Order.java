package com.gh.archlayer.service.paging;

public record Order(String field, Direction direction) {
	public enum Direction {
		ASC, DESC
	}

	private static final char ASC_INDICATOR = '+';
	private static final char DESC_INDICATOR = '-';

	/**
	 * Parses a given string into an {@link Order} instance.
	 * The string format is expected to be either
	 * <code>&lt;field&gt;</code> or <code>&lt;indicator&gt;&lt;field&gt;</code>,
	 * where <code>&lt;indicator&gt;</code> is either {@link #ASC_INDICATOR} or
	 * {@link #DESC_INDICATOR}. If the indicator is not provided, the direction
	 * defaults to ascending.
	 *
	 * @param raw the raw string to be parsed
	 * @return the parsed order
	 */
	public static Order parse(final String raw) {
		final char orderIndicator = raw.charAt(0);
		return switch (orderIndicator) {
			case DESC_INDICATOR -> new Order(raw.substring(1), Direction.DESC);
			case ASC_INDICATOR -> new Order(raw.substring(1), Direction.ASC);
			default -> new Order(raw, Direction.ASC);
		};
	}
}
