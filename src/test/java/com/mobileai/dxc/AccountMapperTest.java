package com.mobileai.dxc;

import com.mobileai.dxc.db.mapper.AccountMapper;

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
    public void addAccount () {
        accountmapper.addAccount("dcxs", "fhdask",false,29410);
    }

}
