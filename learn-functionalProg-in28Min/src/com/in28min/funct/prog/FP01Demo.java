package com.in28min.funct.prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FP01Demo {
	public static void main(String[] args) {

		// to print the elements in list
		List<Integer> numList = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 100);
		// numList.forEach(num->System.out.println(num));
		// numList.stream().forEach(System.out::println);

		// to find the sum of double of even numbers in the list.
		System.out.println(numList.stream().filter(x -> x % 2 == 0).map(x -> x * 2).reduce(0, (x, y) -> x + y));

		// to find the sum of squares of odd numbers in list
		List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(myList.stream().filter(x -> x % 2 == 1).map(x -> x * x).reduce(0, (x, y) -> x + y));

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.forEach(x -> System.out.println(x));

	}
}
