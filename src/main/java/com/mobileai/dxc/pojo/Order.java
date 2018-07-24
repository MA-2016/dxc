package com.mobileai.dxc.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Order {

    public static class Status {

        public static final int UNPAID = 1; // 未支付
        
        public static final int UNACCEPTED = 2; // 未接单

        public static final int INSERVICED = 3; // 未服务

        public static final int FINISHED = 4; // 已结束

    }

    private int orderId;

    private int sellerId;

    private int userId;

    private int orderStatus;

    private String service;

    private double totalPrice;

    /**
     * 人数
     */
    private int number;

    /**
     * 创建订单时间
     * System.currentTimeMillis() 获得
     */
    private long orderTime;

    /**
     * 预约的前往时间
     */
    private long serviceTime;

    public static class Builder {

        private Order ins;

        private List<Integer> serviceList;

        public Builder() {
            ins = new Order();
        }

        public Builder setOrderId(int orderId) {
            ins.orderId = orderId;
            return this;
        }

        public Builder setSellerId(int sellerId) {
            ins.sellerId = sellerId;
            return this;
        }

        public Builder setUserId(int userId) {
            ins.userId = userId;
            return this;
        }

        public Builder addService(int serviceId) {
            serviceList.add(serviceId);
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            ins.totalPrice = totalPrice;
            return this;
        }

        public Builder setNumber(int number) {
            ins.number = number;
            return this;
        }

        public Builder setServiceTime(long serviceTime) {
            ins.serviceTime = serviceTime;
            return this;
        }

        public Order build() {
            StringBuilder serviceBuilder = new StringBuilder();
            serviceList.forEach((service) -> serviceBuilder.append(service).append(':'));
            ins.service = serviceBuilder.substring(0, serviceBuilder.length() - 1);
            ins.orderTime = System.currentTimeMillis();
            ins.orderStatus = Status.UNPAID;
            return ins;
        }

    }

}