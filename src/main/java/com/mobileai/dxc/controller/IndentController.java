package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//周恩华负责
@RestController
@RequestMapping("/indent")

public class IndentController{
    @Autowired
    CustomerService customservice;


    @PostMapping("/submit")
    /**
     * @param 订单信息
     * 
     * @return 订单id
     */
    public int submitOrder(@RequestParam int userId,@RequestParam int sellerId,@RequestParam int number,@RequestParam long serviceTime,@RequestParam int[] service){
        return customservice.submitOrder(userId, sellerId, number, serviceTime, service);
    }
}