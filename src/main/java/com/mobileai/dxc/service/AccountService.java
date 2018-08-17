package com.mobileai.dxc.service;

import com.mobileai.dxc.util.Result;

public interface AccountService {

    /**
     * 向手机发送注册验证码
     * 
     * @return 验证码
     */
    String identify(String phone);

    /**
     * @param identifyCode 验证码
     * @param name
     * @param password
     */
    Result signup(String identifyCode, String name, String password,int identifyMark,String identifyCode_session,String phone);

    /**
     * 验证，注意数据库里存储的password字段应该是密码明文的hashcode（安全性）
     */
    Result validate(String name, String password,String identifyCode,String randomStr);

}