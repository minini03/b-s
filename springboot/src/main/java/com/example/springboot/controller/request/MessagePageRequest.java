package com.example.springboot.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class MessagePageRequest extends BaseRequest{
    private Integer id;
    private Integer deviceID;
    private Integer userID;
    private boolean alert;
    private String msg;
    private double lat;
    private double lng;
    private Timestamp time;
    private Integer value;

}
