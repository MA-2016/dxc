package com.mobileai.dxc.db.pojo;

import lombok.Data;

import static com.mobileai.dxc.util.IntStringUtils.intArray2String;

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

    private int orderStatus;

    private  String reason;
    public Order(){}
    public Order( int sellerId, int userId, int[] service, double totalPrice, int number, long orderTime, long serviceTime, int orderStatus, String reason) {
        this.sellerId = sellerId;
        this.userId = userId;
        String strService=intArray2String(service);
        this.service = strService;
        this.totalPrice = totalPrice;
        this.number = number;
        this.orderTime = System.currentTimeMillis();
        this.serviceTime = serviceTime;
        this.orderStatus =  Status.UNPAID;
        this.reason = reason;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getUserId() {
        return userId;
    }

    public String getService() {
        return service;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getNumber() {
        return number;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public long getServiceTime() {
        return serviceTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public void setServiceTime(long serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
//    public Order() {
//            //this.service =
//            this.orderTime = System.currentTimeMillis();
//            this.orderStatus = Status.UNPAID;
//
//        }
//    public static class Builder {
//
//        private Order ins;
//
//        private List<Integer> serviceList;
//
//        public Builder() {
//            ins = new Order();
//        }
//
//        public Builder setOrderId(int orderId) {
//            ins.orderId = orderId;
//            return this;
//        }
//
//        public Builder setSellerId(int sellerId) {
//            ins.sellerId = sellerId;
//            return this;
//        }
//
//        public Builder setUserId(int userId) {
//            ins.userId = userId;
//            return this;
//        }
//
//        public Builder addService(int serviceId) {
//            serviceList.add(serviceId);
//            return this;
//        }
//
//        public Builder setTotalPrice(double totalPrice) {
//            ins.totalPrice = totalPrice;
//            return this;
//        }
//
//        public Builder setNumber(int number) {
//            ins.number = number;
//            return this;
//        }
//
//        public Builder setServiceTime(long serviceTime) {
//            ins.serviceTime = serviceTime;
//            return this;
//        }
//
//        public Builder setReason(String reason) {
//            ins.reason = reason;
//            return this;
//        }
//
//        public Order build() {
//            StringBuilder serviceBuilder = new StringBuilder();
//            serviceList.forEach((service) -> serviceBuilder.append(service).append(':'));
//            ins.service = serviceBuilder.substring(0, serviceBuilder.length() - 1);
//            ins.orderTime = System.currentTimeMillis();
//            ins.orderStatus = Status.UNPAID;
//            return ins;
//        }
//
//    }

}