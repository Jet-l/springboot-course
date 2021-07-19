package com.example.mybatisexample.example01;


import com.example.mybatisexample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class UserMapper1Test {
    @Autowired
    private UserMapper01 userMapper01;

    @Test
    public void addUser_test(){
        User user = new User();
        user.setId(2L);
        user.setName("Bo");
        user.setCompany("dbly");
        userMapper01.insert(user);
    }

    @Test
    public void list_test(){
        for(User user: userMapper01.list()){
            log.debug("{}/{}/{}",
                    user.getName(),
                    user.getCompany(),
                    user.getCreateTime());
        }
    }

    @Test
    public void get_test(){
        User user = userMapper01.get(2L);
        log.debug("{}/{}",
                user.getName(),
                user.getUpdateTime());
    }

}
