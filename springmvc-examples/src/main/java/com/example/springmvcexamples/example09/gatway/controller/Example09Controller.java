package com.example.springmvcexamples.example09.gatway.controller;

import com.example.springmvcexamples.example09.gatway.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/example09/")
@Slf4j
public class Example09Controller {

    private final List<User> users = create();
    private List<User> create(){
        return List.of(User.builder().id(12L).name("asd").build(),
                User.builder().id(54L).name("qwe").build());
    }


    @GetMapping("user/{uid}")
    public User getUser(@PathVariable long uid) throws InterruptedException {

        Thread.sleep(2000);
        return users.stream()
                .filter(u->u.getId()==uid)
                .findFirst()
                .orElse(null);

    }

    @GetMapping("users")
    public List<User> getUsers()throws InterruptedException{
        Thread.sleep(2000);
        return users;

    }

    @PostMapping("users")
    public User postUser(@RequestBody User user)throws InterruptedException{
        log.debug(user.getName());
        user.setId(95L);
        Thread.sleep(2000);
        return user;
    }

    



}
