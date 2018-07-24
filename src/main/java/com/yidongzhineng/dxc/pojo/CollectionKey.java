package com.yidongzhineng.dxc.pojo;

public class CollectionKey {
    private Integer userId;

    private Integer sellerId;

    public CollectionKey(Integer userId, Integer sellerId) {
        this.userId = userId;
        this.sellerId = sellerId;
    }

    public CollectionKey() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}