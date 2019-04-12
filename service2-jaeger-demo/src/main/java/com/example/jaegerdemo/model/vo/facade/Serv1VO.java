package com.example.jaegerdemo.model.vo.facade;

/**
 * @description: 外部的vo
 * @author: zhoufengen
 * @create at: 2019-04-10 16:48
 **/
public class Serv1VO {
    private Long id;
    private String name;

    public Serv1VO() {
    }

    public Serv1VO(Long id, String name) {
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
