package com.mobileai.dxc.service.imple;

import java.util.Random;

import com.mobileai.dxc.db.mapper.AccountMapper;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.service.UserService;
import com.mobileai.dxc.util.MD5Utils;
import com.mobileai.dxc.util.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    private String identifyCode;
    private String email;

    @Override
    public boolean identify(String toEmail) {
        email = toEmail;
        identifyCode = getidentifyCode();
        MailSender.sendMail(toEmail, identifyCode);
        return true;
    }

    @Override
    public boolean signup(String identifyCode, String name, String password, boolean seller) {
        if (identifyCode == this.identifyCode) {
            int targetid = userMapper.addAccount(email);
            String secretpassword = MD5Utils.md5(password);

            accountMapper.addAccount(name, secretpassword, seller, targetid);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean validate(String name, String password) {
        String secretpassword = MD5Utils.md5(password);

        if (secretpassword.equals(accountMapper.selectPasswordByUserName(name))) {
            return true;
        } else {
            return false;
        }
    }

    // 得到随机8位验证码
    public String getidentifyCode() {
        String number[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<8;i++){
            str.append(number[(int)random.nextInt(10)]);
        }
        
        return str.toString();

    }

}