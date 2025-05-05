package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

/** An abstract base class for filters. */
public abstract class AbstractFilter<T> implements Filter<T> {
  private final String field;
  private final T value;
  private final Operator operator;

  /** Constructor. */
  public AbstractFilter(final String field, final Operator operator, final T value) {
    this.field = field;
    this.value = value;
    this.operator = operator;
  }


  @Override
  public String getField() {
    return field;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public Operator getOperator() {
    return operator;
  }
}
