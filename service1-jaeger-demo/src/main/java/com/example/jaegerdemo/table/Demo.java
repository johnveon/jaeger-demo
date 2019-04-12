package com.example.jaegerdemo.table;

import javax.persistence.*;

/**
 * @description: 测试表
 * @author: zhoufengen
 * @create at: 2019-04-10 15:43
 **/
@Entity
@Table(name = "my_demo")
public class Demo {

    @Id
    @GeneratedValue
    @Column(name = "demo_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
