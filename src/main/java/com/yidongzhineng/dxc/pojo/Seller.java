package com.yidongzhineng.dxc.pojo;

public class Seller {
    private Integer sellerId;

    private String name;

    private String location;

    private Float longitude;

    private Float latitude;

    private String serviceType;

    private Float score;

    private String picPath;

    public Seller(Integer sellerId, String name, String location, Float longitude, Float latitude, String serviceType, Float score, String picPath) {
        this.sellerId = sellerId;
        this.name = name;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.serviceType = serviceType;
        this.score = score;
        this.picPath = picPath;
    }

    public Seller() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}