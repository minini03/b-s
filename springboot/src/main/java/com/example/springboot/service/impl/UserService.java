package com.example.springboot.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.PasswordRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.example.springboot.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    private static final String PASS_SALT = "lsn";
    public List<User> list(){
        return userMapper.list();
    }

    @Override
    public PageInfo<User>  page(UserPageRequest userPageRequest) {
        PageHelper.startPage(userPageRequest.getPageNum(),userPageRequest.getPageSize());
        List<User> users = userMapper.listByCondition(userPageRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(User user) {
        user.setPassword(securePass(user.getPassword()));
        userMapper.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        user.setPassword(securePass(user.getPassword()));
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        request.setPassword(securePass(request.getPassword()));
        User user = null;
        try{
            user = userMapper.getByName(request.getName());
        } catch (Exception e) {
            throw new ServiceException("用户名错误");
        }
        if(user == null){
            throw new ServiceException("用户名不存在");
        }
        if(!request.getPassword().equals(user.getPassword())) {
            throw new ServiceException("用户名或密码");
        }
        if(!user.isStatus()){
            throw new ServiceException("当前用户处于禁用状态，请联系管理员");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(user,loginDTO);
        String token = TokenUtils.genToken(String.valueOf(user.getId()),user.getPassword());
        loginDTO.setToken(token);
        return loginDTO;

    }

    @Override
    public void changePass(PasswordRequest request) {
        request.setNewPass(securePass(request.getNewPass()));
        int count = userMapper.updatePassword(request);
        if(count <= 0) {
            throw new ServiceException("修改失败");
        }
    }
    private String securePass(String password) {
        return SecureUtil.md5(password + PASS_SALT);
    }


}
