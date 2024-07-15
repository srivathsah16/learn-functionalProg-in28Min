package com.in28min.funct.prog;

import java.util.List;

public class FP01Functional {
	public static void main(String[] args) {
		List<Integer> numberList = List.of(1, 3, 55, 67, 12, 13, 24, 5, 67, 78, 99);
		//printNumbersFunctional(numberList);
		//printEvenNumbersFunctional(numberList);
		printSquaresOfEvenNumbersFunctional(numberList);
	}

	private static void print(int num) {
		System.out.println(num);
	}

	private static boolean isEven(int num) {
		return num % 2 == 0;
	}

	private static void printNumbersFunctional(List<Integer> numList) {
		// We focus on What to do?
		numList.stream().forEach(System.out::println); // Method Reference
	}

	private static void printEvenNumbersFunctional(List<Integer> numList) {
		// We focus on What to do?
		numList.stream()					// Stream is a Sequence of Elements
			.filter(num -> num%2==0)       // Lamda Expression - easier way of writing functions
			.forEach(System.out::println); // Method Reference
		
		//.filter(FP01Functional::isEven)
		//.forEach(FP01Functional::print);
	}
	
	private static void printSquaresOfEvenNumbersFunctional(List<Integer> numberList) {
		numberList.stream()
		.filter(num -> num%2==0)
		.map(num -> num * num)			//mapping expression
		.forEach(System.out::println);
	}
}
