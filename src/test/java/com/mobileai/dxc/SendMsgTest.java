package com.mobileai.dxc;

import com.mobileai.dxc.util.SendMsgUtils;

import org.junit.Test;

public class SendMsgTest{
    @Test
    public void testMsg(){
        SendMsgUtils.sendMsgTo("15978946435")
        String result = sendMsgTo("15978946435");
        System.out.println(result);
    }
}