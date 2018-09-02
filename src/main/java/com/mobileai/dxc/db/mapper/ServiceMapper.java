package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.service.driver.UpdateDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ServiceMapper {


    @Insert("INSERT INTO `service` (`seller_id`, `name`, `description`, `price`, `pre_price`) " +
            "VALUES(#{provision.sellerId},#{provision.name},#{provision.description},#{provision.price},#{provision.prePrice}) ")
    @Options(useGeneratedKeys = true, keyProperty = "provision.serviceId" ,keyColumn = "service_id")
    int addService(@Param("provision")Provision provision);

    @Delete("DELETE FROM `service` WHERE service_id = #{serviceId} ")
    int deleteById(@Param("serviceId") int serviceId);

    @Update("update service (#{provision}) where service_id = #{serviceId}")
    @Lang(UpdateDriver.class)
    int updateServiceById(Provision provision);

    @Select("SELECT * FROM `service` WHERE service_id =#{serviceId}")
    @Results(id="serviceResultMapper",value={
            @Result(id=true, property = "serviceId",column = "service_id"),
            @Result(property = "sellerId",column ="seller_id" ),
            @Result(property = "prePrice",column ="pre_price" )
    })
    Provision getServiceById(@Param("serviceId") int serviceId);

    @Select("SELECT * FROM `service` WHERE seller_id =#{sellerId}")
    @ResultMap("serviceResultMapper")
    List<Provision> selectServiceBySellerId(@Param("sellerId") int sellerId);


    @Select("select status from service where service_id = #{serviceId}")
    int selectStatusById(@Param("serviceId") int serviceId);

    @Select("SELECT order_num FROM `service` WHERE service_id =#{serviceId}")
    int selectOrderNumById(@Param("serviceId") int serviceId);
    @Select("select picture from service where service_id = #{serviceId}")
    String selectPictureById(@Param("serviceId") int serviceId);
}
