package com.yidongzhineng.dxc.pojo;

public class PictureKey {
    private Integer picId;

    private Integer sellerId;

    public PictureKey(Integer picId, Integer sellerId) {
        this.picId = picId;
        this.sellerId = sellerId;
    }

    public PictureKey() {
        super();
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}