package com.example.springmvcexamples.example04.passwordencoder.controller;

import com.example.springmvcexamples.example04.passwordencoder.entity.User;
import com.example.springmvcexamples.example04.passwordencoder.service.UserService04;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example04")
public class ExController04 {

    @Autowired
    private UserService04 userService04;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("login")
    public Map login(@RequestBody User user){
        User u = userService04.getUser(user.getUserName());
        if(u == null||!passwordEncoder.matches(user.getPassWord(),u.getPassWord())){
            log.debug("登录失败");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名密码错误");
        }else {
            log.debug("登录成功");
        }

        return Map.of("user",u);
    }


}
