package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

import java.math.BigDecimal;

public class DecimalFilter extends NumberFilter<BigDecimal> {
	public DecimalFilter(final String field, final BigDecimal value, final Operator operator) {
		super(field, value, operator);
	}

	public static boolean supportOperator(final Operator operator) {
		return ComparableFilter.supportOperator(operator);
	}

	public static BigDecimal parseValue(final String rawValue) throws Exception {
		return new BigDecimal(rawValue);
	}

	public static Filter<?> newFilter(final String field, final String rawValue, final Operator operator) {
		return new DecimalFilter(field, new BigDecimal(rawValue), operator);
	}
}
