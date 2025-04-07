package com.gh.archlayer.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {
	/**
	 * Concatenates two collections into a single list.
	 *
	 * @param <T> type of elements in the collections
	 * @param first t1 collection
	 * @param second t2 collection
	 * @return a new list containing elements from both the t1 and t2 collections
	 */
	public static <T> List<T> concat(Collection<? extends T> first, Collection<? extends T> second) {
		List<T> result = new ArrayList<>(first.size() + second.size());
		result.addAll(first);
		result.addAll(second);
		return result;
	}
}
