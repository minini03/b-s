package com.example.springboot.service.impl;

import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Message;
import com.example.springboot.mapper.MessageMapper;
import com.example.springboot.service.IMessageService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MessageService implements IMessageService{

    @Autowired
    MessageMapper messageMapper;

    public List<Message> list(){
        return messageMapper.list();
    }

    @Override
    public PageInfo<Message> page(MessagePageRequest request) {
        //PageHelper.startPage(request.getPageNum(),request.getPageSize());
        List<Message> messages = messageMapper.listByCondition(request);
        return new PageInfo<>(messages);
    }

    @Override
    public void save(Message message) {
        messageMapper.save(message);
    }

    @Override
    public Message getById(Integer id) {
        return messageMapper.getById(id);
    }

    @Override
    public void update(Message message) {
        messageMapper.update(message);
    }

    @Override
    public void delete(Integer id) {
        messageMapper.delete(id);
    }

}
