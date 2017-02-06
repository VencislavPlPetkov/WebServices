package com.venci.webservices;

import java.util.List;

import javax.jws.WebService;

import com.venci.webservices.model.Product;

@WebService
public interface ProductCatalogInterface {

	List<String> getProductCategories();

	List<String> getProducts(String category);

	List<Product> getProductsv2(String category);

	boolean addProduct(String category, String product);

}