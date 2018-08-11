package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IndentMapper {

    @Insert("insert into indent(user_id,seller_id,number,service_time,service) values(#{userId},#{sellerid},#{number},#{servicetime},#{service})")
    void createOrder(@Param("userId") int userId,@Param("sellerid") int sellerid,@Param("number") int number,@Param("service_time")long servicetime,@Param("service")String service);

    @Select("select order_id from indent where user_id = #{userId}")
    int selectOrderidByUserid(@Param("userId")int userId);

    @Update("update indent set order_status = #{orderStatus} where order_id = #{orderId}")
    void updateOrderStatus(@Param("orderId")int orderId,@Param("orderStatus") int orderStatus);


    @Select("select user_id from indent where order_id = #{orderId}")
    int selectUseridByOrderid(@Param("orderId")int orderId);


    @Update("update indent set refuse_reason = #{reason} where order_id = #{orderId}")
    void updateRefuseReasonByOrderid(@Param("reason")String reason,@Param("orderId")int orderId);


    @Select("select * from indent where order_id = #{orderId}")
    Order selectOrderByOrderid(@Param("orderId")int orderId);

    @Select("select order_status from indent where order_id = #{orderId}")
    int selectStatusByOrderid(@Param("orderId")int orderId);

}