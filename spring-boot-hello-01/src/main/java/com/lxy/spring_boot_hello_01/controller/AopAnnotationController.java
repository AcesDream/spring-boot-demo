package com.lxy.spring_boot_hello_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy.spring_boot_hello_01.aspect.LogAnnotation;

@RestController
@RequestMapping("/aop/anno")
public class AopAnnotationController {

	@LogAnnotation("sayHello")
	@GetMapping("/sayHello/{name}")
	public String sayHello(@PathVariable String name) {
		
		return "hello " + name;
	}
}
