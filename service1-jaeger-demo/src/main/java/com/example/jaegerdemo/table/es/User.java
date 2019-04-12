package com.example.jaegerdemo.table.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * @description: es的测试类
 * @author: zhoufengen
 * @create at: 2019-04-11 17:30
 **/
@Data
@Document(indexName = "user", type = "test")
public class User {
    @Id
    private String id;
    private String name;
    private int age = 18;
    private Date createTime = new Date();
}