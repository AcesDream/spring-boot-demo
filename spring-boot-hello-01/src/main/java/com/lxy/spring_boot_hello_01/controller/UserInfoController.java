package com.lxy.spring_boot_hello_01.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy.spring_boot_hello_01.entity.UserInfo;
import com.lxy.spring_boot_hello_01.service.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/getAllUserInfo")
	public List<UserInfo> getAllUserInfo() {
		return userInfoService.getAllUser();
	}
	
	@PostMapping("/saveUserInfo")
	public Map<String, Object> saveUserInfo(@RequestBody UserInfo userInfo) {
		Map<String, Object> result = new HashMap<>();
		
		if(userInfo.getId() == null) {
			userInfo.setCreateTime(new Date());
			
			userInfoService.saveUserInfo(userInfo);
		} else {
			userInfo.setUpdateTime(new Date());
			userInfoService.updateUserInfo(userInfo);
		}
		
		
		result.put("code", 0);
		result.put("msg", "成功");
		return result;
	}
	
	@GetMapping("/userInfo/{id}")
	public UserInfo getUserInfoById(@PathVariable("id") int userInfoId) {
		return userInfoService.getUserInfoById(userInfoId);
	}
}
