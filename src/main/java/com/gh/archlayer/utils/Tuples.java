package com.gh.archlayer.utils;

public class Tuples {

	public record Tuple2<T1, T2>(T1 t1, T2 t2) {
	}

	public record Tuple3<T1, T2, T3>(T1 t1, T2 t2, T3 t3) {
	}

	public record Tuple4<T1, T2, T3, T4>(T1 t1, T2 t2, T3 t3, T4 t4) {
	}

	public record Tuple5<T1, T2, T3, T4, T5>(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
	}

	public record Tuple6<T1, T2, T3, T4, T5, T6>(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
	}

	public record Tuple7<T1, T2, T3, T4, T5, T6, T7>(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
	}

	public record Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
	}

	public static <T1, T2> Tuple2<T1, T2> of(final T1 t1, final T2 t2) {
		return new Tuple2<>(t1, t2);
	}

	public static <T1, T2, T3> Tuple3<T1, T2, T3> of(final T1 t1, final T2 t2, final T3 t3) {
		return new Tuple3<>(t1, t2, t3);
	}

	public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(final T1 t1, final T2 t2, final T3 t3, final T4 t4) {
		return new Tuple4<>(t1, t2, t3, t4);
	}

	public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5) {
		return new Tuple5<>(t1, t2, t3, t4, t5);
	}

	public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6) {
		return new Tuple6<>(t1, t2, t3, t4, t5, t6);
	}

	public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> of(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7) {
		return new Tuple7<>(t1, t2, t3, t4, t5, t6, t7);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> of(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final T8 t8) {
		return new Tuple8<>(t1, t2, t3, t4, t5, t6, t7, t8);
	}
	
}
