package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class UserPageRequest extends BaseRequest{
    private Integer id;
    private String name;
    private Integer privilege;

}
