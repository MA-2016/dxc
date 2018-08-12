package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.User;
import com.mobileai.dxc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 更新用户
     * 
     * @param User
     * 
     * @return 是否更新成功
     * 
     */
    @GetMapping("/updateuser")
    boolean updateuser(User user) {
        return updateuser(user);
    }

    /**
     * 获取用户信息
     * 
     * @param userId
     * 
     * @return User
     */
    @GetMapping("/getuserInfo")
    User getUserInfo(int userId) {
        return userService.getUser(userId);
    }
}