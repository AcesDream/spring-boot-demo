package com.lxy.spring_boot_hello_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy.spring_boot_hello_01.event.MyEventPublisher;

@RestController
@RequestMapping("/myEvent")
public class MyEventPublisherController {
	
	@Autowired
	private MyEventPublisher myEventPublisher;

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable("message") String message) {
    	myEventPublisher.publish(message);
    	
    	return "event publish success";
    }
}
