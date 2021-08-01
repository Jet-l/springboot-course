package com.example.springmvcexamples.example04.passwordencoder.service;

import com.example.springmvcexamples.example04.passwordencoder.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserService04 {

    private Map<String, User> map = creatUser();

    private Map<String, User> creatUser(){
        User u = new User();
        u.setUserName("qwer");

        u.setPassWord("$2a$10$NK44hFJOwvxMW/52aDpGtOWQeThZjHCSvtx1NBQMlsB37sQU.vX36");
        return Map.of("qwer",u);
    }

    public User getUser(String userName){
        return map.get(userName);
    }
}
