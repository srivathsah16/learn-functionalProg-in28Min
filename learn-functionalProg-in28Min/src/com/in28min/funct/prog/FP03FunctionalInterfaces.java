package com.in28min.funct.prog;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces {
	public static void main(String[] args) {
		List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
		// when we assign a lamda function to a predicate, something similar to below is
		// done internally:
		// ie, an anonymous inner class (which is implementing
		// the Predicate interface) is created.
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};

		Function<Integer, Integer> SquareMapper = x -> x * x;
		Function<Integer, Integer> SquareMapper2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};

		Consumer<Integer> PrintAction = System.out::println;
		Consumer<Integer> PrintAction2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};

		Supplier<Integer> randomNumberSupplier1 = () -> {
			Random random = new Random();
			return random.nextInt(10, 1000);
		};
		Supplier<Integer> randomNumberSupplier2 = new Supplier<Integer>() {
			@Override
			public Integer get() {
				Random random = new Random();
				return random.nextInt(500);
			}
		};
		System.out.println("randomNumberSupplier1 = "+randomNumberSupplier1.get());
		System.out.println("randomNumberSupplier2 = "+randomNumberSupplier2.get());

		UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * 2;
			}
		};
		System.out.println("unaryOperator = "+unaryOperator.apply(3));

		BiPredicate<Integer, Integer> biPredicate = new BiPredicate<Integer, Integer>() {
			@Override
			public boolean test(Integer t, Integer u) {
				return t > u;
			}
		};
		BiPredicate<Integer, Integer> biPredicate2 = (x,y)->{
			return x>y;
		};
		System.out.println("biPredicate = "+biPredicate.test(33, 4));
		System.out.println("biPredicate2 = "+biPredicate2.test(3, 4));

		BiConsumer<Integer, Integer> biConsumer = new BiConsumer<Integer, Integer>() {
			@Override
			public void accept(Integer t, Integer u) {
				System.out.println("t+u = " + (t + u));
			}
		};
		BiConsumer<Integer, Integer> biConsumer2 = (x, y) -> System.out.println("x+y = " + (x + y));
		biConsumer.accept(3, 4);
		biConsumer2.accept(3, 4);

		BiFunction<Integer, Integer, String> biFunction = new BiFunction<>() {
			@Override
			public String apply(Integer t, Integer u) {
				return t +" + "+ u + " = " + (t + u);
			}
		};
		System.out.println("biFunction = "+biFunction.apply(6, 7));

		// numList.stream().filter(isEvenPredicate).map(SquareMapper).forEach(PrintAction);
		// numList.stream().filter(isEvenPredicate2).map(SquareMapper2).forEach(PrintAction2);
	}
}
