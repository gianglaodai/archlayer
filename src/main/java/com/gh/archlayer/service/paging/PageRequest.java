package com.gh.archlayer.service.paging;

import static java.util.Arrays.stream;
import static java.util.List.of;

import java.util.List;
import java.util.Objects;

public record PageRequest(int firstResult, int maxResults, List<Order> orders) {
  public static final PageRequest DEFAULT = new PageRequest(0, 0, of());
  private static final String SPLITTER = ",";

  public static List<Order> parseOrders(final String raw) {
    if (Objects.isNull(raw) || raw.isBlank()) {
      return of();
    }
    return stream(raw.split(SPLITTER)).map(Order::parse).toList();
  }
}
