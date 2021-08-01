package com.example.springmvcexamples.example02.handlingexception.service;

import com.example.springmvcexamples.example02.handlingexception.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
public class UserService02 {
    public void addFile(){
        try {
            Files.readString(Path.of("A:/aa.aa"));
        } catch (IOException e) {
            throw new MyException(500, "读取文件错误！" + e.getMessage());
        }

    }

    public void addFile02(){
        try {
            Files.readString(Path.of("A:/a.a"));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"文件不存在");
        }

    }
}
