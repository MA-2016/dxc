package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerMapper{
    @Insert("insert into seller(phone) values (#{phone}")
    @Options(useGeneratedKeys = true, keyProperty = "seller_id")
    int addSeller(@Param("phone")String phone);
}