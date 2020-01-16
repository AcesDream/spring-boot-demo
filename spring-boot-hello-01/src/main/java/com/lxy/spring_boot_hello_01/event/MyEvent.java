package com.lxy.spring_boot_hello_01.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author lxy
 *
 */
public class MyEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public MyEvent(Object source, String message) {
		super(source);
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
