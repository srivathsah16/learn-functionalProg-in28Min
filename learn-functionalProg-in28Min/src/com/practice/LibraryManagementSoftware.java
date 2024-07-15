package com.practice;

import java.util.ArrayList;
import java.util.function.Predicate;

class Book {
	// private member variables
	private String name;
	private String category;
	private String author;
	private int edition;

	// constructor
	public Book(String name, String category, String author, int edition) {
		this.name = name;
		this.category = category;
		this.author = author;
		this.edition = edition;
	}

	// public getters and setters
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	// toString
	public String toString() {
		return "name = " + name + ", category=" + category + ", author=" + author;
	}
}

public class LibraryManagementSoftware {
	public static void main(String[] args) {
		ArrayList<Book> booksList = new ArrayList<>();
		booksList.add(new Book("Electronics made easy", "Engineering", "Vittal", 2));
		booksList.add(new Book("Cool Electronics", "Engineering", "Ranga", 2));
		booksList.add(new Book("Learn Electronics in simple steps", "Engineering", "Venki", 2));
		booksList.add(new Book("Social History", "History", "Ranga Kumar", 2));
		booksList.add(new Book("Science Matters", "Engineering", "Ranga", 2));

		Predicate<Book> isElectronicsBook = book -> book.getName().toLowerCase().contains("electronics");
		Predicate<Book> isNotElectronicsBook = book -> !book.getName().toLowerCase().contains("electronics");
		filterAndDisplay(booksList, isElectronicsBook);
		filterAndDisplay(booksList, isNotElectronicsBook);
	}

	private static void filterAndDisplay(ArrayList<Book> books, Predicate<? super Book> predicate) {
		books.stream().filter(predicate).forEach(System.out::println);
	}

}
