package com.gh.archlayer.service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Interface for executing transactions. This interface provides methods to execute various actions
 * within a transaction context.
 */
public interface TransactionExecutor {

  /**
   * Executes a runnable action within a transaction.
   *
   * @param action the action to be executed
   */
  void execute(Runnable action);

  /**
   * Executes a supplier action within a transaction and returns a result.
   *
   * @param action the supplier action to be executed
   * @param <T> the type of the result
   * @return the result of the executed action
   */
  <T> T execute(Supplier<T> action);

  /**
   * Executes a consumer action within a transaction.
   *
   * @param action the consumer action to be executed
   * @param <T> the type of the input to the action
   */
  <T> T execute(Consumer<T> action);

  /**
   * Executes a function action within a transaction and returns a result.
   *
   * @param action the function action to be executed
   * @param <T> the type of the input to the function
   * @param <R> the type of the result
   * @return the result of the executed action
   */
  <T, R> T execute(Function<T, R> action);
}
