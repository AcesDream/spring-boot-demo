package com.lxy.spring_boot_hello_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.spring_boot_hello_01.entity.UserInfo;
import com.lxy.spring_boot_hello_01.mapper.UserInfoMapper;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<UserInfo> getAllUser() {
		return userInfoMapper.selectAll();
	}
	
	public void saveUserInfo(UserInfo userInfo) {
		userInfoMapper.saveUserInfo(userInfo);
	}
	
	public void updateUserInfo(UserInfo userInfo) {
		userInfoMapper.updateUserInfo(userInfo);
	}
}
