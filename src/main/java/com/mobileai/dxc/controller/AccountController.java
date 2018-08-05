package com.mobileai.dxc.controller;


import com.mobileai.dxc.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//周恩华负责
@RestController
@RequestMapping("/account")

public class AccountController{
    @Autowired
    AccountService accountservice;
    /**
     * 用户请求注册
     * @param account 账号
     * @param password 密码
     * @param identifyCode 验证码
     * @param beSeller  是否是商家
     * 
     * @return 返回是否注册成功
     */
    @PostMapping("/signup/register")
    public boolean register(@RequestParam String account,@RequestParam String password,@RequestParam String identifyCode,@RequestParam boolean beSeller){
        return accountservice.signup(identifyCode, account, password, beSeller);
    }

    /**
     * 用户请求发送邮箱验证码
     * @param email 用户邮箱地址
     * 
     * @return 返回发送邮件成功
     */
    @PostMapping("/signup/sendidentifyCode")
    public boolean sendidentifyCode(@RequestParam String phone){
        return accountservice.identify(phone);
    }

    /**
     * 用户请求登录
     * @param account   账号
     * @param password  密码
     * @param identifyCode 验证码
     * 
     * @return 返回是否登录成功
     */
    @PostMapping("/login/validate")
    public boolean validate(@RequestParam String account,@RequestParam String password){
        return accountservice.validate(account, password);
    }
    

}