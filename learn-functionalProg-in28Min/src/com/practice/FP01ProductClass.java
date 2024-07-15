package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.Map.entry;

class Product {
	private int id;
	private String name;
	private float price;
	private String category;

	Product(int id, String name, float price, String category) {
		// System.out.println("constructor invoked.");
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{" + id + "," + name + "," + price + "}";
	}
}

public class FP01ProductClass {
	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		int id;
		float price;
		String productArray[] = { "Oppo", "Laptop", "MI", "Apple", "Mac", "Samsung", "Realme", "Dell", "HP", "Redmi",
				"Motorolla", "Bajaj", "Vega" };
		Map<String, String> productsMap = Map.ofEntries(entry("Oppo", "Mobiles"), entry("MI", "Mobiles"),
				entry("Samsung", "Mobiles"), entry("Realme", "Mobiles"), entry("Apple", "Mobiles"),
				entry("Dell", "Laptops"), entry("HP", "Laptops"), entry("Lenovo", "Laptops"),
				entry("MacBook", "Laptops"), entry("Whirlpool", "Appliances"), entry("Bajaj Fan", "Appliances"),
				entry("MicroteckUPS", "Appliances"), entry("LG Fridge", "Appliances"), entry("Hier TV", "Appliances"));
		Random random = new Random();
		Set<Entry<String, String>> productEntrySet = productsMap.entrySet();

		// creating objects of Product class
		for (Map.Entry<String, String> entry : productEntrySet) {
			id = random.nextInt(100);
			price = random.nextFloat(5000, 50000);
			productList.add(new Product(id, entry.getKey(), price, entry.getValue()));
		}

		System.out.println(productList);

		// filter products with price less than 20000
		// Imperative style of programming ie, specifying both HOW TO DO and WHAT TO DO.
		List<Object> filteredProductList = new ArrayList<>();
		for (Product p : productList) {
			if (p.getPrice() < 20000f) {
				filteredProductList.add(p.getName());
			}
		}
		System.out.println("Products with price<20,000 [imperative]" + filteredProductList);

		// Declarative ie, only tell WHAT TO DO.
		System.out.println("Products with price<20,000 [declarative]"
				+ filterOnPriceAndCollect(productList, p -> p.getPrice() < 20000));

		// List of items having price between 15,000 to 20,000
		Predicate<Product> priceBetween15And20K = new Predicate<Product>() {
			@Override
			public boolean test(Product p) {
				return p.getPrice() > 15000 && p.getPrice() < 20000;
			}
		};
		System.out.println(
				"Products with price b/w 15K and 20K" + filterOnPriceAndCollect(productList, priceBetween15And20K));
		System.out.println(
				"Products with price>30,000" + filterOnPriceAndCollect(productList, p -> p.getPrice() > 30000));
		// product with highest price under Laptop category
		System.out.println("Products under Laptop category"
				+ productList.stream().filter(p -> p.getCategory().equalsIgnoreCase("laptops"))
						.map(p -> p.getName() + ":" + p.getPrice()).collect(Collectors.toList()));
		System.out.println("Product with MAX price in Laptop category"
				+ filterOnCategoryAndFindMax(productList, p -> p.getCategory().equalsIgnoreCase("laptops")));
		System.out.println("Product with MIN price in Laptop category"
				+ filterOnCategoryAndFindMin(productList, p -> p.getCategory().equalsIgnoreCase("laptops")));
		System.out.println("All mobiles" + productList.stream().filter(p -> p.getCategory().equalsIgnoreCase("Mobiles"))
				.map(p -> p.getName() + ":" + p.getPrice()).collect(Collectors.toList()));
		System.out.println("Top 3 mobiles having highest price" + productList.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Mobiles"))
				.sorted(Comparator.comparing(Product::getPrice).reversed()).limit(3).collect(Collectors.toList()));
	}

	public static List<String> filterOnPriceAndCollect(List<Product> products, Predicate<Product> pricePredicate) {
		return products.stream().filter(pricePredicate).map(product -> product.getName() + ":" + product.getPrice())
				.collect(Collectors.toList());
	}

	public static Optional<Object> filterOnCategoryAndFindMax(List<Product> products,
			Predicate<Product> categoryPredicate) {
		return products.stream().filter(categoryPredicate).max(Comparator.comparing(Product::getPrice))
				.map(p -> p.getName() + ":" + p.getPrice());
	}

	public static Optional<Object> filterOnCategoryAndFindMin(List<Product> products,
			Predicate<Product> categoryPredicate) {
		return products.stream().filter(categoryPredicate).min(Comparator.comparing(Product::getPrice))
				.map(p -> p.getName() + ":" + p.getPrice());
	}
}
