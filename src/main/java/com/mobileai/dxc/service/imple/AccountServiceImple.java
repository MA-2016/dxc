package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.AccountMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.db.pojo.Account;
import com.mobileai.dxc.service.AccountService;
import com.mobileai.dxc.util.MD5Utils;
import com.mobileai.dxc.util.Result;
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
    public Result validate(String name, String password, String identifyCode, String randomStr) {
        String secretpassword = MD5Utils.md5(password);
        Account account = accountMapper.selectByName(name);
        if (identifyCode.equals(randomStr)) {
            if (secretpassword.equals(account.getpassword())) {
                if(account.getseller()){
                    return new Result(200, "用户登录成功",userMapper.selectById(account.gettargetid()));
                }else{
                    return new Result(200,"商家登录成功",sellerMapper.selectById(account.gettargetid()));
                }
            } else {
                return new Result(100, "用户名与密码不匹配");
            }
        } else {
            return new Result(100,"验证码错误");
        }

    }
}