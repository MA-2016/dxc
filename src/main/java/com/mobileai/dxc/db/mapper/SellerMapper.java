package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface SellerMapper{
    @Insert("insert into seller(phone) values (#{phone}")
    @Options(useGeneratedKeys = true, keyProperty = "seller_id")
   // @ResultMap("selleralia")
    int addSeller(@Param("phone")String phone);


//    @Results(id="selleralia",value=
//            {
//                    @Result(column="seller_id", property = "sellerId"),
//                    @Result(column="service_type", property = "servicetype"),
//                    @Result(column="pic_path", property = "picpath"),
//                    @Result(column="phone", property = "phone"),
//              }
//    )
    @Select("select phone from seller where seller_id= #{sellerId}")
    String selectPhoneById( @Param("sellerId")int sellerId);
}