package com.lxy.spring_boot_hello_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable String name) {
		return "spring boot say : hello " + name ;
	}
}
