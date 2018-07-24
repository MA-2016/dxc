package com.yidongzhineng.dxc.pojo;

public class Record {
    private Integer recordId;

    private Integer orderId;

    private Short payStatus;

    public Record(Integer recordId, Integer orderId, Short payStatus) {
        this.recordId = recordId;
        this.orderId = orderId;
        this.payStatus = payStatus;
    }

    public Record() {
        super();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }
}