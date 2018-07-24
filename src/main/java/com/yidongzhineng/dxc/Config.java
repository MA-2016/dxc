package com.yidongzhineng.dxc;

import com.yidongzhineng.dxc.config.WxConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import(WxConfig.class)
@Configuration
public class Config implements WebMvcConfigurer {

}