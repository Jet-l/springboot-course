package com.example.redisexample;

import com.example.redisexample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@Slf4j
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test(){
        User u = User.builder().id(1L).name("trete").build();
        redisTemplate.opsForValue().set("3",u);
    }

}
