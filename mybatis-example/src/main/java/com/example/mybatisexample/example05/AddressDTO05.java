package com.example.mybatisexample.example05;

import com.example.mybatisexample.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDTO05 {
    private Long id;
    private String detail;
    private User user;
    private LocalDateTime addressCreateTime;
}
