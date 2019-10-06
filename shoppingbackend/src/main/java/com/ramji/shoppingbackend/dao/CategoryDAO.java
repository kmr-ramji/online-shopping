package com.ramji.shoppingbackend.dao;

import java.util.List;

import com.ramji.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> getCategoryList();
	
	Category get(int id);
}
