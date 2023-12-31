package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.PasswordRequest;
import com.example.springboot.controller.request.UserPageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper
public interface UserMapper {

   //@Select("select * from user")
   List<User> list();

   List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(Integer id);

    void update(User user);

    void delete(Integer id);

    User getByNameAndPassword(@Param("name")String name, @Param("password")String password);

    int updatePassword(PasswordRequest request);

    User getByName(String name);
}
