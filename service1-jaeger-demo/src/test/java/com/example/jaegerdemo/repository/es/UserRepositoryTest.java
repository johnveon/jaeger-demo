package com.example.jaegerdemo.repository.es;

import com.example.jaegerdemo.table.es.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByName() {

    }

    @Test
    public void saveuser(){
        User user = new User();

        user.setName("xxx1");
        user.setAge(18);
        user.setCreateTime(new Date());

        User save = userRepository.save(user);

        Assert.assertThat(save, notNullValue());
    }
}