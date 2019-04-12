package com.example.jaegerdemo.service.impl;

import com.example.jaegerdemo.repository.DemoRepository;
import com.example.jaegerdemo.service.DemoService;
import com.example.jaegerdemo.table.Demo;
import com.example.jaegerdemo.table.QDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @description:
 * @author: zhoufengen
 * @create at: 2019-04-10 15:53
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Demo findByName(String name) {

        findFromRedis();

        Optional<Demo> one = demoRepository.findOne(QDemo.demo.name.eq("zxx"));
        return one.orElse(null);
    }

    private void findFromRedis() {
        redisTemplate.opsForValue().set("zxx", "1xx");
        redisTemplate.opsForValue().get("zxx");
    }
}
