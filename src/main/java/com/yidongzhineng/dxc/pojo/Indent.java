package com.yidongzhineng.dxc.pojo;

public class Indent {
    private Integer orderId;

    private Integer sellerId;

    private Integer userId;

    private String service;

    private Float totalPrice;

    private Integer number;

    private Long orderTime;

    private Long serviceTime;

    private Integer orderStatus;

    public Indent(Integer orderId, Integer sellerId, Integer userId, String service, Float totalPrice, Integer number, Long orderTime, Long serviceTime, Integer orderStatus) {
        this.orderId = orderId;
        this.sellerId = sellerId;
        this.userId = userId;
        this.service = service;
        this.totalPrice = totalPrice;
        this.number = number;
        this.orderTime = orderTime;
        this.serviceTime = serviceTime;
        this.orderStatus = orderStatus;
    }

    public Indent() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public Long getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Long serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}