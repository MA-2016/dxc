package com.yidongzhineng.dxc.db;

import com.mobileai.dxc.db.mapper.OrderMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderMapper {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testCreateOrder() {
        orderMapper.createOrder(1);
    }


}