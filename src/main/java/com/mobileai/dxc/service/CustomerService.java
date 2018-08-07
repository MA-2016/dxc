package com.mobileai.dxc.service;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    /**
     * @param 订单信息
     * 
     * @return 订单号
     */
    int submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service);

}