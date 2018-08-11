package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Service;
import com.mobileai.dxc.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//todo 修改serviceService返回值后来写
//未完成
/**
 * 商家点击增加服务，或者对服务进行增删改时。
 * **/
@RestController
@RequestMapping("/service")
public class ServiceController  {
    @Autowired
    private ServiceService service;


    @PostMapping("/submitservice")
    public boolean submitService(@RequestParam Service[] services,@RequestParam int sellerId)
    {
        return  service.serviceInit( services, sellerId);
    }


    @PutMapping("/updateservice/updateprice")
    public boolean updateServicePrice(@RequestParam int serviceId,@RequestParam double price,
                                      @RequestParam int sellerId)
    {

        return  service.updateService(serviceId,sellerId,price);

    }

    @PutMapping("/updateservice/updatedescri")
    public boolean updateServiceDescr(@RequestParam int serviceId,@RequestParam String description,
                                      @RequestParam int sellerId)
    {

        return  service. updateService(serviceId, sellerId,  description);
    }

}