package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.User;
import com.mobileai.dxc.service.UserService;

import com.mobileai.dxc.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 更新用户
     * @param user
     * @return 更新后的数据
     * 
     */
    @PutMapping("/updateuser")
    Result updateuser(@RequestBody User user) {
        return userService.updateUser(user);

    }

    /**
     * 获取用户信息
     * 
     * @param userId
     * @return 用户数据
     */
    @GetMapping("/getuserInfo")
    Result getUserInfo(@RequestParam int userId) {
        return userService.getUser(userId);
    }
}