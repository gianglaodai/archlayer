package com.gh.archlayer.service.filter.impl;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.filter.Operator;

import java.math.BigInteger;

public class IntegerFilter extends NumberFilter<BigInteger> {
	public IntegerFilter(final String field, final BigInteger value, final Operator operator) {
		super(field, value, operator);
	}

	public static boolean supportOperator(final Operator operator) {
		return ComparableFilter.supportOperator(operator);
	}

	public static BigInteger parseValue(final String rawValue) throws Exception {
		return new BigInteger(rawValue);
	}

	public static Filter<?> newFilter(final String field, final String rawValue, final Operator operator) {
		return new IntegerFilter(field, new BigInteger(rawValue), operator);
	}
}
