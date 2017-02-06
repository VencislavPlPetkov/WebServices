package com.venci.webservices.business;

import java.util.ArrayList;
import java.util.List;

import com.venci.webservices.model.Product;

public class ProductServiceImpl {

	List<String> bookList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> movieList = new ArrayList<>();

	public ProductServiceImpl() {
		bookList.add("Inferno");
		bookList.add("Harry Potter");
		bookList.add("A Song Of Fire and Ice");

		musicList.add("Random Access Memories");
		musicList.add("Night Visions");
		musicList.add("Unorthodox Jukebox");

		movieList.add("The Matrix");
		movieList.add("Independence Day");
		movieList.add("Star Trek Into Darkness");
	}

	public List<String> getProductCategories() {

		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");

		return categories;

	}

	public List<String> getProducts(String category) {

		switch (category.toLowerCase()) {
		case "books":
			return bookList;
		case "music":
			return musicList;
		case "movies":
			return movieList;
		}
		return null;
	}
	
	public List<Product> getProductsv2(String category) {
		
		List<Product> productList = new ArrayList<>();
		
		productList.add(new Product("Zoro Book", "1234", 9.99));
		productList.add(new Product("Batman", "1235", 5.99));
		productList.add(new Product("C++", "1236", 15.99));
		
		return productList;
	}
	
	
	public boolean addProduct(String category, String product) {
		switch (category.toLowerCase()) {
		case "books":
			bookList.add(product);
			break;
		case "music":
			musicList.add(product);
			break;
		case "movies":
			movieList.add(product);
			break;
		default:
			return false;
		}
		return true;
	}

	

}
