package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.AccountMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.service.AccountService;
import com.mobileai.dxc.util.MD5Utils;
import com.mobileai.dxc.util.SendMsgUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//周恩华负责
@Service
public class AccountServiceImple implements AccountService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public String identify(String phone) {
        return SendMsgUtils.sendMsgTo(phone, 1);
    }

    @Override
    public boolean signup(String identifyCode, String name, String password, boolean seller,
            String identifyCode_session, String phone) {
        int targetid;
        if (identifyCode == identifyCode_session) {
            if (seller) {
                targetid = sellerMapper.addSeller(phone);
            } else {
                targetid = userMapper.addUser(phone);
            }

            String secretpassword = MD5Utils.md5(password);

            accountMapper.addAccount(name, secretpassword, seller, targetid);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validate(String name, String password, String identifyCode, String randomStr) {
        String secretpassword = MD5Utils.md5(password);
        if (identifyCode.equals(randomStr)) {
            if (secretpassword.equals(accountMapper.selectPasswordByUserName(name))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}