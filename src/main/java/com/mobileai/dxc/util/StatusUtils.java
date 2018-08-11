package com.mobileai.dxc.util;

import static com.mobileai.dxc.db.pojo.Order.Status.*;

public class StatusUtils {

    //订单提交后状态码
    public static int getOrderUnhandletatus(int preStatuscode)
    {
        return (preStatuscode|UNHANDLE);
    }


    //接受订单后状态码
    public static int getOrderAcceptStatus(int preStatuscode)
    {
        return (preStatuscode|ACCEPT);
    }


    //拒绝订单后状态码
    public static int getOrderRefuseStatus(int preStatuscode)
    {
        return (preStatuscode|REFUSE);
    }


    //服务完成后状态码
    public static int getOrderServedOrderStatus(int preStatuscode)
    {
        return (preStatuscode|SERVICED);
    }
}
