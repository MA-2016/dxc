package com.mobileai.dxc;

import com.mobileai.dxc.db.mapper.AccountMapper;
import com.mobileai.dxc.util.MD5Utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
    @Autowired
    public AccountMapper accountmapper;

    // @Test
    // public void addAccount () {
    //     String password = MD5Utils.md5("123456");
    //     accountmapper.addAccount("dxc2", password,false,1333);
    // }

    @Test
    public void selectAccount(){
        int password =  accountmapper.selecttargetIdByUserName("dxc");
        System.out.println(password); 
    }

}
