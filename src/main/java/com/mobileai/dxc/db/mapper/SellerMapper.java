package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.imple.UpdateDriverImple;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SellerMapper{
    @Insert("insert into seller(phone) values #{phone}")
    @Options(useGeneratedKeys = true, keyProperty = "seller_id")
    int addSeller(@Param("phone")String phone);

    @Select("select * from seller where seller_id=#{sellerId}")
    Seller selectById(@Param("sellerId")int sellerId);

    @Select("select phone from seller where seller_id=#{sellerId}")
    String selectPhoneById(@Param("sellerId")int sellerId);

    @Update("update seller (#{seller}) where seller_id = #{sellerId}")
    @Lang(UpdateDriverImple.class)
    void updateSellerById(Seller seller);
}