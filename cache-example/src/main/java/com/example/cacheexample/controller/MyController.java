package com.example.cacheexample.controller;

import com.example.cacheexample.entity.User;
import com.example.cacheexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Slf4j
public class MyController {
    @Autowired
    private UserService userService;
    @GetMapping("users/{uid}")
    public User getUser(@PathVariable long uid) {
        return userService.getUser(uid);
    }

    @GetMapping("users")
    public List<User> listUsers() {
        return userService.listUsers();
    }
    @PatchMapping("users")
    public User patchUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("users/{uid}")
    public void delUser(@PathVariable long uid) {
        userService.delUser(uid);
    }
}
