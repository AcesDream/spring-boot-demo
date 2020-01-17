package com.lxy.spring_boot_hello_01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 参考链接：https://blog.csdn.net/moshowgame/article/details/80275084
 * 开启WebSocket支持
 * @author zhengkai.blog.csdn.net
 */
@Configuration  
public class WebSocketConfig {  
	
    @Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    }  
  
} 
