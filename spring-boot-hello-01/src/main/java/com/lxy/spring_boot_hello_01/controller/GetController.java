package com.lxy.spring_boot_hello_01.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxy.spring_boot_hello_01.vo.UserInfoVo;

@Controller
@RequestMapping("/test/get")
public class GetController {

	@RequestMapping(value = "/get_1", method=RequestMethod.GET)
	@ResponseBody
	public String get_1(String name) {
		
		return "get_1" + name;
	}
	
	
	@RequestMapping(value = "/get_2/{name}", method=RequestMethod.GET)
	@ResponseBody
	public String get_2(@PathVariable("name") String name) {
		
		return "get_2" + name;
	}
	
	
	@RequestMapping(value = "/get_3", method=RequestMethod.GET)
	@ResponseBody
	public String get_3(HttpServletRequest request) {
		String name = request.getParameter("name");
		
		return "get_3" + name;
	}
	
	
	@RequestMapping(value = "/get_4", method=RequestMethod.GET)
	@ResponseBody
	public String get_4(@RequestParam Map<String,String> params) {
		
		
		return "get_4" + params.toString();
	}
	
	@RequestMapping(value = "/get_5", method=RequestMethod.GET)
	@ResponseBody
	public String get_5(@ModelAttribute UserInfoVo userInfoVo) {
		
		
		return "get_5" + userInfoVo.toString();
	}
	
	/**
	 * 这种接收方式，需要请求的时候把相关参数设置在body
	 * 
	 * RestTemplate默认不支持
	 * @param userInfoVo
	 * @return
	 */
	@RequestMapping(value = "/get_6", method=RequestMethod.GET)
	@ResponseBody
	public String get_6(@RequestBody UserInfoVo userInfoVo) {
		
		
		return "get_6" + userInfoVo.toString();
	}
	
	
	@RequestMapping(value = "/get_7", method=RequestMethod.GET)
	@ResponseBody
	public UserInfoVo get_7(@ModelAttribute UserInfoVo userInfoVo) {
		userInfoVo.setName(userInfoVo.getName()+"-get_7");
		userInfoVo.setAge(29);
		return userInfoVo;
	}
}
