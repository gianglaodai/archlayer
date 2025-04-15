package com.gh.archlayer.utils;

public class Tuples {

  public record Tuple2<T1, T2>(T1 t1, T2 t2) {}

  public record Tuple3<T1, T2, T3>(T1 t1, T2 t2, T3 t3) {}

  public record Tuple4<T1, T2, T3, T4>(T1 t1, T2 t2, T3 t3, T4 t4) {}

  public record Tuple5<T1, T2, T3, T4, T5>(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {}

  public record Tuple6<T1, T2, T3, T4, T5, T6>(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {}

  public record Tuple7<T1, T2, T3, T4, T5, T6, T7>(
      T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {}

  public record Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(
      T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {}

  /**
   * A factory method to create a {@link Tuple2} with two elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @return a tuple with two elements
   */
  public static <T1, T2> Tuple2<T1, T2> of(final T1 t1, final T2 t2) {
    return new Tuple2<>(t1, t2);
  }

  /**
   * A factory method to create a {@link Tuple3} with three elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @param t3 the third element
   * @return a tuple with three elements
   */
  public static <T1, T2, T3> Tuple3<T1, T2, T3> of(final T1 t1, final T2 t2, final T3 t3) {
    return new Tuple3<>(t1, t2, t3);
  }

  /**
   * A factory method to create a {@link Tuple4} with four elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @param t3 the third element
   * @param t4 the fourth element
   * @return a tuple with four elements
   */
  public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(
      final T1 t1, final T2 t2, final T3 t3, final T4 t4) {
    return new Tuple4<>(t1, t2, t3, t4);
  }

  /**
   * A factory method to create a {@link Tuple5} with five elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @param t3 the third element
   * @param t4 the fourth element
   * @param t5 the fifth element
   * @return a tuple with five elements
   */
  public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(
      final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5) {
    return new Tuple5<>(t1, t2, t3, t4, t5);
  }

  /**
   * A factory method to create a {@link Tuple6} with six elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @param t3 the third element
   * @param t4 the fourth element
   * @param t5 the fifth element
   * @param t6 the sixth element
   * @return a tuple with six elements
   */
  public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(
      final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6) {
    return new Tuple6<>(t1, t2, t3, t4, t5, t6);
  }

  /**
   * A factory method to create a {@link Tuple7} with seven elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @param t3 the third element
   * @param t4 the fourth element
   * @param t5 the fifth element
   * @param t6 the sixth element
   * @param t7 the seventh element
   * @return a tuple with six elements
   */
  public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> of(
      final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7) {
    return new Tuple7<>(t1, t2, t3, t4, t5, t6, t7);
  }

  /**
   * A factory method to create a {@link Tuple8} with eight elements.
   *
   * @param t1 the first element
   * @param t2 the second element
   * @param t3 the third element
   * @param t4 the fourth element
   * @param t5 the fifth element
   * @param t6 the sixth element
   * @param t7 the seventh element
   * @param t8 the eighth element
   * @return a tuple with six elements
   */
  public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> of(
      final T1 t1,
      final T2 t2,
      final T3 t3,
      final T4 t4,
      final T5 t5,
      final T6 t6,
      final T7 t7,
      final T8 t8) {
    return new Tuple8<>(t1, t2, t3, t4, t5, t6, t7, t8);
  }
}
