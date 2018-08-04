package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IndentMapper {

    @Insert("insert into indent(user_id) values(#{userId})")
    void createOrder(@Param("userId") int userId);

    @Select("select order_id from indent where user_id = #{userId}")
    int selectOrderidByUserid(@Param("userId")int userId);

    @Update("update indent set order_status = #{orderstatus} where order_id = #{orderId}")
    void updateOrderStatus(@Param("orderId")int orderId);
    
}