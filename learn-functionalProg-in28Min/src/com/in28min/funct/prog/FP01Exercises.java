package com.in28min.funct.prog;

import java.util.List;

public class FP01Exercises {
	public static void main(String[] args) {
		List<Integer> numberList = List.of(1, 23, 2, 24, 35, 36, 37, 38);
		//printOddNumbers(numberList);
	//	printCubeOfOddNumbers(numberList);

		List<String> courses = List.of("Spring", "Spring Boot", "Microservices","JS", "HTML", "CSS", "API", "AWS", "springJPA", "React","springSecurity");
	//	printCourses(courses);
	//	printCoursesContainingSpring(courses);
	//	printCoursesContainingAtleat4Letters(courses);
		printNoOfCharInCourse(courses);
	}

	private static void printOddNumbers(List<Integer> numberList) {
		numberList.stream()
			.filter(number -> number % 2 == 1)
			.forEach(System.out::println);
	}
	private static void printCubeOfOddNumbers(List<Integer> numberList) {
		numberList.stream()
			.filter(num ->num%2!=0)
			.map(num -> num*num*num)
			.forEach(System.out::println);
	}

	private static void printCourses(List<String> courses) {
		courses.stream()
			.forEach(System.out::println);
	}

	private static void printCoursesContainingSpring(List<String> courses) {
		courses.stream()
			.filter(course -> course.toLowerCase().contains("spring"))
			.forEach(System.out::println);
	}

	private static void printCoursesContainingAtleat4Letters(List<String> courses) {
		courses.stream()
			.filter(course -> course.length() >= 4)
			.forEach(System.out::println);
	}
	private static void printNoOfCharInCourse(List<String> courses) {
		courses.stream()
			.map(course -> course + " "+course.length())
			.forEach(System.out::println);
	}
}
