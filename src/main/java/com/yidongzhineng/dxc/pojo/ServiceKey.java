package com.yidongzhineng.dxc.pojo;

public class ServiceKey {
    private Integer serviceId;

    private Integer sellerId;

    public ServiceKey(Integer serviceId, Integer sellerId) {
        this.serviceId = serviceId;
        this.sellerId = sellerId;
    }

    public ServiceKey() {
        super();
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}