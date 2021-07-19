package com.example.mybatisexample.example03;

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
public class UserMapperTest3 {
    @Autowired
    private UserMapper03 userMapper03;
    @Test
    public void list_test(){
        for (User u: userMapper03.listByDetail("东北林业大学")){
            log.debug("{}/{}/{}",
                    u.getName(),
                    u.getCompany(),
                    u.getCreateTime());
        }
    }
}
