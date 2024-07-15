package com.in28min.funct.prog;

import java.util.List;
import java.util.function.Predicate;

public class FP03BehaviourParameterization2 {
	public static void main(String[] args) {
		List<Integer> numList = List.of(1,2,3,4,5,6,7,8,9,10);
		//Behaviour/ lambda expression/ i.e, Instance of Functional Interface
		Predicate<Integer> isEvenPredicate = n->n%2==0;
		// Parameterizing the behaviour ie, passing the lambda as parameter.
		filterAndPrint(numList,isEvenPredicate);
	}
	
	private static void filterAndPrint(List<Integer> numList,Predicate<Integer> predicate) {
		numList.stream().filter(predicate).forEach(s->System.out.println(s));
	}
}
