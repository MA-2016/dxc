
package com.yidongzhineng.dxc.config;

import com.github.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将wxPay转化为bean，装入到容器中
 */
@Configuration
public class WxConfig {

    @Autowired
    private MyWxPayConfig wxPayConfig;

    @Bean
    public WXPay wxPay(){
        WXPay wxPay=new WXPay(wxPayConfig);

        return wxPay;
    }
}

