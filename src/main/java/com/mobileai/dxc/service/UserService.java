package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.User;

import com.mobileai.dxc.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    Result getUser(int userId);
    /**
     * 更新用户消息
     */
    Result updateUser( User user);
}