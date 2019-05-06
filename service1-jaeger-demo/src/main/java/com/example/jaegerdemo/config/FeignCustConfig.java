package com.example.jaegerdemo.config;

import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 打印feignclient调用接口的日志
 */
@Configuration
public class FeignCustConfig {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
    Logger LogFeign() {
		return new INFOFeignLogger();
	}

//	/**
//	 * 错误解码
//	 */
//	@Bean
//	ErrorDecoder errorDecoder() {
//		return new MyErrorDecoder();
//	}
}
