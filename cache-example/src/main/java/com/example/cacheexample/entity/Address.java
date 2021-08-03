package com.example.cacheexample.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private int id;
    private String detail;
    private User user;
}
