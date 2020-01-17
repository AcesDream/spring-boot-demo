package com.lxy.spring_boot_hello_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lxy.spring_boot_hello_01.netty.NettyServer;

@SpringBootApplication
public class HelloApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
		
		
		try {
			new NettyServer(12345).start();
			System.out.println("http://localhost:8080/netty-websocket/index");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
