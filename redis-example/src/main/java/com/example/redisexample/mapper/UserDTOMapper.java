package com.example.redisexample.mapper;

import com.example.redisexample.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDTOMapper {
    public UserDTO get(Long uid) {
        return UserDTO.builder().id(1L).count(100).build();
    }
}
