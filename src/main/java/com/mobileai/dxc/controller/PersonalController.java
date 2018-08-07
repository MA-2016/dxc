package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.db.pojo.User;
import com.mobileai.dxc.service.UpdateInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonalController {
    @Autowired
    UpdateInfo updateInfo;

    
    /**
     * 更新商家
     * 
     * @param Seller
     * 
     * @return 是否更新成功
     */
    @GetMapping("/updateseller")
    boolean updateseller(Seller seller) {
        return updateInfo.updateSeller(seller);
    }

    /**
     * 更新用户
     * 
     * @param User
     * 
     * @return 是否更新成功
     * 
     */
    @GetMapping("/updateuser")
    boolean updateuser(User user){
        return updateuser(user);
    }

}