package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.DevicePageRequest;
import com.example.springboot.entity.Device;
import com.example.springboot.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    IDeviceService deviceService;

    @PostMapping("/save")
    public Result save(@RequestBody Device device){
        deviceService.save(device);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Device device){
        deviceService.update(device);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        deviceService.delete(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Device device = deviceService.getById(id);
        return Result.success(device);
    }

    @GetMapping("/list")
    public Result list(){
        List<Device>devices = deviceService.list();
        return Result.success(devices);
    }


    @GetMapping("/page")
    public Result page(DevicePageRequest request){
        return Result.success(deviceService.page(request));
    }

}
