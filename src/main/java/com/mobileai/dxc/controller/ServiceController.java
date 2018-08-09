package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Service;
import com.mobileai.dxc.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

//todo 修改serviceService返回值后来写
//未完成
/**
 * 商家点击增加服务，或者对服务进行增删改时。
 * **/
public class ServiceController {

    @Autowired
   ServiceService serviceService;

    public boolean serviceInit(@RequestParam Service[] services,@RequestParam int sellerId)
    {
        boolean initSuccess = false;
        if(sellerId != 0 && services != null)
        {
            serviceService.serviceInit(services,sellerId);

        }
        return initSuccess;

    }
}
