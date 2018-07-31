package com.mobileai.dxc.db.pojo;

import lombok.Data;

/**
 * 
 * 账户信息表
 * 
 */
@Data
public class Account {

    private int accountId;
    private String username;
    private String password;
    private Boolean seller;
    private int targetid;

    public void setAccountId(int accountId) {
        this.accountId = accountId;
        ;
    }

    public void setUserName(String UserName) {
        this.username = UserName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setseller(boolean seller) {
        this.seller = seller;
    }

    public void settargetid(int targetid) {
        this.targetid = targetid;
    }

    public int getid() {
        return this.accountId;
    }

    public String getpassword() {
        return this.password;
    }

    public boolean getseller() {
        return this.seller;
    }

    public int gettargetid() {
        return this.targetid;
    }
}