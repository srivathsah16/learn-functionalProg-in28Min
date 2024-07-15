package com.in28min.funct.prog;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int rating;
	private int noOfStudents;

	public Course(String name, String category, int rating, int noOfStudents) {
		this.name = name;
		this.category = category;
		this.rating = rating;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
//		return "[name = " + name + ", category = " + category + ", rating = " + rating + ", noOfStudents = "
//				+ noOfStudents+"]";
		return name +":" + rating+":"+noOfStudents;
	}

}

public class FP04CustomClass {
	public static void main(String[] args) {
		Course course1 = new Course("Spring", "Framework", 98, 2000);
		// System.out.println(course1);
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 204),
				new Course("Spring JPA", "Framework", 96, 300), 
				new Course("Spring Boot", "Framework", 97, 4200),
				new Course("Spring Security", "Framework", 94, 447),
				new Course("FullStack", "Framework", 96, 2000),
				new Course("React", "Frontend", 98, 2500), 
				new Course("Angular", "Frontend", 91, 2500),
				new Course("AWS", "Cloud", 98, 250), 
				new Course("Azure", "Cloud", 94, 3400),
				new Course("Docker", "Cloud", 95, 500));
		
		// allMatch, noneMatch, anyMatch
		Predicate<Course> ratingGreaterThan90Predicate = course -> course.getRating()>90;
		Predicate<Course> ratingLessThan70Predicate = course -> course.getRating()<70;
		Predicate<Course> studentsLessThan1000Predicate = course->course.getNoOfStudents()<1000;
		Predicate<Course> studentsGreaterThan4000Predicate = course->course.getNoOfStudents()>4000;
		Consumer<Course> printCourseConsumer = course ->System.out.println(course);
		
 		System.out.println(courses.stream().allMatch(ratingGreaterThan90Predicate));
		System.out.println(courses.stream().noneMatch(ratingGreaterThan90Predicate));
		System.out.println(courses.stream().noneMatch(ratingLessThan70Predicate));
		System.out.println(courses.stream().anyMatch(ratingLessThan70Predicate));
		System.out.println(courses.stream().anyMatch(ratingGreaterThan90Predicate));
		
		//print all the courses which has less than 1000 students
		System.out.println("Courses with students less than 1000:");
		courses.stream().filter(studentsLessThan1000Predicate).forEach(printCourseConsumer);
		System.out.println("Courses with students greater than 4000:");
		courses.stream().filter(studentsGreaterThan4000Predicate).forEach(printCourseConsumer);
		System.out.println("No of Courses under Framework category:");
		System.out.println(courses.stream().filter(c->c.getCategory().equalsIgnoreCase("Framework")).count());
		System.out.println("Print Courses under Framework category:");
		courses.stream().filter(c->c.getCategory().equalsIgnoreCase("Framework")).forEach(printCourseConsumer);
		System.out.println("Courses under Frontend category:");
		courses.stream().filter(c->c.getCategory().equalsIgnoreCase("frontend")).forEach(printCourseConsumer);
		System.out.println("Courses having Rating greater than 95:");
		courses.stream().filter(c->c.getRating()>95).forEach(printCourseConsumer);
		
		Comparator<Course> comparingByNoOfStudentsIncreasing= Comparator.comparingInt(Course::getNoOfStudents);
		System.out.println("<-------------Courses sorted with no of students in Increasing order  --------->");
		System.out.println(courses.stream()
			.sorted(comparingByNoOfStudentsIncreasing)
			.collect(Collectors.toList()));
		
		Comparator<Course> comparingByNoOfStudentsDecreasing= Comparator.comparingInt(Course::getNoOfStudents).reversed();
		System.out.println("<-------------Courses sorted with no of students in decreasing order --------->");
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsDecreasing)
				.collect(Collectors.toList()));
		
		Comparator<Course> comparingByNoOfStudentsAndRating = 
				Comparator
				.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getRating)
				.reversed();
		System.out.println("<-------------Courses sorted with no of students and rating reversed --------->");
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsAndRating)
				.collect(Collectors.toList()));
		
		//System.out.println("<---Courses sorted with no of students and rating reversed and LIMIT to 5--------->");
		
		// ************  SKIP, LIMIT, TAKE WHILE, DROP WHILE **************
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsAndRating)
				.limit(5)
				.collect(Collectors.toList()));
		
		//System.out.println("<---Courses sorted with no of students and rating reversed,SKIP 3 and LIMIT to 3--------->");
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsAndRating)
				.skip(3)
				.limit(3)
				.collect(Collectors.toList()));
		
		System.out.println(courses);
		//[Spring:98:204, Spring JPA:96:300, Spring Boot:97:4200, Spring Security:94:447, FullStack:96:2000, React:98:2500, Angular:97:2500, AWS:98:250, Azure:94:3400, Docker:95:500]
		
		System.out.println(courses.stream()
			.takeWhile(course ->course.getRating()>95)
			.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.dropWhile(course ->course.getRating()>95)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsAndRating)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.max(comparingByNoOfStudentsAndRating));
		System.out.println(courses.stream()
				.min(comparingByNoOfStudentsAndRating));
		//Optional[Spring Boot:97:4200]
		
		System.out.println(courses.stream()
				.filter(course->course.getRating()<92)
				.findFirst());
		// to count total no of students enrolled in courses having rating >96.
		System.out.println(courses.stream()
		.filter(course->course.getRating()>96)
		.mapToInt(course -> course.getNoOfStudents())
		.sum());
		
		System.out.println(courses.stream()
				.filter(course->course.getRating()>96)
				.mapToDouble(course -> course.getNoOfStudents())
				.count());
		
		courses.stream()
				.filter(course->course.getRating()>96)
				.mapToDouble(course -> course.getNoOfStudents())
				.forEach(c->System.out.println(c));
		
		System.out.println(courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory)));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
	}
}
