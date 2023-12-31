package com.example.springboot.mapper;

import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<Message> list();

    void save(Message message);

    Message getById(Integer id);

    void update(Message message);

    void delete(Integer id);

    List<Message> listByCondition(MessagePageRequest request);
}
