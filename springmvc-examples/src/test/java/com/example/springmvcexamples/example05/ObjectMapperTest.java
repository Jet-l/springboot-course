package com.example.springmvcexamples.example05;

import com.example.springmvcexamples.example04.passwordencoder.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
public class ObjectMapperTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_mapper(){
        User user = new User();
        user.setUserName("asdf");
        user.setPassWord("123456");

        try {
            String json = objectMapper.writeValueAsString(user);
            log.debug(json);
            User user1 = objectMapper.readValue(json,User.class);
            log.debug(user1.getUserName());
            log.debug(user1.getPassWord());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_mapper2() throws JsonProcessingException {
        User u = new User();
        u.setUserName("qwe");
        u.setPassWord("465879");
        Map<String,User> map = Map.of("user",u);
        String json = objectMapper.writeValueAsString(map);
        log.debug(json);

        Map<String,User> reMap = objectMapper.readValue(json, new TypeReference<Map<String, User>>() {});
        reMap.forEach((K,V)->{
            log.debug(K);
            log.debug(V.getUserName()+"/"+V.getPassWord());
        });


    }


}
