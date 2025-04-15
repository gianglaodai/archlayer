package com.gh.archlayer.service.paging;

public interface Order {
  String ASC_INDICATOR = "+";
  String DESC_INDICATOR = "-";

  public enum Direction {
    ASC,
    DESC
  }

  String getField();

  Direction getDirection();
}
