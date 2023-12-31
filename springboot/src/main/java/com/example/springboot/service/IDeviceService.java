
package com.example.springboot.service;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.DevicePageRequest;
import com.example.springboot.entity.Device;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDeviceService {

    List<Device> list();


    PageInfo<Device>  page(DevicePageRequest request);

    void save(Device device);

    Device getById(Integer id);

    void update(Device device);

    void delete(Integer id);


}
