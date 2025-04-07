package com.gh.archlayer.service.paging;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.List.of;
import static org.apache.commons.lang3.StringUtils.isBlank;

public record PageRequest(int firstResult, int maxResults, List<Order> orders) {
	public static final PageRequest DEFAULT = new PageRequest(0, 0, of());
	private static final String SPLITTER = ",";

    /**
     * Parses a string representation of orders into a list of {@link Order} objects.
     * <p>
     * The input string is expected to be a comma-separated list of order indicators.
     * Each order indicator is processed to create an {@link Order} object using the
     * {@link Order#parse(String)} method.
     * <p>
     * If the input string is blank, an empty list is returned.
     *
     * @param raw the raw string representation of orders
     * @return a list of parsed {@link Order} objects
     */
	public static List<Order> parseOrders(final String raw) {
		if (isBlank(raw)) {
			return of();
		}
		return stream(raw.split(SPLITTER)).map(Order::parse).toList();
	}
}
