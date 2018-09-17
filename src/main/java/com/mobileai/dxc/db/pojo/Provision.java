package com.mobileai.dxc.db.pojo;

public class Provision {
    private Integer serviceId;
    private Integer sellerId;
    private  String name;
    private  String  description;
    private float price;
    private  float prePrice;
    private String picture;
    private double weight;
    private int orderNum;
    /**
     * 00表示审核中，01表示接受预定，10表示服务下架*/
    private int status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(float prePrice) {
        this.prePrice = prePrice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Provision(String name, String description, float price, float prePrice) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.prePrice = prePrice;
    }
    public Provision(){}
}
