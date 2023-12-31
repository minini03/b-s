package com.example.springboot.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer privilege;
    private boolean status;
}
