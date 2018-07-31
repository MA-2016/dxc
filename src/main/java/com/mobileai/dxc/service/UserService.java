package com.mobileai.dxc.service;

import com.mobileai.dxc.util.Result;

public interface UserService {

    /**
     * 向邮箱发送注册验证码
     */
    Result identify(String email);

    /**
     * @param identifyCode 验证码
     * @param name
     * @param password
     */
    Result signup(String identifyCode, String name, String password,boolean seller);

    /**
     * 验证，注意数据库里存储的password字段应该是密码明文的hashcode（安全性）
     */
    Result validate(String name, String password);

}