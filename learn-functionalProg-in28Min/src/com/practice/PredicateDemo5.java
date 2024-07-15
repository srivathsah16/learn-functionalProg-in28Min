package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo5 {
	public static void main(String[] args) {
		List<String> cityList = Arrays.asList("Bihar", "Assam", "Delhi", "Mysuru", "Bangalore", "Mandya", "Maharashtra",
				"Madhya Pradesh");
		Predicate<String> predicate = (String s) -> s.length() <= 6;
		System.out.println(predicate.test("Bangalore"));

		cityList.stream().filter(predicate).forEach(System.out::println);
	}
}
