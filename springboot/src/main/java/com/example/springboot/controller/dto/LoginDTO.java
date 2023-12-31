package com.example.springboot.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String name;
    private String email;
    private Integer privilege;
    private String token;
    private String code;
}
