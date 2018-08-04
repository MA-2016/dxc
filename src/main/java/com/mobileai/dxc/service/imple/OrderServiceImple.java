package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//周恩华负责
@Service
public class OrderServiceImple implements OrderService{

    @Autowired
    private IndentMapper indentMapper;
    
    /**
     * 提交新订单，由CustomerService调用
     * @param 订单信息
     * 
     * @return 订单号
     */
    @Override 
    public int submitOrder(Order order){
        indentMapper.createOrder(order.getUserId(),order.getSellerId(),order.getNumber(),order.getServiceTime(),order.getService());

        return indentMapper.selectOrderidByUserid(order.getUserId());
    }   

    /**
     * 确认已支付，由WxPayService调用
     * @param oid 订单号
     */
    @Override
    public void confirmPayment(int oid){
        indentMapper.updateOrderStatus(oid);
    }
}