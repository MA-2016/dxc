package com.mobileai.dxc.service;

import com.mobileai.dxc.util.Result;

public interface OrderService {

    /**
     * @param 订单信息
     * @return 订单号
     */
    Result submitOrder();

    /**
     * @param 订单号
     */
    void confirmPayment();
    
}