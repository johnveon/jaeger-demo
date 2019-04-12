package com.example.jaegerdemo.service;

import com.example.jaegerdemo.table.es.User;

/**
 * @description: es的测试服务
 * @author: zhoufengen
 * @create at: 2019-04-12 14:03
 **/
public interface EsDemoService {

    User esFindByName(String name);

    User esClientFindByName(String name);

}
