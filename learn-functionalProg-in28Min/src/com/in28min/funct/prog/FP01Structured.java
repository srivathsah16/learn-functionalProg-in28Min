package com.in28min.funct.prog;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> numbList = List.of(1, 3, 55, 67, 12, 13, 24, 5, 67, 78, 99);
		//printAllNumbersInListStructured(numbList);
		//printAllEvenNumbersInListStructured(numbList);
		printSquaresOfEvenNumbersStructured(numbList);
	}

	private static void printAllNumbersInListStructured(List<Integer> numList) {
		// How to loop the list of numbers?
		for (int num : numList) {
			
				System.out.println(num);
			
		}
	}
	private static void printAllEvenNumbersInListStructured(List<Integer> numList) {
		// How to loop the list of numbers?
		for (int num : numList) {
			if (num % 2 == 0) {  //check for even numbers
				System.out.println(num);
			}
		}
	}
	private static void printSquaresOfEvenNumbersStructured(List<Integer> numList) {
		// How to loop the list of numbers?
		for (int num : numList) {
			if (num % 2 == 0) {  //check for even numbers
				System.out.println(num*num);
			}
		}
	}
}
