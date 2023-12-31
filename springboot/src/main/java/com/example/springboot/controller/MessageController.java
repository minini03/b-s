package com.example.springboot.controller;

import cn.hutool.core.lang.Dict;
import com.example.springboot.common.Result;
import com.example.springboot.controller.request.DevicePageRequest;
import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Device;
import com.example.springboot.entity.Message;
import com.example.springboot.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService messageService;

    @GetMapping("/statics")
    public Result statics(MessagePageRequest request){
        List<Message> list = messageService.page(request).getList();
        Set<Timestamp> dates = list.stream().map(Message::getTime).collect(Collectors.toSet());

//        List<Dict> linlist = new ArrayList<>();
//        for(Timestamp time :dates) {
//            String date =	String.valueOf(time);
//            Integer value = list.stream().filter(String.valueOf(Message::getTime()).equals(time))
//            Dict dict = Dict.create();
//            Dict line = dict.set("value", )
//        }
//        var time=
//        Set<String> dates = messages.stream().map(new Date(Message::getTime)).collect(Collectors.toSet());
        return Result.success();
    }


    @GetMapping("/list")
    public Result list(){
        List<Message>messages = messageService.list();
        return Result.success(messages);
    }


    @GetMapping("/page")
    public Result page(MessagePageRequest request){
        return Result.success(messageService.page(request));
    }

}
