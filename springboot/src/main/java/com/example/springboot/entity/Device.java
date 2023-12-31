package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class Device {
    private Integer id;
    private String name;
    private String category;
    private String description;
    private Integer userID;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp activeTime;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp createTime;
}
