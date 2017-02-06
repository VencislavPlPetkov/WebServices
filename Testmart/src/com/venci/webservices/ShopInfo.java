package com.venci.webservices;

import javax.jws.WebService;

@WebService
public class ShopInfo {

	public String getShopInfo(String property) {

		String response = "Invalid property";

		if ("shopName".equals(property)) {
			response = "Test Mart";
		} else if ("since".equals(property)) {
			response = "Since 2012";
		}

		return response;

	}

}
