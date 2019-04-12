package com.example.jaegerdemo.service;

import com.example.jaegerdemo.table.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {


    @Autowired
    private DemoService demoService;

    @Test
    public void findByName() {

        Demo zxx = demoService.findByName("zxx");

        Assert.assertThat(zxx, notNullValue());

    }
}