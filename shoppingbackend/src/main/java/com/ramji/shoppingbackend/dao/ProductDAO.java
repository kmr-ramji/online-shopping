package com.ramji.shoppingbackend.dao;

import java.util.List;

import com.ramji.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int productId);
	
	List<Product> GetProductList();
	
	boolean add(Product product);
	
	boolean update(Product product);
	
	boolean delete(Product product);
	
	//business method
	List<Product> listActiveProducts();
	
	List<Product> listActiveProductsByCategory(int categoryId);
	
	List<Product> getLatestActiveProducts(int count);
}
