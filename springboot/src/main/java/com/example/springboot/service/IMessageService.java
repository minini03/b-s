
package com.example.springboot.service;
import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Message;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMessageService {

    List<Message> list();


    PageInfo<Message>  page(MessagePageRequest request);

    void save(Message message);

    Message getById(Integer id);

    void update(Message message);

    void delete(Integer id);

}
