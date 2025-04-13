package com.gh.archlayer.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;

public class CollectionUtils {
	private static final Object[] EMPTY_ARRAY = new Object[0];

	public static <T> T[] concat(final T[] first, final T[] second) {
		if (isNull(first)) {
			if (isNull(second)) {
				return (T[]) EMPTY_ARRAY;
			}
			return Arrays.copyOf(second, second.length);
		}
		if (isNull(second)) {
			return Arrays.copyOf(first, first.length);
		}

		final T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	public static <T> Collection<T> concat(final Collection<? extends T> first, final Collection<? extends T> second) {
		if (isNull(first)) {
			if (isNull(second)) {
				return List.of();
			}
			return List.copyOf(second);
		}
		if (isNull(second)) {
			return List.copyOf(first);
		}
		final List<T> result = new ArrayList<>(first.size() + second.size());
		result.addAll(first);
		result.addAll(second);
		return result;
	}

	public static <T> List<T> concat(final List<? extends T> first, final List<? extends T> second) {
		if (isNull(first)) {
			if (isNull(second)) {
				return List.of();
			}
			return List.copyOf(second);
		}
		if (isNull(second)) {
			return List.copyOf(first);
		}
		final List<T> result = new ArrayList<>(first.size() + second.size());
		result.addAll(first);
		result.addAll(second);
		return result;
	}

	public static <T> Set<T> concat(final Set<? extends T> first, final Set<? extends T> second) {
		if (isNull(first)) {
			if (isNull(second)) {
				return Set.of();
			}
			return Set.copyOf(second);
		}
		if (isNull(second)) {
			return Set.copyOf(first);
		}
		final Set<T> result = new HashSet<>(first.size() + second.size());
		result.addAll(first);
		result.addAll(second);
		return result;
	}

	public static <K, V> Map<K, V> concat(final Map<? extends K,? extends V> first, final Map<? extends K,? extends V> second) {
		if (isNull(first)) {
			if (isNull(second)) {
				return Map.of();
			}
			return Map.copyOf(second);
		}
		if (isNull(second)) {
			return Map.copyOf(first);
		}
		final Map<K, V> result = new HashMap<>(first.size() + second.size());
		result.putAll(first);
		result.putAll(second);
		return result;
	}
}
