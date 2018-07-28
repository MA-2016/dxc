package com.mobileai.dxc;

import com.mobileai.dxc.config.WxConfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import(WxConfig.class)
@MapperScan("com.mobileai.dxc.db.mapper")
@Configuration
public class Config implements WebMvcConfigurer {

}