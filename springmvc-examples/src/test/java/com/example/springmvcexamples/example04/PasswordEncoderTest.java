package com.example.springmvcexamples.example04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test(){
        String pwd = "123456";
        String result = passwordEncoder.encode(pwd);
        log.debug(result);
        log.debug(passwordEncoder.encode(pwd));
        log.debug("{}",passwordEncoder.matches("1234",result));
        log.debug("{}",passwordEncoder.matches("123456",result));
    }
}
