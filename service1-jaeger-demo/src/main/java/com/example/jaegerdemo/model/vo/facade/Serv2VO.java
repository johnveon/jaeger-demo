package com.example.jaegerdemo.model.vo.facade;

/**
 * @description: 外部的vo
 * @author: zhoufengen
 * @create at: 2019-04-10 16:48
 **/
public class Serv2VO {
    private Long id;
    private String name;

    public Serv2VO() {
    }

    public Serv2VO(Long id, String name) {
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
