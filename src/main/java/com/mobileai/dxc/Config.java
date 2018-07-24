package com.mobileai.dxc;

import com.mobileai.dxc.config.WxConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import(WxConfig.class)
@Configuration
public class Config implements WebMvcConfigurer {

}