package com.example.mybatisexample.example05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class AddressDTO05Test {
    @Autowired
    private AddressMapper05 addressMapper05;

    @Test
    public void list_xml_test(){
        for(AddressDTO05 a:addressMapper05.listAddressDTOs("harbin")){
            log.debug("{}/{}",
                    a.getId(),
                    a.getUser().getName());
        }
    }
}
