package com.mt.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping(value = "/stocks")
	public String stocksPage()
	{
		return "stocks";
	}
	@GetMapping(value = "/orders")
	public String ordesPage()
	{
		return "orders";
	}
}
