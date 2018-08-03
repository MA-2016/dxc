package com.mobileai.dxc.controller;


import com.mobileai.dxc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")

public class UserController{
    @Autowired
    UserService userservice;
    /**
     * 用户请求注册
     * @param account 账号
     * @param password 密码
     * @param identifyCode 验证码
     * @param beSeller  是否是商家
     * 
     * @return 返回是否注册成功
     */
    @GetMapping("/signup/register")
    public boolean register(@RequestParam String account,@RequestParam String password,@RequestParam String identifyCode,@RequestParam boolean beSeller){
        return userservice.signup(identifyCode, account, password, beSeller);
    }

    /**
     * 用户请求发送邮箱验证码
     * @param email 用户邮箱地址
     * 
     * @return 返回发送邮件成功
     */
    @GetMapping("/signup/getidentifyCode")
    public boolean sendidentifyCode(@RequestParam String email){
        return userservice.identify(email);
    }

    /**
     * 用户请求登录
     * @param account   账号
     * @param password  密码
     * @param identifyCode 验证码
     * 
     * @return 返回是否登录成功
     */
    @GetMapping("/login/validate")
    public boolean validate(@RequestParam String account,@RequestParam String password){
        return userservice.validate(account, password);
    }
    

}