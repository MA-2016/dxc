package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Service;

public interface ServiceService {

    /**
     * @Function:用户第一次初始化自己的服务
     * @Param:services数组，sellerId从登陆信息session中取得
     * **/
    public boolean serviceInit(Service[] services, int sellerId);


    /**
     * @Function:用户更改自己的service信息。
     *
     * **/
    public boolean updateService(int serviceId, int sellerId, String description);
    public boolean updateService(int serviceId, int sellerId, double price);
    public boolean updateService(int serviceId, int sellerId, double price, String description);

    /**
     * 说明：seller在有用户已经预定成功时，不能删除该项服务
     * */
    public boolean deleteService(int serviceId, int sellerId);

    public boolean addService(int serviceId, int sellerId, String description, double price);

}
