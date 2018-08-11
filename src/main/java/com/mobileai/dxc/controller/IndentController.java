package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.OrderService;
import com.mobileai.dxc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//周恩华负责
@RestController
@RequestMapping("/indent")
public class IndentController{
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderservice;

    @GetMapping("/submit")
    /**
     * @param 订单信息
     * 
     * @return 订单id
     */
    public int submitOrder(@RequestParam int userId,@RequestParam int sellerId,@RequestParam int number,@RequestParam long serviceTime,@RequestParam int[] service){
        return userService.submitOrder(userId, sellerId, number, serviceTime, service);
    }

    /**
     * @param orderId 订单id
     */
    @GetMapping("/getOrderInfo")
    public Order getOrder(@RequestParam int orderId){
        return orderservice.getOrderInfo(orderId);
    }
}