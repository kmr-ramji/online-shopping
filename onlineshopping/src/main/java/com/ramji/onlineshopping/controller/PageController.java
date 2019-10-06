package com.ramji.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ramji.shoppingbackend.dao.CategoryDAO;
import com.ramji.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
		//passing the list of categories
		mav.addObject("categories", categoryDAO.getCategoryList());
		mav.addObject("userClickHome", true);
		return mav;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView getAbout() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout", true);
		return mav;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView getContact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Contact Us");
		mav.addObject("userClickContact", true);
		return mav;
	}
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "All Products");
		mav.addObject("categories", categoryDAO.getCategoryList());
		mav.addObject("userClickAllProducts", true);
		return mav;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");
		
		Category category = null;
		category = categoryDAO.get(id);
		
		mav.addObject("title", category.getName());
		mav.addObject("categories", categoryDAO.getCategoryList());
		mav.addObject("category", category);
		mav.addObject("userClickCategoryProduct", true);
		return mav;
	}
}
