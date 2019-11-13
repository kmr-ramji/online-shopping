package com.ramji.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ramji.onlineshopping.exception.ProductNotFoundException;
import com.ramji.shoppingbackend.dao.CategoryDAO;
import com.ramji.shoppingbackend.dao.ProductDAO;
import com.ramji.shoppingbackend.dto.Category;
import com.ramji.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	@Qualifier("categoryDAO")
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
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
	
	
	@RequestMapping(value= {"/show/{id}/product"} )
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if (product == null) {
			throw new ProductNotFoundException();
		}
		
		product.setViews(product.getViews() + 1);
		
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
}
