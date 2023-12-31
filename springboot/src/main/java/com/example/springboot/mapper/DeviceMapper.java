package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.DevicePageRequest;
import com.example.springboot.controller.request.PasswordRequest;
import com.example.springboot.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeviceMapper {

    List<Device> list();

    void save(Device device);

    Device getById(Integer id);

    void update(Device device);

    void delete(Integer id);

    List<Device> listByCondition(DevicePageRequest request);
}
