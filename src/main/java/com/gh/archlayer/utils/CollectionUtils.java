package com.gh.archlayer.utils;

import static java.util.List.copyOf;
import static java.util.List.of;
import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** A utility class for working with collections. */
public class CollectionUtils {
  private static final Object[] EMPTY_ARRAY = new Object[0];

  /**
   * Concatenates two arrays of the same type into one array.
   *
   * <p>If either of the arrays is null, the other array is returned as is. If both arrays are null,
   * an empty array is returned.
   *
   * @param first The first array to be concatenated.
   * @param second The second array to be concatenated.
   * @return The concatenated array.
   */
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

  /**
   * Concatenates two collections of the same type into one collection.
   *
   * <p>If either of the collections is null, the other collection is returned as is. If both
   * collections are null, an empty list is returned.
   *
   * @param first The first collection to be concatenated.
   * @param second The second collection to be concatenated.
   * @return The concatenated collection.
   */
  public static <T> Collection<T> concat(
      final Collection<? extends T> first, final Collection<? extends T> second) {
    if (isNull(first)) {
      if (isNull(second)) {
        return of();
      }
      return copyOf(second);
    }
    if (isNull(second)) {
      return copyOf(first);
    }
    final List<T> result = new ArrayList<>(first.size() + second.size());
    result.addAll(first);
    result.addAll(second);
    return result;
  }

  /**
   * Concatenates two lists of the same type into one list.
   *
   * <p>If either of the lists is null, the other list is returned as is. If both lists are null, an
   * empty list is returned.
   *
   * @param first The first list to be concatenated.
   * @param second The second list to be concatenated.
   * @return The concatenated list.
   */
  public static <T> List<T> concat(final List<? extends T> first, final List<? extends T> second) {
    if (isNull(first)) {
      if (isNull(second)) {
        return of();
      }
      return copyOf(second);
    }
    if (isNull(second)) {
      return copyOf(first);
    }
    final List<T> result = new ArrayList<>(first.size() + second.size());
    result.addAll(first);
    result.addAll(second);
    return result;
  }

  /**
   * Concatenates two sets of the same type into one set.
   *
   * <p>If either of the sets is null, the other set is returned as is. If both sets are null, an
   * empty set is returned.
   *
   * @param first The first set to be concatenated.
   * @param second The second set to be concatenated.
   * @return The concatenated set.
   */
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

  /**
   * Concatenates two maps of the same type into one map.
   *
   * <p>If either of the maps is null, the other map is returned as is. If both maps are null, an
   * empty map is returned.
   *
   * @param first The first map to be concatenated.
   * @param second The second map to be concatenated.
   * @return The concatenated map.
   */
  public static <K, V> Map<K, V> concat(
      final Map<? extends K, ? extends V> first, final Map<? extends K, ? extends V> second) {
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
