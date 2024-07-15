package com.practice;

@FunctionalInterface
interface Calculate {
	int sqaure(int n);
}

public class FunctionalInterfaceDemo2 {
	public static void main(String[] args) {
		int num=3;
		Calculate calc1 = (int n) -> n * n;
		
		int result1 = calc1.sqaure(num);
		System.out.println(result1);
	}
}
