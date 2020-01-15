package com.lxy.spring_boot_hello_01.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lxy.spring_boot_hello_01.entity.UserInfo;

@Component
@RabbitListener(queues = "testQueue", containerFactory="simpleRabbitListenerContainerFactory")
public class RabbitMqListener {

	@RabbitHandler
    public void process(UserInfo userInfo) {
		System.out.println("接收到消息，下面开始处理");
		System.out.println(userInfo);
	}
}
