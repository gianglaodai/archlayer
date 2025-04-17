package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Operator;

/** A filter for {@link Number} values. */
public abstract class NumberFilter<T extends Number & Comparable<? super T>>
    extends ComparableFilter<T> {

  /** Constructor. */
  public NumberFilter(final String field, final T value, final Operator operator) {
    super(field, value, operator);
  }
}
