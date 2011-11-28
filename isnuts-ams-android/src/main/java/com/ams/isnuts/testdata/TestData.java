package com.ams.isnuts.testdata;

import java.util.ArrayList;
import java.util.List;

import com.ams.isnuts.model.Category;
import com.ams.isnuts.model.ServiceApplication;

public class TestData {
	
	static {
		initServiceApplication();
		initCategories();
	}
	
	public static ServiceApplication serviceApplication;
	
	public static List<Category> categories;

	private static void initServiceApplication() {
		serviceApplication = new ServiceApplication();
		serviceApplication.setServiceApplicationId(1);
		serviceApplication.setTitle("unlitxt20");
		serviceApplication.setDescription("Twenty pesos lang, 1 day unli ka na!");
		serviceApplication.setServiceType("TEXT");
		serviceApplication.setServiceNumber("8888");
		serviceApplication.setActivePromo(true);
		serviceApplication.setAppendMobileToServiceNumber(false);
		List<Category> categories = new ArrayList<Category>();
		
		Category unliPromos = new Category();
		unliPromos.setId(1);
		unliPromos.setName("Unli Promos");
		
		Category callAndTextServices = new Category();
		callAndTextServices.setId(2);
		callAndTextServices.setName("Call and Text Services");
		categories.add(unliPromos);
		categories.add(callAndTextServices);
		
		serviceApplication.setCategories(categories);
	}

	private static void initCategories() {
		categories = new ArrayList<Category>();
		
		Category unliPromos = new Category();
		unliPromos.setId(1);
		unliPromos.setName("Unli Promos");
		
		Category callAndTextServices = new Category();
		callAndTextServices.setId(2);
		callAndTextServices.setName("Call and Text Services");
		
		Category news = new Category();
		news.setId(3);
		news.setName("News");
		
		categories.add(unliPromos);
		categories.add(callAndTextServices);
		categories.add(news);
	}
	
	
}