package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.util.Result;

public interface SellerService {

    /**
     * 通知商家新的订单待接受，由OrderService调用
     * @param order 订单
     */
    void notifyNewOrder(Order order);

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

    /**
     * 更新seller信息
     * @return 操作结果
     * @param seller Seller实体类，必须设定sellerId作为改变依据，选择设定属性，设定哪个属性，修改哪个属性
     * */
    Result updateSeller(Seller seller);

    /**
     *
     * 获得seller信息
     * @return  操作结果
     * @param  sellerId 商家编号*/
    Result getSeller(int sellerId);

}