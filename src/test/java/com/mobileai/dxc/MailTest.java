package com.mobileai.dxc;

import com.mobileai.dxc.service.imple.UserServiceImple;

import org.junit.Test;

public class MailTest{

    @Test
    public void testMail(){

        UserServiceImple user = new UserServiceImple();

        user.identify("806265121@qq.com");
    }
}