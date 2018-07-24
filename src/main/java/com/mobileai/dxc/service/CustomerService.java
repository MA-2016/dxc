package com.mobileai.dxc.service;

import com.mobileai.dxc.util.Result;

public interface CustomerService {

    /**
     * @param 订单信息
     */
    Result submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service);

}