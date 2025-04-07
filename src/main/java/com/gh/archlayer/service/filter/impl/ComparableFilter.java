package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Operator;

public abstract class ComparableFilter<T extends Comparable<? super T>> extends AbstractFilter<T> {
	public ComparableFilter(final String field, final T value, final Operator operator) {
		super(field, value, operator);
	}

	public static boolean supportOperator(final Operator operator) {
		return switch (operator) {
			case EQUALS, NOT_EQUALS, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL -> true;
			default -> false;
		};
	}
}
