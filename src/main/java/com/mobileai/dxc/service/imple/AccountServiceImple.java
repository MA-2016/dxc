package com.mobileai.dxc.service.imple;

import java.util.Date;

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
    public Result signup(String identifyCode, String name, String password, int identifyMark,
            String identifyCode_session, String phone) {
        int targetId;

        if (identifyCode.equals(identifyCode_session)) {
            switch (identifyMark) {
            case 1:
                System.out.println("phone"+phone);
                targetId = sellerMapper.addSeller(phone);
                break;
            case 2:
                targetId = userMapper.addUser(phone);
                break;
            case 3:
                targetId = 0;
                break;
            default:
                return new Result(100, "注册失败");
            }

            String secretpassword = MD5Utils.md5(password);

            Account account = new Account();
            account.setName(name);
            account.setPassword(secretpassword);
            account.setidentifyMark(identifyMark);
            account.setcreateTime(new Date());
            account.setupdateTime(new Date());
            account.settargetId(targetId);

            accountMapper.addAccount(account);
            return new Result(200, "注册成功");
        } else {
            return new Result(100, "验证码不匹配");
        }
    }

    @Override
    public Result validate(String name, String password, String identifyCode, String randomStr) {
        String secretpassword = MD5Utils.md5(password);
        Account account = accountMapper.selectByName(name);
        if (identifyCode.equals(randomStr)) {
            if (secretpassword.equals(account.getpassword())) {
                switch (account.getidentifyMark()) {
                case 1:
                    return new Result(200, "商家登录成功", sellerMapper.selectById(account.gettargetId()));
                case 2:
                    return new Result(200, "用户登录成功", userMapper.selectById(account.gettargetId()));
                case 3:
                    return new Result(200, "管理员登录成功");
                default:
                    return new Result(100, "传参出错");
                }
            } else {
                return new Result(100, "用户名与密码不匹配");
            }
        } else {
            return new Result(100, "验证码错误");
        }

    }
}