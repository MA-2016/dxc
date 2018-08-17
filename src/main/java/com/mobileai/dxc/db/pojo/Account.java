package com.mobileai.dxc.db.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * 账户信息表
 * 
 */
@Data
public class Account {

    private Integer accountId;
    private String name;
    private String password;
    private Integer identifyMark;
    private Integer targetId;

    private Date createTime;
    private Date updateTime;


    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setidentifyMark(Integer identifyMark) {
        this.identifyMark  = identifyMark;
    }

    public void settargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public void setcreateTime(Date createTime){
        this.createTime = createTime;
    }

    public void setupdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    public Integer getid() {
        return this.accountId;
    }

    public String getpassword() {
        return this.password;
    }

    public Integer getidentifyMark() {
        return this.identifyMark;
    }

    public Integer gettargetId() {
        return this.targetId;
    }

    public Date getcreateTime(){
        return this.createTime;
    }

    public Date getupdateTime(){
        return this.updateTime;
    }
}