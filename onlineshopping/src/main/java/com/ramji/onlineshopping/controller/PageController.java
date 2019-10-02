package com.ramji.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("page");
		//mav.addObject("greeting", "Welcome to String Web MVC");
		mav.addObject("title", "Home");
		mav.addObject("userClickHome", true);
		return mav;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView getAbout() {
		ModelAndView mav = new ModelAndView("page");
		//mav.addObject("greeting", "Welcome to String Web MVC");
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout", true);
		return mav;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView getContact() {
		ModelAndView mav = new ModelAndView("page");
		//mav.addObject("greeting", "Welcome to String Web MVC");
		mav.addObject("title", "Contact Us");
		mav.addObject("userClickContact", true);
		return mav;
	}
}
