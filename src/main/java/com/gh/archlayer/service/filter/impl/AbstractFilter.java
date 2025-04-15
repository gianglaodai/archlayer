package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

public abstract class AbstractFilter<T> implements Filter<T> {
  private final String field;
  private final T value;
  private final Operator operator;

  public AbstractFilter(final String field, final T value, final Operator operator) {
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
