package com.mobileai.dxc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxcApplication.class, args);
    }
}
