package com.lxy.spring_boot_hello_01.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {
		// TODO Auto-generated method stub
		System.out.println("source:" + event.getSource() + "\tmessage:" + event.getMessage());
	}

}
