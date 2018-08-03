package com.mobileai.dxc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.mobileai.dxc.db.mapper")
@EnableAutoConfiguration
public class DxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxcApplication.class, args);
    }
}
