package com.mobileai.dxc;

import com.mobileai.dxc.db.mapper.AccountMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.pojo.Seller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerMapperTest{
    @Autowired
    public SellerMapper sellerMapper;

    @Autowired
    public AccountMapper accountMapper;

    @Test
    public void testsellerSelect(){
        String phone = sellerMapper.selectPhoneById(2);

        System.out.println(phone);
    }

    @Test
    public void testsellerUpdate(){
        Seller seller = new Seller();
        seller.setLocation("中国四川");
        seller.setSellerId(2);

        sellerMapper.updateSellerById(seller);
    }
}