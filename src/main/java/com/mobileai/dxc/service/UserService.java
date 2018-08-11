package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * @param 订单信息
     * 
     * @return 订单号
     */
    int submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service);

    /**
     * 获取用户信息
     * 
     */
    User getUser(int userId);
}