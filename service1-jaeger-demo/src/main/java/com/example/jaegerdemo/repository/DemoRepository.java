package com.example.jaegerdemo.repository;

import com.example.jaegerdemo.table.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @description: 测试DAO
 * @author: zhoufengen
 * @create at: 2019-04-10 15:49
 **/
public interface DemoRepository extends JpaRepository<Demo, Long>,QuerydslPredicateExecutor<Demo> {}
