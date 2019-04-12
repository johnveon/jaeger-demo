package com.example.jaegerdemo.controller;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.model.vo.DemoVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {


    @Autowired
    private DemoController demoController;

    @Test
    public void callServ2() {

        Baseresult<DemoVO> zxx = demoController.callServ1("zxx");

        Assert.assertThat(zxx, notNullValue());

    }
}