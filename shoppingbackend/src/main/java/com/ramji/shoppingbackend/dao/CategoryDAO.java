package com.ramji.shoppingbackend.dao;

import java.util.List;

import com.ramji.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

	List<Category> getCategoryList();
	
	Category get(int id);
}
