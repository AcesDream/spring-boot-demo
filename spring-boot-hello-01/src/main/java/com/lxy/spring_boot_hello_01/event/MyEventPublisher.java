package com.lxy.spring_boot_hello_01.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布者
 * @author lxy
 *
 */
@Component
public class MyEventPublisher {
    @Autowired
    ApplicationContext context;
    
    public void publish(String message) {
    	System.out.println(context.getClass());
        context.publishEvent(new MyEvent(this, message));
    }
}
