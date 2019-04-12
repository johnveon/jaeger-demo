package com.example.jaegerdemo.service.impl;

import com.example.jaegerdemo.repository.es.UserRepository;
import com.example.jaegerdemo.service.EsDemoService;
import com.example.jaegerdemo.table.es.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhoufengen
 * @create at: 2019-04-12 14:05
 **/
@Service
public class EsDemoServiceImpl implements EsDemoService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User esFindByName(String name) {
        User user = userRepository.findByName(name);
        return user;
    }




    @Override
    public User esClientFindByName(String name) {
        return null;
    }
}
