package com.in28min.funct.prog;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Student {
	private String name;
	private int rollNo;
	private int age;
	private Address address;
	private String branch;

	public Student(String name, int rollNo, int age, String branch, Address address) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
		this.address = address;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		// System.out.println("toString invoked in STUDENT class");
		// return "Student [name=" + name + ", rollNo=" + rollNo + ", age=" + age + ",
		// address=" + address + "]";
		return "[" + name + " : " + rollNo + " : " + age + " : " + address + "]";
	}

}

class Address {
	private int streetNo;
	private String city, state, country;

	public Address(int street, String city, String state, String country) {
		super();
		this.streetNo = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getStreet() {
		return streetNo;
	}

	public void setStreet(int street) {
		this.streetNo = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		// System.out.println("toString invoked in ADDRESS class");
		// return "Address [street=" + streetNo + ", city=" + city + ", state=" + state
		// + ", country=" + country + "]";
		return "[" + city + " : " + state + " : " + country + "]";
	}
}

public class FP04StudentCustomClass {
	public static void main(String[] args) {
		Address address1 = new Address(7, "Mysuru", "Karnataka", "India");
		Student student1 = new Student("Ram", 1, 16, "EC", address1);
		// System.out.println(student1);
		Student student2 = new Student("Lakshman", 2, 15, "EC", new Address(7, "Mysuru", "Karnataka", "India"));
		// System.out.println(student2.getAddress());

		List<Student> studentsList = List.of(
				new Student("Ram", 1, 21, "EC", new Address(7, "Mysuru", "Karnataka", "India")),
				new Student("Lakshman", 2, 23, "EC", new Address(7, "Mysuru", "Karnataka", "India")),
				new Student("Vijay", 3, 22, "EE", new Address(7, "Mysuru", "Karnataka", "India")),
				new Student("Prithvi", 4, 24, "ME", new Address(7, "Bangalore", "Karnataka", "India")),
				new Student("Mahati", 5, 25, "CS", new Address(7, "Bangalore", "Karnataka", "India")),
				new Student("Mahima", 6, 23, "CS", new Address(7, "Bangalore", "Karnataka", "India")),
				new Student("Shekar", 7, 21, "IS", new Address(7, "Chennai", "TamilNadu", "India")),
				new Student("Srividhya", 8, 24, "EE", new Address(7, "Chennai", "TamilNadu", "India")),
				new Student("Harish", 9, 23, "EC", new Address(7, "Chennai", "TamilNadu", "India")),
				new Student("Poornima", 10, 22, "ME", new Address(7, "Mysuru", "Karnataka", "India")),
				new Student("Riya", 11, 24, "CS", new Address(7, "Mysuru", "Karnataka", "India")),
				new Student("Abhishek", 12, 25, "AU", new Address(7, "Pune", "Maharashtra", "India")),
				new Student("Amulya", 13, 24, "CV", new Address(7, "Pune", "Maharashtra", "India")),
				new Student("Kusuma", 14, 21, "CV", new Address(7, "Pune", "Maharashtra", "India")),
				new Student("Manisha", 15, 23, "EI", new Address(7, "Pune", "Maharashtra", "India")));
		
		// print names of all students from CS dept.
		Predicate<Student> csBranchPredicate = student -> student.getBranch().equalsIgnoreCase("CS");
		System.out.println("students from CS dept" + getStudentNamesInSpecificBranch(studentsList, csBranchPredicate));
		// print names of all students from EC dept.
		Predicate<Student> ecBranchPredicate = student -> student.getBranch().equalsIgnoreCase("EC");
		System.out.println("students from EC dept" + getStudentNamesInSpecificBranch(studentsList, ecBranchPredicate));
		// print names of all students from Mysuru.
		Predicate<Student> mysuruCityPredicate = student -> student.getAddress().getCity().equalsIgnoreCase("Mysuru");
		System.out.println("students from Mysuru" + getStudentNamesFromCity(studentsList, mysuruCityPredicate));
		
		// sort students list based on names ascending order
		System.out.println(studentsList.stream()
				.sorted(Comparator.comparing(Student::getName))
				.map(s->s.getName())
				.collect(Collectors.toList()));
		
		// sort students list based on names ascending order
		System.out.println(studentsList.stream()
				.sorted(Comparator.comparing(Student::getName).reversed())
				.map(s->s.getName())
				.collect(Collectors.toList()));
		// print students names with roll num from 5 to 10.
		System.out.println(studentsList.stream()
			.sorted(Comparator.comparing(Student::getRollNo))
			.skip(4)
			.limit(6)
			.map(student->student.getName() +" : "+student.getRollNo())
			.collect(Collectors.toList()));	

	}

	private static List<String> getStudentNamesInSpecificBranch(List<Student> studentsList,
			Predicate<Student> branchPredicate) {
		return studentsList.stream().filter(branchPredicate).map(student -> student.getName())
				.collect(Collectors.toList());
	}

	private static List<String> getStudentNamesFromCity(List<Student> list, Predicate<Student> cityPredicate) {
		return list.stream().filter(cityPredicate).map(student -> student.getName()).collect(Collectors.toList());
	}

}
