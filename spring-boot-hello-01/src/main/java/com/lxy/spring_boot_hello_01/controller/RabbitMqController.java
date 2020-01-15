package com.lxy.spring_boot_hello_01.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy.spring_boot_hello_01.entity.UserInfo;
import com.lxy.spring_boot_hello_01.service.UserInfoService;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private @Value("${rabbitmq.exchangeName}") String exchanger;

	private @Value("${rabbitmq.routingKey}") String routingKey;

	@GetMapping("/sendMsg")
	public void sendMsg() {
		UserInfo userInfo = userInfoService.getUserInfoById(1);
		rabbitTemplate.convertAndSend(exchanger, routingKey, userInfo);
	}
}
