package com.lxy.spring_boot_hello_01.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/netty/websocket")
public class NettyWebSocketController {
	@GetMapping("/index")
	public ModelAndView  index(){
		ModelAndView mav=new ModelAndView("socket");
		mav.addObject("uid", String.format("%06d", new Random(1).nextInt(10000)));
		return mav;
	}
}
