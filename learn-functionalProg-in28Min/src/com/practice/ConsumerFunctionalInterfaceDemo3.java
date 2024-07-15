package com.practice;

@FunctionalInterface
interface Consumer {
	void accept(String name);
}

public class ConsumerFunctionalInterfaceDemo3 {
	public static void main(String[] args) {
		Consumer consumer1 = new Consumer() {
			@Override
			public void accept(String name) {
				System.out.println("Hello " + name);
			}
		};
		
		consumer1.accept("Srivathsa");
		
		Consumer consumer2= (String nameString)->System.out.println("Hi "+nameString);
		consumer2.accept("Prithvi");
	}
}