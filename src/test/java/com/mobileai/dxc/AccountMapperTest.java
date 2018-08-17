package com.mobileai.dxc;

import java.util.Date;

import com.mobileai.dxc.db.mapper.AccountMapper;
import com.mobileai.dxc.db.pojo.Account;
import com.mobileai.dxc.util.MD5Utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
    @Autowired
    public AccountMapper accountmapper;

    @Test
    public void addAccount() {
        String password = MD5Utils.md5("271623");
        
        Account account = new Account();
        account.setName("dxc");
        account.setPassword(password);
        account.setidentifyMark(1);
        account.setcreateTime(new Date());
        account.setupdateTime(new Date());
        account.settargetId(12);

        accountmapper.addAccount(account);

    }

    @Test
    public void selectAccount() {
        String password = accountmapper.selectPasswordByUserName("dxc4");
        System.out.print(password);
    }
}
