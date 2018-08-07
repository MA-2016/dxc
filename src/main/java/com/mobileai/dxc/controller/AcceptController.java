package com.mobileai.dxc.controller;


import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.imple.SellerServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/*
*提交订单后，向商家发送短信，让商家去网站确认
* 商家拒绝或接受消息后，向客户发送短信
* */

public class AcceptController {

    @Autowired
    SellerServiceImple sellerService;
    //用户点击提交订单
    @RequestMapping("/sellerConfirmOrder")
    public  boolean  sellerConfirmOrder(@RequestParam Order order)
    {
        //数据库第一条order编号为1
        if(order.getOrderId()!=0)
        {
            sellerService.notifyNewOrder(order);
            return true;
        }
        else
        {
            return false;
        }
    }
    //商家点击接受订单
    @RequestMapping("/acceptOrder")
    public boolean guestNotifyAccept(@RequestParam int oid) {
        if (oid!=0) {
            sellerService.acceptOrder(oid);
            return true;
        }
        else
            return false;
    }
    //商家点击拒绝订单
    public boolean guestNotifyRefus(@RequestParam int oid,@RequestParam String reason)
    {
        if(oid!=0)
        {
            sellerService.refuseOrder(oid,reason);
            return true;
        }
        else
        {
            return  false;
        }
    }
}
