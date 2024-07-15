package com.in28min.funct.prog;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP02Exercises {
	public static void main(String[] args) {
		
		List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// => find sum Of Squares Of Odd numbers in the list
		// sumOfSquaresOfOddApproach1(myList);
		sumOfSquaresOfOddApproach2(myList);
		
		// => find sum Of Cubes Of Even numbers in the list
		// sumOfCubesOfEvenApproach1(myList);
		sumOfCubesOfEvenApproach2(myList);
		
		// => find sum Of odd numbers in the list
		sumOfOdds(myList);
		
		// =>create a new list with even numbers filtered in current list
		System.out.println(createListWithEvenNumbers(myList));

		List<String> courses = List.of("Spring", "Spring Boot", "Microservices", "JS", "HTML", "CSS", "API", "AWS",
				"springJPA", "React", "springSecurity");
		System.out.println("createListWitLengthOfCourseTitle " + createListWitLengthOfCourseTitle(courses));
		findLengthOfCourseTitles(courses);
		
		// =>sort Elements in the list based on length
		System.out.println("sortByLengthOfCourseTitle " + sortByLengthOfCourseTitle(courses));

		List<String> duplicateCourses = List.of("Spring", "Spring", "Spring Boot", "Spring Boot", "Spring Boot",
				"Microservices", "JS", "JS", "JS", "JS", "HTML", "CSS", "API", "AWS", "springJPA", "springJPA",
				"springJPA", "React", "React", "React", "React", "springSecurity");
		// =>sort Distinct Elements in the list
		System.out.println("sortDistinctElements " + sortDistinctElements(duplicateCourses));
	}

	private static List<String> sortDistinctElements(List<String> duplicateCourses) {
		return duplicateCourses.stream().distinct().sorted().collect(Collectors.toList());
	}

	private static List<String> sortByLengthOfCourseTitle(List<String> courses) {
		return courses.stream().sorted(Comparator.comparing(str -> str.length())).collect(Collectors.toList());
	}

	private static List<Integer> createListWithEvenNumbers(List<Integer> myList) {
		return myList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
	}

	private static List<Integer> createListWitLengthOfCourseTitle(List<String> courses) {
		return courses.stream().map(course -> course.length()).collect(Collectors.toList());
	}

	private static void findLengthOfCourseTitles(List<String> courses) {
		courses.stream().map(course -> course + " " + course.length()).forEach(System.out::println);
	}

	private static int add(int x, int y) {
		System.out.println("x=" + x + " y=" + y);
		return x + y;
	}

	private static int findSquare(int x) {
		return x * x;
	}

	private static int findCube(int n) {
		return n * n * n;
	}

	private static Boolean checkOdd(int n) {
		return n % 2 == 1;
	}

	private static Boolean checkEven(int n) {
		return n % 2 == 0;
	}

	private static void sumOfSquaresOfOddApproach1(List<Integer> myList) {
		System.out.println(myList.stream().filter(FP02Exercises::checkOdd).map(FP02Exercises::findSquare).reduce(0,
				FP02Exercises::add));
	}

	private static void sumOfSquaresOfOddApproach2(List<Integer> myList) {
		System.out.println(myList.stream().filter(x -> x % 2 == 1).map(x -> x * x).reduce(0, (x, y) -> x + y));
	}

	private static void sumOfCubesOfEvenApproach1(List<Integer> myList) {
		System.out.println(myList.stream().filter(FP02Exercises::checkEven).map(FP02Exercises::findCube).reduce(0,
				FP02Exercises::add));
	}

	private static void sumOfCubesOfEvenApproach2(List<Integer> myList) {
		System.out.println(myList.stream().filter(x -> x % 2 == 0).map(x -> x * x * x).reduce(0, (x, y) -> x + y));
	}

	private static void sumOfOdds(List<Integer> myList) {
		System.out.println(myList.stream().filter(x -> x % 2 == 1).reduce(0, (x, y) -> x + y));
	}
}
