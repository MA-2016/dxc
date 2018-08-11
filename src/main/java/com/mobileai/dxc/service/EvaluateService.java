package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Order;

public interface EvaluateService{
    /**
     * 提交评论
     * 
     * @param sellerId
     * @param userId
     * @param orderId
     * @param starLevel
     * @param content
     * 
     * @return 是否评论成功
     */

    boolean submitEvaluation(int sellerId,int userId,int orderId,int starLevel,String content);

    // /**
    //  * 获取订单详情
    //  * 
    //  */
    // Order getOrderInfo(int serllerId,int userId,int orderId);
}