package com.venci.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.venci.webservices.business.ProductServiceImpl;
import com.venci.webservices.model.Product;

@WebService(endpointInterface = "com.venci.webservices.ProductCatalogInterface")
public class ProductCatalog implements ProductCatalogInterface {

	ProductServiceImpl productService = new ProductServiceImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.venci.webservices.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {

		return productService.getProductCategories();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.venci.webservices.ProductCatalogInterface#getProducts(java.lang.
	 * String)
	 */
	@Override
	public List<String> getProducts(String category) {

		return productService.getProducts(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.venci.webservices.ProductCatalogInterface#getProductsv2(java.lang.
	 * String)
	 */
	@Override
	public List<Product> getProductsv2(String category) {

		return productService.getProductsv2(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.venci.webservices.ProductCatalogInterface#addProduct(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productService.addProduct(category, product);
	}

}
