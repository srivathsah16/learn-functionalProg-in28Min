package com.in28min.funct.prog;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP05PlayingWithIntStream {
	public static void main(String[] args) {
		List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(numList.stream());
		int[] numArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(Arrays.stream(numArray));
		System.out.println(Arrays.stream(numArray).count());
		System.out.println(Arrays.stream(numArray).min());

		System.out.println("range =" + IntStream.range(1, 10).sum());
		System.out.println("range closed =" + IntStream.rangeClosed(1, 10).sum());
		System.out.println(IntStream.iterate(1, n -> n + 6).limit(10).peek(System.out::println).sum());

		// Print first 10 even numbers using peek() and print the sum.
		System.out.println("first 10 even numbers");
		System.out.println(IntStream.iterate(2, n -> n + 2).limit(10).peek(System.out::println).sum());

		// Print first 10 powers of 2 using peek() and print the sum.
		System.out.println("first 10 powers of 2");
		System.out.println(IntStream.iterate(2, n -> n * 2).limit(10).peek(System.out::println).sum());

		// collecting into a list
		System.out.println(IntStream.iterate(2, n -> n * 2).limit(10).boxed().collect(Collectors.toList()));

		// Need for BIG INTEGER
		System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
		// finding factorial of 10
		System.out.println("10! = " + IntStream.rangeClosed(1, 10).reduce(1, (x, y) -> x * y));
		System.out.println("50! = " + IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
		System.out.println("50! = " + LongStream.rangeClosed(1, 50).reduce(1L, (x, y) -> x * y));
		// here comes the need for BIG INTEGER
		System.out.println("50! By using BIG INTEGER = " + LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE, BigInteger::multiply));
	}
}
