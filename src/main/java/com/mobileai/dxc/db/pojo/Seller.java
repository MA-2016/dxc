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

    private String servicetype;

    private double score;

    private String picpath;

    /**
     * 建造者
     */
    public static class Builder {

        private Seller ins;

        public Builder() {
            ins = new Seller();
        }

        public Builder setSellerId(int sellerId) {
            ins.sellerId = sellerId;
            return this;
        }

        public Builder setName(String name) {
            ins.name = name;
            return this;
        }

        public Builder setPhone(String phone) {
            ins.phone = phone;
            return this;
        }

        public Builder setlocation(String location) {
            ins.location = location;
            return this;
        }

        public Builder setlongitude(double longitude) {
            ins.longitude   = longitude;
            return this;
        }

        public Builder setlatitude(double latitude) {
            ins.latitude = latitude;
            return this;
        }

        
        public Seller build() {
            return ins;
        }

    }
}