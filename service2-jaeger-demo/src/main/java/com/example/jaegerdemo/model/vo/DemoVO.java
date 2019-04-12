package com.example.jaegerdemo.model.vo;

/**
 * @description: 测试
 * @author: zhoufengen
 * @create at: 2019-04-10 15:28
 **/
public class DemoVO {

    private Long id;
    private String name;

    public DemoVO() {
    }

    public DemoVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
