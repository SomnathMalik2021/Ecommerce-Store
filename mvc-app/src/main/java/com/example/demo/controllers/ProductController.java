package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@RequestMapping(path="/homepage",method = RequestMethod.GET)
	public String home() {
		System.out.println("home....");
		return "index";
	}
	
}