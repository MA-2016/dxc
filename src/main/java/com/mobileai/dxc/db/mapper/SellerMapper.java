package com.mobileai.dxc.db.mapper;

import java.util.List;

import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.driver.UpdateDriver;

import org.apache.ibatis.annotations.*;

@Mapper
public interface SellerMapper {
<<<<<<< HEAD
    @Insert("insert into seller(phone,create_time,update_time) values (#{seller.phone},#{seller.createTime},#{seller.updateTime})")
    int addSeller(@Param("seller") Seller seller);
=======
    @Insert("insert into seller(phone) values (#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "seller_id")
    //    @Options(useGeneratedKeys = true, keyProperty = "picture.pictureId" ,keyColumn = "pic_id")
    int addSeller(@Param("phone") String phone);
>>>>>>> aa75e273406ff589e635bf92d29a8deed1d78db0

    @Select("select phone from seller where seller_id= #{sellerId}")
    String selectPhoneById(@Param("sellerId") int sellerId);

    @Select("select * from seller where seller_id=#{sellerId}")
    Seller selectById(@Param("sellerId") int sellerId);

    @Select("select * from seller where location like '%${location}%' and topic like '%${topic}%'")
    List<Seller> selectFuzzy(@Param("location")String location,@Param ("topic")String topic);

    @Update("update seller (#{seller}) where seller_id = #{sellerId}")
    @Lang(UpdateDriver.class)
    void updateSellerById(Seller seller);
    @Select("select service from seller where seller_id= #{sellerId}")
    String selectServiceById(@Param("sellerId")int  sellerId);
}