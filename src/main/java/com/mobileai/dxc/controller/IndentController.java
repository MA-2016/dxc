package com.mobileai.dxc.controller;

import com.mobileai.dxc.service.CustomerService;

import com.mobileai.dxc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//周恩华负责
@RestController
@RequestMapping("/indent")
public class IndentController{

    @Autowired
    private CustomerService customerservice;
    @Autowired
    private SellerService sellerService;

    @PostMapping("/submit")
    /**
     * @param 订单信息
     * 
     * @return 订单id
     */
    public int submitOrder(@RequestParam int userId,@RequestParam int sellerId,@RequestParam int number,@RequestParam long serviceTime,@RequestParam int[] service){
        return customerservice.submitOrder(userId, sellerId, number, serviceTime, service);
    }

    @PutMapping("/accept")
    public boolean acceptOrderNotify(@RequestParam int oderId)
    {
        sellerService.acceptOrder(oderId);
        return true;
    }

    @PutMapping("/refuse")
    public boolean refuseOrderNotify(@RequestParam int oderId,@RequestParam String  refuseReason)
    {
        sellerService.refuseOrder(oderId,refuseReason);
        return true;
    }

}