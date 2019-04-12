package com.example.jaegerdemo.repository;

import com.example.jaegerdemo.table.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRepositoryTest {


    @Autowired
    private DemoRepository demoRepository;


    @Test
    public void testInsert(){

        Demo demo = new Demo();
        //demo.setId(1L);
        demo.setName("zxx");
        Demo demo1 = demoRepository.save(demo);
        Assert.assertThat(demo1, notNullValue());
    }

}