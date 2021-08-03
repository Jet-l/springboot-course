package com.example.redisexample.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
}
