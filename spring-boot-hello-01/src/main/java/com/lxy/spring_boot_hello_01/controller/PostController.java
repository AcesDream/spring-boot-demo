package com.lxy.spring_boot_hello_01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxy.spring_boot_hello_01.vo.UserInfoVo;

@Controller
@RequestMapping("/test/post")
public class PostController {
	
	
	@RequestMapping(value = "/post_1", method=RequestMethod.POST)
	@ResponseBody
	public UserInfoVo post_1(@RequestParam(value = "name") String name) {
		
		UserInfoVo userInfoVo = new UserInfoVo();
		
		userInfoVo.setName(name+"post_1:form_requestparam");
		userInfoVo.setAge(27);
		return userInfoVo;
	}
	
	@RequestMapping(value = "/post_2", method=RequestMethod.POST)
	@ResponseBody
	public UserInfoVo post_2(HttpServletRequest request) {
		String name = request.getParameter("name");
		UserInfoVo userInfoVo = new UserInfoVo();
		
		userInfoVo.setName(name+"post_2:form_request");
		userInfoVo.setAge(27);
		return userInfoVo;
	}
	
	
	
	@RequestMapping(value = "/post_3", method=RequestMethod.POST)
	@ResponseBody
	public UserInfoVo post_3(@ModelAttribute UserInfoVo userInfoVo) {
		
		userInfoVo.setName(userInfoVo.getName()+"post_3:form_ModelAttribute");
		userInfoVo.setAge(27);
		return userInfoVo;
	}
	
	/**
	  * 接收json报文
	 * @param userInfoVo
	 * @return
	 */
	@RequestMapping(value = "/post_4", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserInfoVo post_4(@RequestBody UserInfoVo userInfoVo) {
		
		userInfoVo.setName(userInfoVo.getName()+"post_4:form_RequestBody");
		userInfoVo.setAge(27);
		return userInfoVo;
	}
}
