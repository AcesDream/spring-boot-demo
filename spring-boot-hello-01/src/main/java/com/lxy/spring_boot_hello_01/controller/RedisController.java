package com.lxy.spring_boot_hello_01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy.spring_boot_hello_01.service.UserInfoService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/setValue")
	public void setValue() {
		
		
		redisTemplate.opsForValue().set("message", "success");
		
		redisTemplate.opsForValue().set("userInfo", userInfoService.getUserInfoById(1));
		
	}
	
	@GetMapping("/getValue")
	public Map<String, Object> getValue() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		
		data.put("message", redisTemplate.opsForValue().get("message"));
		data.put("userInfo", redisTemplate.opsForValue().get("userInfoList"));
		
		return data;
	}
}
