package com.mobileai.dxc.service;

import com.mobileai.dxc.util.Result;

public interface SellerService {

    /**
     * 通知商家新的订单待接受，由OrderService调用
     * @param oid 订单号
     */
    void notifyNewOrder(int oid);

    /**
     * 商家接受订单
     * @param oid 订单号
     * @return 操作结果
     */
    Result acceptOrder(int oid);

    /**
     * 商家拒绝订单
     * @param oid 订单号
     * @param reason 拒绝原因
     * @return 操作结果
     */
    Result refuseOrder(int oid, String reason);

}