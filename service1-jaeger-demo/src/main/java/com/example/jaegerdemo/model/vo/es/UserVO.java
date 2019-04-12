package com.example.jaegerdemo.model.vo.es;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: zhoufengen
 * @create at: 2019-04-12 14:07
 **/
@Data
public class UserVO {

    private String id;
    private String name;
    private int age;
    private Date createTime;
}
