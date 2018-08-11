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
    int submitOrder(Order order);

    /**
     * 确认已支付，由WxPayService调用
     * @param orderId 订单号
     * @param orderStatu 订单状态
     */
    void confirmPayment(int orderId,int orderStatu);

    /**
     * 获取订单
     * @param orderId 订单号
     * @return 订单信息
     */
    Order getOrderInfo(int orderId);

}