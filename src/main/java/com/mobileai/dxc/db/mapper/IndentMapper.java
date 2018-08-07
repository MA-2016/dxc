package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Order;
import org.apache.ibatis.annotations.*;
import org.aspectj.weaver.ast.Or;

@Mapper
public interface IndentMapper {

    @Insert("insert into indent(user_id,seller_id,number,service_time,service) values(#{userId},#{sellerid},#{number},#{servicetime},#{service})")
    void createOrder(@Param("userId") int userId,@Param("sellerid") int sellerid,@Param("number") int number,@Param("service_time")long servicetime,@Param("service")String service);

    @Select("select order_id from indent where user_id = #{userId}")
    int selectOrderidByUserid(@Param("userId")int userId);

    @Update("update indent set order_status = #{orderStatus} where order_id = #{orderId}")
    void updateOrderStatus(@Param("orderStatus") int orderStatus,@Param("orderId")int orderId);


    @Select("select user_id from indent where order_id = #{orderId}")
    int selectUseridByOrderid(@Param("orderId")int orderId);


    @Update("update indent set refuse_reason = #{reason} where order_id = #{orderId}")
    void updateRefuseReasonByOrderid(@Param("reason")String reason,@Param("orderId")int orderId);


    @Select("select * from indent where order_id = #{orderId}")
    @Results(id="orderalia",value =
            {
            @Result(column="seller_id", property = "sellerId"),
            @Result(column="user_id", property = "userId"),
            @Result(column="order_id", property = "orderId"),
            @Result(column="service",property = "service"),
            @Result(column="total_price",property = "totalPrice"),
            @Result(column="number",property = "number"),
            @Result(column="order_time",property ="orderTime" ),
            @Result(column="service_time",property ="serviceTime" ),
            @Result(column="order_status",property = "orderStatus"),
            @Result(column = "refuse_reason",property = "reason")
            }
    )
    Order selectOrderByOrderid(@Param("orderId")int orderId);

}