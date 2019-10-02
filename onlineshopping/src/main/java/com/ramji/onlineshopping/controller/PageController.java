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
		mav.addObject("greeting", "Welcome to String Web MVC");
		return mav;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		if (greeting == null) {
			greeting = "Hello there";
		}
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("greeting", greeting);
		
		return mav;
	}
}
