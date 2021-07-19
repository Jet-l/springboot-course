package com.example.mybatisexample.example04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class AddressDTO04Test {

    @Autowired
    private AddressDTO04Mapper addressDTO04Mapper;

    @Test
    public void list_test(){
        for (AddressDTO04 a:addressDTO04Mapper.list("东北林业大学")){
            log.debug("{}",a);
        }
    }

    @Test
    public void list_test2(){
        for (AddressDTO04 a:addressDTO04Mapper.list2("东北林业大学")){
            log.debug("{}",a);
        }
    }
}
