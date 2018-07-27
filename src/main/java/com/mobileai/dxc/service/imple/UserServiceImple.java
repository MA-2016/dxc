package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.component.MailSender;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.service.UserService;
import com.mobileai.dxc.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserMapper userMapper;

    private String identifyCode;

    @Override
    public Result identify(String toEmail){
        MailSender.sendMail(toEmail, identifyCode);
        return new Result(100,identifyCode);
    }

    @Override
    public Result signin(String identifyCode, String name, String password){
        if(name==password){
            return new Result(200);
        }else{
            return new Result(100);
        }
    }

    @Override
    public Result validate(String name,String password){
        if(name==password){
            return new Result(200);
        }else{
            return new Result(100);
        }
    }

}