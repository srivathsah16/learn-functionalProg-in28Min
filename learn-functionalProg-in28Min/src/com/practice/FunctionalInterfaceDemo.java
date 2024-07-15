package com.practice;

@FunctionalInterface
interface Animal{
	void sound();
}

public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		Animal cow = new Animal() {
			@Override
			public void sound() {
				System.out.println("Ambaa... ambbaaa...");
			}
		};
		cow.sound();
		
		Animal dog = ()-> System.out.println("Boww bowwww....");
		dog.sound();
	}
}
