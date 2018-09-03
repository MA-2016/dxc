package com.mobileai.dxc.db;

import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.pojo.Picture;
import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.service.ProvisionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProvisionServiceTest {


    @Autowired
    SellerMapper sellerMapper;


    @Autowired
    private ProvisionService provisionService;

    @Test
    public void tryTest() {

        System.out.println("serviceid +" + provisionService.addService(1,"sell lily", "卖百合花", 30f, 30f));
    }

    @Test
    public void test2() {
        System.out.println("删除服务");
        provisionService.deleteService(1, 15);
    }

    @Test
    public void test1() {
        String s = sellerMapper.selectServiceById(1);
        System.out.println(s);
    }

    @Test
    public void test3() {
        Provision p = new Provision("rose", "玫瑰花", 30f, 30f);
      //  provisionService.updateService(17, p);
    }

    @Test
    public void test4(){
        provisionService.deleteServicePicture(17,1);
    }
    @Test
    public void test5(){
       List<Picture> picetures= provisionService.selectAllServicePicture(2);
       for(Picture p:picetures)
       {
           System.out.println("...................................");
           System.out.println("p.getPictureId "+p.getPictureId());
           System.out.println("p.getServiceId"+p.getServiceId());
           System.out.println("p.getPicturePath"+p.getPicturePath());
           System.out.println("...................................");
       }

    }

    @Test
    public void test6(){
        List<Provision> provisions= provisionService.showAllService(1);
        for(Provision provision:provisions)
        {
            System.out.println("...................................");
            System.out.println("provision.getServiceId"+provision.getServiceId());
            System.out.println("provision.getSellerId"+provision.getSellerId());
            System.out.println("provision.getName"+provision.getName());
            System.out.println("...................................");
        }

    }
    @Test
    public void testdeleteService(){
        provisionService.deleteService(1,17);
    }



}
