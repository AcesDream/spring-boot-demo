package com.lxy.spring_boot_hello_01.vo;

public class UserInfoVo {

	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfoVo [name=" + name + ", age=" + age + "]";
	}
	
	
}
