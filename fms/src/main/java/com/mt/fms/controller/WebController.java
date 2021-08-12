package com.mt.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@GetMapping(value = "/")
	public String homePage()
	{
		return "index";
	}
	@GetMapping(value = "/films")
	public String filmsPage()
	{
		return "films";
	}
	@GetMapping(value = "/directors")
	public String directorsPage()
	{
		return "directors";
	}
}
