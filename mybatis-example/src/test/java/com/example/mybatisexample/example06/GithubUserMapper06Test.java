package com.example.mybatisexample.example06;

import com.example.mybatisexample.entity.GithubUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class GithubUserMapper06Test {
    @Autowired
    private GithubUserMapper06 githubUserMapper06;
    @Test
    public void list_test01(){
        QueryOptional optionals = QueryOptional.builder()
                .stars(10)
                .repos(10)
                .beforeCreateTime(LocalDateTime.of(2022,1,1,0,0))
                .build();
        for (GithubUser g:githubUserMapper06.listByOptionals(optionals)){
            log.debug("{}",g.getName());
        }
    }

    @Test
    public void list_test02(){
        QueryOptional optionals = QueryOptional.builder()
                .stars(10)
                .beforeCreateTime(LocalDateTime.of(2022,1,1,0,0))
                .build();
        for (GithubUser g:githubUserMapper06.listByOptionals(optionals)){
            log.debug("{}",g.getName());
        }
    }
}
