package com.example.springmvcexamples.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Address {
    private Integer id;
    private String detail;
    private String comment;
    private User user;
    private LocalDateTime insertTime;
    public Address(Integer id, String detail, String comment, LocalDateTime insertTime) {
        this.id = id;
        this.detail = detail;
        this.comment = comment;
        this.insertTime = insertTime;
    }

}
