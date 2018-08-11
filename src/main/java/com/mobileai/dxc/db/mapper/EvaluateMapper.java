package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EvaluateMapper{
    @Insert("insert into evaluate(seller_id,user_id,order_id,star_level,content) values(#{sellerId},#{userId},#{orderId},#{starLevel},#{content})")
    void addEvaluate(@Param("sellerId")int sellerId,@Param("userId")int userId,@Param("orderId")int orderId,@Param("starLevel")int starLevel,@Param("content")String content);
    
    @Select("select orderId from evaluate where seller_id=#{sellerId} and user_id=#{userId}")
    int selectorderId(@Param("sellerId")int sellerId,@Param("userId")int userId);
}