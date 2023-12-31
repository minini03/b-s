package com.example.springboot.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DevicePageRequest extends BaseRequest{
    private Integer id;
    private String name;
    private String category;
    private String description;
    private Integer userID;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate activeTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate createTime;

}
