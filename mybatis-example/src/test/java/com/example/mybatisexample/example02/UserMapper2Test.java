package com.example.mybatisexample.example02;

import com.example.mybatisexample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
@Slf4j
@Rollback(value = false)
public class UserMapper2Test {
    @Autowired
    private UserMapper02 userMapper02;

    @Test
    public void addUser_test(){
        User user = new User();
        user.setName("sun");
        user.setCompany("amazon");
        userMapper02.insert(user);
    }

    @Test
    public void update_test() {
        User u = User.builder()
                .id(1416938218515853314L)
                .company("nike")
                .build();
        userMapper02.updateById(u);
    }


    @Test
    public void list_test(){
        List<User> users = userMapper02.selectByMap(Map.of("company","nike"));
        for(User user:users){
            log.debug(user.getName());
        }
    }

    @Test
    public void list_test2(){
        List<User> users = userMapper02.listByCompany("nike");
        for (User user:users){
            log.debug(user.getName());
        }
    }




}
