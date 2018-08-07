package com.mobileai.dxc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mobileai.dxc.service.AccountService;
import com.mobileai.dxc.util.Result;
import com.mobileai.dxc.util.VerifyUtil;

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
    private AccountService accountservice;
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
    public boolean register(@RequestParam String account,@RequestParam String password,@RequestParam String identifyCode,@RequestParam boolean beSeller,HttpServletRequest request){
        HttpSession session = request.getSession();
        String identifyCode_session = (String)session.getAttribute("identifyCode_session");
        String phone = (String)session.getAttribute("phone");
        return accountservice.signup(identifyCode, account, password, beSeller,identifyCode_session,phone);
    }

    /**
     * 用户请求发送验证码
     * @param phone 用户手机
     * 
     * @return 返回发送短信成功
     */
    @PostMapping("/signup/sendidentifyCode")
    public boolean sendidentifyCode(@RequestParam String phone,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("phone", phone);
        session.setAttribute("identifyCode_session", accountservice.identify(phone));
        return true;
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
    public Result validate(@RequestParam String account,@RequestParam String password,@RequestParam String identifyCode,HttpServletRequest request){
        HttpSession session = request.getSession();
        String randomStr = (String)session.getAttribute("randomStr");
        return accountservice.validate(account, password,identifyCode,randomStr);
    }
    
    @PostMapping("/login/getidentifyCode")
    public byte[] getidentifyCode(HttpServletRequest request){
        Object[] objs = VerifyUtil.createImage();
        HttpSession session  = request.getSession();
        session.setAttribute("randomStr", (String)objs[0]);

        return (byte[])objs[1];
    }

}