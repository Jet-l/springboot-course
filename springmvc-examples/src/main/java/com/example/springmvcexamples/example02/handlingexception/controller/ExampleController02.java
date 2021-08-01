package com.example.springmvcexamples.example02.handlingexception.controller;

import com.example.springmvcexamples.example02.handlingexception.entity.User;
import com.example.springmvcexamples.example02.handlingexception.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/example02/")
public class ExampleController02 {

    @Autowired
    private UserService02 userService02;

    @GetMapping("exception")
    public void getException(){
        userService02.addFile();
    }

    @GetMapping("exception02")
    public void getException02(){
        userService02.addFile02();
    }

    @PostMapping("login")
    public void login(@RequestBody User user){
        if (!("asd".equals(user.getUserName()) && "123".equals(user.getPassWord()))){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名或密码正确");
        }
    }

}
