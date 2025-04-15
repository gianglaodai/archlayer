package com.gh.archlayer.utils;

import java.util.function.Consumer;
import java.util.function.Function;

public class Functions {
  /**
   * Creates a function that takes a value, applies a consumer to it, and returns the original
   * value.
   *
   * @param consumer the consumer to apply to the value
   * @return a function that applies the consumer and returns the value
   */
  public static <T> Function<T, T> peek(final Consumer<T> consumer) {
    return t -> {
      consumer.accept(t);
      return t;
    };
  }
}
