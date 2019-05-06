package com.example.jaegerdemo.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 重试配置
 * @Author: zhoufengen
 * @Create In: 2019-04-29 17:13
 **/
@Configuration
public class RetryConfig {


    /**
     *  @Description: 重试间隔为 100 毫秒，最大重试时间为 1 秒，重试次数为 2 次。
     *  @Param []
     *  @Author: zhoufengen
     *  @Date: Created in 2019-05-06 14:53
     *  @Modified By:
     *  @Return: feign.Retryer
     */
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 2);
    }

}
