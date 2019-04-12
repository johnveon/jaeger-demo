package com.example.jaegerdemo.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @description: 解决es的availableProcessors is already set to [4], rejecting [4]错误
 * @author: zhoufengen
 * @create at: 2019-04-11 17:47
 **/
@Configuration
public class ElasticSearchConfig {
    /**
     * 防止netty的bug
     * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
     */
    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
