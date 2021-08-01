package com.example.springexample.example05;

import com.example.springexample.example05.transactions.entity.User05;
import com.example.springexample.example05.transactions.service.UserService05;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserService05Test {
    @Autowired
    private UserService05 userService05;

    @Test
    public void test(){
        User05 user05 = User05.builder().id(79L).name("zxc").build();

        userService05.addUser(user05);
    }

}
