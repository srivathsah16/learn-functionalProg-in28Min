package com.in28min.funct.prog;

import java.util.List;

public class FP02Structured {
	public static void main(String[] args) {
		List<Integer> numbersList=List.of(12,6,5,2,7);
		int sum = addListNumbersStructured(numbersList);
		System.out.println(sum);
	}
	private static int addListNumbersStructured(List<Integer> numbersList) {
		int sum=0;
		for (int num : numbersList) {
			sum+=num;
		}
		return sum;
	}
}
