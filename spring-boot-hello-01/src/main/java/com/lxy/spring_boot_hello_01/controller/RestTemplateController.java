package com.lxy.spring_boot_hello_01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lxy.spring_boot_hello_01.vo.UserInfoVo;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String BASE_URL = "http://localhost:8080";

	@GetMapping("/get_1_1")
	public String get_1_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_1?name=jack", String.class);
	}
	
	@GetMapping("/get_1_2")
	public ResponseEntity<String> get_1_2() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_1?name=jack", String.class);
		
		return responseEntity;
	}
	
	@GetMapping("/get_1_3")
	public ResponseEntity<String> get_1_3() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_1?name={1}", String.class, "jack");
		
		return responseEntity;
	}
	
	@GetMapping("/get_1_4")
	public ResponseEntity<String> get_1_4() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_1?name={name}", String.class, map);
		
		return responseEntity;
	}
	
	
	@GetMapping("/get_2_1")
	public String get_2_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_2/jack", String.class);
	}
	
	@GetMapping("/get_2_2")
	public ResponseEntity<String> get_2_2() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_2/jack", String.class);
		
		return responseEntity;
	}
	
	
	@GetMapping("/get_3_1")
	public String get_3_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_3?name=jack", String.class);
	}
	
	@GetMapping("/get_3_2")
	public ResponseEntity<String> get_3_2() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_3?name=jack", String.class);
		
		return responseEntity;
	}
	
	
	@GetMapping("/get_4_1")
	public String get_4_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_4?name=jack", String.class);
	}
	
	@GetMapping("/get_4_2")
	public ResponseEntity<String> get_4_2() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_4?name=jack", String.class);
		
		return responseEntity;
	}
	
	@GetMapping("/get_5_1")
	public String get_5_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_5?name=jack", String.class);
	}
	
	@GetMapping("/get_5_2")
	public ResponseEntity<String> get_5_2() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_5?name=jack", String.class);
		
		return responseEntity;
	}
	
	
	/**
	 * RestTemplate get 请求 默认不支持body传输参数，需要做一些调整才能支持，因此下面两个方法会出现异常
	 * 
	 */
	@GetMapping("/get_6_1")
	public String get_6_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_6?name=jack", String.class);
	}
	
	@GetMapping("/get_6_2")
	public ResponseEntity<String> get_6_2() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_6?name=jack", String.class);
		
		return responseEntity;
	}
	
	
	@GetMapping("/get_7_1")
	public UserInfoVo get_7_1() {
		return restTemplate.getForObject(BASE_URL + "/test/get/get_7?name=jack", UserInfoVo.class);
	}
	
	@GetMapping("/get_7_2")
	public UserInfoVo get_7_2() {
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.getForEntity(BASE_URL + "/test/get/get_7?name=jack", UserInfoVo.class);
		
		return responseEntity.getBody();
	}
	
	
	
	@GetMapping("/post_1_1")
	public UserInfoVo post_1_1() {
		
		return restTemplate.postForObject(BASE_URL + "/test/post/post_1?name=jack", null, UserInfoVo.class);
	}
	
	@GetMapping("/post_1_2")
	public UserInfoVo post_1_2() {
		return restTemplate.postForObject(BASE_URL + "/test/post/post_1?name={1}", null, UserInfoVo.class, "jack");
	}
	
	@GetMapping("/post_1_3")
	public UserInfoVo post_1_3() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
		
		return restTemplate.postForObject(BASE_URL + "/test/post/post_1?name={name}", null, UserInfoVo.class, map);
	}
	
	@GetMapping("/post_1_4")
	public UserInfoVo post_1_4() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_1?name=jack", null, UserInfoVo.class);
		
		return responseEntity.getBody();
	}
	
	@GetMapping("/post_1_5")
	public UserInfoVo post_1_5() {
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_1?name={1}", null, UserInfoVo.class, "jack");
		
		return responseEntity.getBody();
	}
	
	@GetMapping("/post_1_6")
	public UserInfoVo post_1_6() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
	    
	    ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_1?name={name}", null, UserInfoVo.class, map);
	    
	    return responseEntity.getBody();
	}
	
	@GetMapping("/post_1_7")
	public UserInfoVo post_1_7() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("name", "jack");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity( BASE_URL + "/test/post/post_1", request , UserInfoVo.class );
		
	    return responseEntity.getBody();
	}
	
	
	@GetMapping("/post_2_1")
	public UserInfoVo post_2_1() {
		
		return restTemplate.postForObject(BASE_URL + "/test/post/post_2?name=jack", null, UserInfoVo.class);
	}
	
	@GetMapping("/post_2_4")
	public UserInfoVo post_2_4() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_2?name=jack", null, UserInfoVo.class);
		
		return responseEntity.getBody();
	}
	
	
	@GetMapping("/post_2_7")
	public UserInfoVo post_2_7() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("name", "jack");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity( BASE_URL + "/test/post/post_2", request , UserInfoVo.class );
		
	    return responseEntity.getBody();
	}
	
	
	@GetMapping("/post_3_1")
	public UserInfoVo post_3_1() {
		
		return restTemplate.postForObject(BASE_URL + "/test/post/post_3?name=jack", null, UserInfoVo.class);
	}
	
	@GetMapping("/post_3_4")
	public UserInfoVo post_3_4() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_3?name=jack", null, UserInfoVo.class);
		
		return responseEntity.getBody();
	}
	
	@GetMapping("/post_3_5")
	public UserInfoVo post_3_5() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
	    
	    ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_3", map, UserInfoVo.class);
	    
	    return responseEntity.getBody();
	}
	
	
	@GetMapping("/post_3_7")
	public UserInfoVo post_3_7() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("name", "jack");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity( BASE_URL + "/test/post/post_3", request , UserInfoVo.class );
		
	    return responseEntity.getBody();
	}
	
	/*
	  * 请求json报文的样例
	 */
	
	
	@GetMapping("/post_4_5")
	public UserInfoVo post_4_5() {
		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");
	    
	    ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity(BASE_URL + "/test/post/post_4", map, UserInfoVo.class);
	    
	    return responseEntity.getBody();
	}
	
	
	@GetMapping("/post_4_7")
	public UserInfoVo post_4_7() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, String> map = new HashMap<>();
	    map.put("name", "jack");

		HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);
		ResponseEntity<UserInfoVo> responseEntity = restTemplate.postForEntity( BASE_URL + "/test/post/post_4", request , UserInfoVo.class );
		
	    return responseEntity.getBody();
	}
	
	
	
}
