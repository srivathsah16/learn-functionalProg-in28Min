package com.practice;

import java.util.Arrays;
import java.util.List;

public class FPPractice01 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream().forEach(s->System.out.print(s));
		System.out.println();
		sumOfDoubleOfEvenNumbersImperative(list);
		sumOfDoubleOfEvenNumbersDeclarative(list);
	}

	private static void sumOfDoubleOfEvenNumbersImperative(List<Integer> list) {
		int sum=0;
		for(int n:list) {
			if(n%2==0) {
				sum+= 2*n;
			}
		}
		System.out.println(sum);
	}
	private static void sumOfDoubleOfEvenNumbersDeclarative(List<Integer> list) {
		System.out.println(list.stream().filter(n->n%2==0).mapToInt(n->n*2).sum());
	}

}
