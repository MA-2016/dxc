package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.db.pojo.User;

public interface UpdateInfo{
    /**
     * 更新个人信息
     * 
     */
    boolean updateSeller(Seller seller);

    boolean updateUser(User user);
}