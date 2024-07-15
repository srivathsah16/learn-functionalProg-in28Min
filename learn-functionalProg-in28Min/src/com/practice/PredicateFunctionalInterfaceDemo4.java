package com.practice;

import java.util.function.Predicate;

class CheckForNull implements Predicate<String> {

	@Override
	public boolean test(String t) {
		return t.equalsIgnoreCase("") ? true : false;
	}
}

public class PredicateFunctionalInterfaceDemo4 {
	public static void main(String[] args) {
		String string = "";
		CheckForNull checkForNull = new CheckForNull();
		System.out.println(checkForNull.test(string));
	}
}