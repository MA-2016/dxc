package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.mapper.RecordMapper;
import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.OrderService;
import com.mobileai.dxc.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//周恩华负责
@Service
public class OrderServiceImple implements OrderService{

    @Autowired
    private IndentMapper indentMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private SellerService sellerService;
    /**
     * 提交新订单，由UserService调用
     * @param 订单信息
     * 
     * @return 订单号
     */
    @Override 
    public int submitOrder(Order order){
        indentMapper.createOrder(order.getUserId(),order.getSellerId(),order.getNumber(),order.getServiceTime(),order.getService());
        long time=order.getServiceTime();
        int recordId=indentMapper.selectIdByTime(time);
        int fee=(int)order.getTotalPrice();
        recordMapper.addRecord(recordId,0,fee);
        sellerService.notifyNewOrder(order);
        return indentMapper.selectOrderidByUserid(order.getUserId());
    }   

    /**
     * 确认已支付，由WxPayService调用
     * @param oid 订单号
     */
    @Override
    public void confirmPayment(int oid,int orderStatus){
        indentMapper.updateOrderStatus(oid,orderStatus);
    }

    /**
     * 获取订单信息
     * @param orderId 订单号
     */
    @Override
    public Order getOrderInfo(int orderId){
        return indentMapper.selectByOrderid(orderId);
    }
}