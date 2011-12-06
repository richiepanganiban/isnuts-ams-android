package com.ams.isnuts.dao;

import java.util.List;

import com.ams.isnuts.model.Category;

public interface CategoriesDao {
	
	void insertCategory(Category category);
	
	Category getCategory(int id);
	
	List<Category> getAllCategories();

}
