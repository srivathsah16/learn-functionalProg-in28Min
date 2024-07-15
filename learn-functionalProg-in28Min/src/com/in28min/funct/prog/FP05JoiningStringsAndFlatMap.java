package com.in28min.funct.prog;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FP05JoiningStringsAndFlatMap {
	public static void main(String[] args) {

		String[] split = "Spring is a Java Framework.".split(" ");
		System.out.println(Arrays.toString(split));
		String[] strArray = { "Spring", "Spring Boot", "Microservices", "JS", "HTML", "CSS", "API", "AWS",
				"Spring JPA" };
		// Looping using ITERATOR
		System.out.println("Using Iterator in WHILE LOOP");
		Iterator<String> itr = Arrays.asList(strArray).iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("Using Iterator in FOR LOOP");
		for (Iterator<String> it = Arrays.asList(strArray).iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

		List<String> coursesList = List.of("Spring", "Spring Boot", "Microservices", "JS", "HTML", "CSS", "API", "AWS",
				"Spring JPA", "React", "Docker", "Azure", "GCP", "BlockChain", "Cyber Security", "Spring Security");

		System.out.println(coursesList.stream().collect(Collectors.joining(",")));
	}
}
