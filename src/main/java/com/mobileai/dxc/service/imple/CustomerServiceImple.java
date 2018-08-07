package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.CustomerService;
import com.mobileai.dxc.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//周恩华负责
@Service
public class CustomerServiceImple implements CustomerService{

    @Autowired
    private OrderService createorder;

    @Override
    public int submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service){
        Order order = new Order();
        order.setUserId(userId);
        order.setSellerId(sellerId);
        order.setNumber(number);
        order.setServiceTime(serviceTime);
        order.setService(service.toString());

        return createorder.submitOrder(order);
    }
}