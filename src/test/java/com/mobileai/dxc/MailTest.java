package com.mobileai.dxc;

import com.mobileai.dxc.component.MailSender;
import com.mobileai.dxc.service.imple.UserServiceImple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MailTest{

    @Test
    public void testMail(){
        String toEmail = "806265121@qq.com";
        String identifyCode = "dfad";

        UserServiceImple user = new UserServiceImple();

        user.identify("806265121@qq.com");
    }
}