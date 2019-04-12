package com.example.jaegerdemo.repository.es;

import com.example.jaegerdemo.table.es.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description: es的测试类
 * @author: zhoufengen
 * @create at: 2019-04-11 17:31
 **/
public interface UserRepository extends ElasticsearchRepository<User, String> {
    User findByName(String name);
}