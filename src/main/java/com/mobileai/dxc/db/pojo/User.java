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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}