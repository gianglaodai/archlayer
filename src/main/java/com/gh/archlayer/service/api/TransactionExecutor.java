package com.gh.archlayer.service.api;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface TransactionExecutor {

  void execute(Runnable action);

  <T> T execute(Supplier<T> action);

  <T> void execute(Consumer<T> action, T t);

  <T, R> R execute(Function<T, R> action, T t);
}
