package com.lxy.spring_boot_hello_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public UserInfo getUserInfoById(int userInfoId) {
		
		return userInfoMapper.selectByPrimaryKey(userInfoId);
	}
	
	public List<UserInfo> getUserInfoByPage() {
		return userInfoMapper.selectAll();
	}
	
	
	/**
	 * 没有 @Transactional
	 * 出现异常不会回滚
	 */
	public void saveUserInfoNoTransactional() {
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setUserName("user01");
		userInfo1.setUserAge(22);
		userInfoMapper.insert(userInfo1);
		
		System.out.println(1/0);
		
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setUserName("user02");
		userInfo2.setUserAge(23);
		userInfoMapper.insert(userInfo2);
		
	}
	

	/**
	 * 有 @Transactional
	 * 出现异常会回滚
	 */
	@Transactional
	public void saveUserInfoWithTransactional() {
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setUserName("user01WithT");
		userInfo1.setUserAge(22);
		userInfoMapper.insert(userInfo1);
		
		System.out.println(1/0);
		
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setUserName("user02WithT");
		userInfo2.setUserAge(23);
		userInfoMapper.insert(userInfo2);
	}
}
