package com.mobileai.dxc.db.pojo;

import lombok.Data;

@Data
public class Evaluate{
    private int sellerId;
    private int userId;
    private int orderId;
    private int starLevel;
    private String content;

    
}