package com.example.mybatisexample.example05;

import com.example.mybatisexample.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO05 {
    private Long id;
    private String name;
    private String company;
    List<Address> addresses;
}
