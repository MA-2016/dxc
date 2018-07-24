package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Order;

/**
 * 订单处理
 */
public interface OrderService {

    /**
     * 提交新订单，由CustomerService调用
     * @param 订单信息
     * @return 订单号
     */
    void submitOrder(Order order);

    /**
     * 确认已支付，由WxPayService调用
     * @param oid 订单号
     */
    void confirmPayment(int oid);

}