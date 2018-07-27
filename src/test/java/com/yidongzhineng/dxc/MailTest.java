package com.yidongzhineng.dxc;

import com.mobileai.dxc.component.MailSender;

import org.junit.Test;

public class MailTest{

    @Test
    public void testMail(){
        String toEmail = "806265121@qq.com";
        String identifyCode = "dfad";

        MailSender mSender = new MailSender();
        mSender.sendMail(toEmail, identifyCode);
    }
}