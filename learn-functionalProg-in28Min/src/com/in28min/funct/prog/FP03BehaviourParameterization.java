package com.in28min.funct.prog;

import java.util.List;
import java.util.function.Predicate;

public class FP03BehaviourParameterization {
	public static void main(String[] args) {
		List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		// approach1
		Predicate<Integer> predicate1 = x -> x % 2 == 0;
		// approach2
		Predicate<Integer> predicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {	
				return x % 2 == 0;
			}
		};
		Predicate<Integer> predicate3 = x -> x % 2 != 0;
		
		System.out.println("Multiples of 2:");
		filterAndPrint(numberList, predicate1);
		//filterAndPrint(numberList, predicate2);
		
		System.out.println("Multiples of 3:");
		filterAndPrint(numberList, x->x%3==0);
		
		System.out.println("Multiples of 4:");
		filterAndPrint(numberList, x->x%4==0);
		//filterAndPrint(numberList, x->x%4!=0);
		System.out.println("Multiples of 5:");
		filterAndPrint(numberList, x->x%5==0);
		
		System.out.println("Multiples of 6:");
		filterAndPrint(numberList, x->x%6==0);
		
		System.out.println("Multiples of 7:");
		filterAndPrint(numberList, x->x%7==0);
		
	}

	private static void filterAndPrint(List<Integer> numberList, Predicate<Integer> predicate) {
		numberList.stream().filter(predicate).forEach(System.out::println);
	}
}
