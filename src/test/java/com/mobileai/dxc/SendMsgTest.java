package com.mobileai.dxc;

import com.mobileai.dxc.util.SendMsgUtils;

import org.junit.Test;

public class SendMsgTest{
    @Test
    public void testMsg(){
        String result=SendMsgUtils.sendMsgTo("15978946435",1);
        System.out.println(result);
    }
}