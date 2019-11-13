package com.ramji.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ramji.shoppingbackend.dao.CategoryDAO;
import com.ramji.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ramji.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(1);
		assertEquals("Successfully fetched a single category from the table!", "Television", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(1); 
		
		category.setName("TV");
		assertEquals("Successfully Updated a single category in the table!", true, categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully fetched the list of categories from the table!", 1, categoryDAO.getCategoryList().size());
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		//Add
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for televison!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		//Update
		category = categoryDAO.get(2); 
		
		category.setName("TV");
		assertEquals("Successfully Updated a single category in the table!", true, categoryDAO.update(category));
		
		//Delete
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
		
		//List
		assertEquals("Successfully fetched the list of categories from the table!", 1, categoryDAO.getCategoryList().size());
	}
}
