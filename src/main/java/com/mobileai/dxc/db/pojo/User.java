package com.mobileai.dxc.db.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class User {

    private int userId;
    
    private String name;

    /**
     * 是否实名认证
     */
    private boolean certified;

    private String phone;

    private String picName;

    private Date createTime;

    private Date updateTime;

    /**
     * 建造者
     */
    public static class Builder {

        private User ins;

        public Builder() {
            ins = new User();
        }

        public Builder setUserId(int userId) {
            ins.userId = userId;
            return this;
        }

        public Builder sePhone(String phone) {
            ins.phone = phone;
            return this;
        }

        public Builder setName(String name) {
            ins.name = name;
            return this;
        }

        public Builder setCertified(boolean certified) {
            ins.certified = certified;
            return this;
        }

        public Builder setPicName(String picName) {
            ins.picName = picName;
            return this;
        }

        public User build() {
            return ins;
        }

    }
    public void setcreateTime(Date createTime){
        this.createTime = createTime;
    }

    public void setupdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    
    public Date getcreateTime(){
        return this.createTime;
    }

    public Date getupdateTime(){
        return this.updateTime;
    }

}