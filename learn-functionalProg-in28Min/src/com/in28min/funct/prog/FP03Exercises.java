package com.in28min.funct.prog;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03Exercises {
	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		BinaryOperator<Integer> AddAccumulator1 = (x, y) -> x + y;

		BinaryOperator<Integer> AddAccumulator2 = Integer::sum;

		BinaryOperator<Integer> AddAccumulator3 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer x, Integer y) {
				return x + y;
			}
		};

		System.out.println(list.stream().reduce(0, AddAccumulator1));
		System.out.println(list.stream().reduce(0, AddAccumulator2));
		System.out.println(list.stream().reduce(0, AddAccumulator3));

		// Parameterizing the Behaviour (ie, lamda expression)
		System.out.println(mapAndCreateNewList(list, x -> x * 2));
		System.out.println(mapAndCreateNewList(list, x -> x * 3));
		System.out.println(mapAndCreateNewList(list, x -> x * x)); 
		System.out.println(mapAndCreateNewList(list, x -> x + "*" + x + "=" + x * x));

	}

	private static List<Object> mapAndCreateNewList(List<Integer> list, Function<Integer, Object> mapper) {
		return list.stream().map(mapper).collect(Collectors.toList());
	}
}
