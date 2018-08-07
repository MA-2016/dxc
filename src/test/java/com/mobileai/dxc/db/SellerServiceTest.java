package com.mobileai.dxc.db;

import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.SellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceTest {
    @Autowired
    IndentMapper indentMapper;
    @Autowired
    SellerService sellerService;

    @Autowired
    SellerMapper sellerMapper;
    @Test
    public  void testJunit()
    {
//
        Order order =indentMapper.selectOrderByOrderid(1);
        System.out.println("in testJunit SellerId"+order.getSellerId());
        System.out.println("in testJunit UserId"+order.getUserId());
        System.out.println("in testJunit  Number"+order.getNumber());
       //   System.out.println("userID"+userid);
//        System.out.println(order);
        //sellerService.notifyNewOrder(order);
        sellerService.acceptOrder(order.getOrderId());
        sellerService.refuseOrder(order.getOrderId(),"最近大雨，道路受损");
     }
}
