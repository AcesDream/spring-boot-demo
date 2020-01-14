package com.lxy.spring_boot_hello_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String toIndexPage() {
		
		return "index";
	}
}
