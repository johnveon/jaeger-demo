package com.example.jaegerdemo.config;

import io.opentracing.Tracer;
import io.opentracing.contrib.redis.spring.connection.TracingRedisConnectionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 针对redis不是所有操作都trace的instrument工具
 * @author: zhoufengen
 * @create at: 2019-04-11 16:04
 **/
@Component
public class RedisConnectionFactoryBeanPostProcessor implements BeanPostProcessor {

    private Tracer tracer;

    public RedisConnectionFactoryBeanPostProcessor(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RedisConnectionFactory) {
            return new TracingRedisConnectionFactory((RedisConnectionFactory) bean, false, tracer);
        }
        return bean;
    }

}