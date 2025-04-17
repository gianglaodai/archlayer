package com.gh.archlayer.service.paging;

/** Enum representing the different directions that can be used in an order. */
public interface Order {
  String ASC_INDICATOR = "+";
  String DESC_INDICATOR = "-";

  /** Enum representing the possible directions of an order. */
  enum Direction {
    ASC,
    DESC
  }

  /**
   * Retrieves the field associated with this order.
   *
   * @return The field as a String.
   */
  String getField();

  /**
   * Retrieves the direction of the order.
   *
   * @return The direction of the order, either ASC or DESC.
   */
  Direction getDirection();
}
