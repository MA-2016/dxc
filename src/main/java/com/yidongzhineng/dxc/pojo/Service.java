package com.yidongzhineng.dxc.pojo;

public class Service extends ServiceKey {
    private String name;

    private Float price;

    public Service(Integer serviceId, Integer sellerId, String name, Float price) {
        super(serviceId, sellerId);
        this.name = name;
        this.price = price;
    }

    public Service() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}