package com.example.springboot.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Message {
    private Integer id;
    private Integer deviceID;
    private Integer alert;
    private String msg;
    private double lat;
    private double lng;
    private Timestamp time;
    private Integer value;
}
