package com.in28min.funct.prog;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numList = List.of(12, 6, 5, 2, 7);
		List<Integer> doubledList = doubleTheList(numList);
		System.out.println(doubledList);
		//int sum = addListNumbersFunctional(numList);
		//System.out.println(sum);
		//findMaxNoInList(numList);
		//findMinNoInList(numList);
	}

	private static List<Integer> doubleTheList(List<Integer> numList) {
		return numList.stream().map(x->x*x).collect(Collectors.toList());
	}

	private static void findMaxNoInList(List<Integer> numList){
		int max = numList.stream()
						.reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x: y);
		System.out.println("Max number in list= "+ max);
	}
	private static void findMinNoInList(List<Integer> numList){
		int max = numList.stream()
						.reduce(Integer.MAX_VALUE, (x,y)-> x>y ? y: x);
		System.out.println("Min number in list= "+ max);
	}

	private static int add(int a, int b) {
		System.out.println(a + " " + b);
		return a + b;
	}

	private static int addListNumbersFunctional(List<Integer> numList) {
		return numList.stream()
				.reduce(0, (x, y) -> x + y);
		// .reduce(0, FP02Functional::add);
		// .reduce(0, Integer::sum);
	}
}
