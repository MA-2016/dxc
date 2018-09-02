package com.mobileai.dxc.db.pojo;

import lombok.Data;

@Data
public class Seller{
    private int sellerId;

    private String name;

    private String phone;

    private String location;

    /**
     * 经纬度
     */
    private double longitude;

    private double latitude;
    /**
     * 服务类型
     */

    private String service;

    private double score;

    private String picpath;

    /**
     * 评论人数
     */
    private int evaluateNum;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public void setEvaluateNum(int evaluateNum){
        this.evaluateNum = evaluateNum;
    }
    public int getEvaluateNum(){
        return evaluateNum;
    }
}