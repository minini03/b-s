package com.example.springboot.service.impl;

import com.example.springboot.controller.request.DevicePageRequest;
import com.example.springboot.entity.Device;
import com.example.springboot.mapper.DeviceMapper;
import com.example.springboot.service.IDeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeviceService implements IDeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    public List<Device> list(){
        return deviceMapper.list();
    }

    @Override
    public PageInfo<Device>  page(DevicePageRequest request) {
        //PageHelper.startPage(request.getPageNum(),request.getPageSize());
        List<Device> devices = deviceMapper.listByCondition(request);
        return new PageInfo<>(devices);
    }

    @Override
    public void save(Device device) {
        deviceMapper.save(device);
    }

    @Override
    public Device getById(Integer id) {
        return deviceMapper.getById(id);
    }

    @Override
    public void update(Device device) {
        deviceMapper.update(device);
    }

    @Override
    public void delete(Integer id) {
        deviceMapper.delete(id);
    }

}
