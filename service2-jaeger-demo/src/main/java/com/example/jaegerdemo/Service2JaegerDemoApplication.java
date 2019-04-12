package com.example.jaegerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Service2JaegerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Service2JaegerDemoApplication.class, args);
	}

}
