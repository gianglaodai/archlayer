package com.gh.archlayer.service.paging;

/** Enum representing the different directions that can be used in an order. */
public record Order(String field, Direction direction) {
  public static final char ASC_INDICATOR = '+';
  public static final char DESC_INDICATOR = '-';

  /** Enum representing the possible directions of an order. */
  public enum Direction {
    ASC,
    DESC
  }

  /**
   * Retrieves the field associated with this order.
   *
   * @return The field as a String.
   */
  public String getField() {
    return field;
  }

  /**
   * Retrieves the direction of the order.
   *
   * @return The direction of the order, either ASC or DESC.
   */
  public Direction getDirection() {
    return direction;
  }

  public static Order parse(final String raw) {
    final char orderIndicator = raw.charAt(0);
    return switch (orderIndicator) {
      case DESC_INDICATOR -> new Order(raw.substring(1), Direction.DESC);
      case ASC_INDICATOR -> new Order(raw.substring(1), Direction.ASC);
      default -> new Order(raw, Direction.ASC);
    };
  }
}
