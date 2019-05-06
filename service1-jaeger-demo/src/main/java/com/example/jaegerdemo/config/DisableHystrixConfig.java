//package com.example.jaegerdemo.config;
//
//import feign.Feign;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
///**
// * @Description: 为单独的feignclient禁用hystrix：这个配置是针对全部的feignclient，启用之后就不能熔断，fallback也失效
// * 会直接抛出异常，feign.hystrix.enabled=true 的配置也失效
// * @Author: zhoufengen
// * @Create In: 2019-04-29 16:49
// **/
//@Configuration
//public class DisableHystrixConfig {
//    //Configuration2里面加上这个就禁用了UserFeignClient2的Hystrix
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        //feignBuilder方法默认返回HystrixFeign.Builder也就是说Feign默认支持Hystrix
//        //现在改成Feign.Builder就禁用了Hystrix的支持
//        return Feign.builder();
//    }
//}
