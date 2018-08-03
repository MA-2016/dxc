package com.mobileai.dxc.service;


public interface UserService {

    /**
     * 向邮箱发送注册验证码
     */
    boolean identify(String email);

    /**
     * @param identifyCode 验证码
     * @param name
     * @param password
     */
    boolean signup(String identifyCode, String name, String password,boolean seller);

    /**
     * 验证，注意数据库里存储的password字段应该是密码明文的hashcode（安全性）
     */
    boolean validate(String name, String password);

}