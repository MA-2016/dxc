package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

//周恩华负责
public class CustomerServiceImple implements CustomerService{
    @Autowired
    Order order;

    @Autowired
    OrderServiceImple createorder;

    @Override
    public int submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service){
        order.setUserId(userId);
        order.setSellerId(sellerId);
        order.setNumber(number);
        order.setServiceTime(serviceTime);
        order.setService(service.toString());

        return createorder.submitOrder(order);
    }
}