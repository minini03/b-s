package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class PasswordRequest {
    private String name;
    private String password;
    private String newPass;
}
