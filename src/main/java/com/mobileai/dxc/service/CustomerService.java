package com.mobileai.dxc.service;


public interface CustomerService {

    /**
     * @param 订单信息
     * 
     * @return 订单号
     */
    int submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service);

}