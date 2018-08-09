package com.mobileai.dxc.db.mapper;


import org.apache.ibatis.annotations.*;
import com.mobileai.dxc.db.pojo.Service ;

@Mapper
public interface ServiceMapper {

    @Insert("INSERT INTO service(service_id, seller_id, description, price)" +
            " VALUES ((#{serviceId}), (#{sellerId}), (#{description}), (#{price}))")
    void addService(@Param("serviceId") int serviceId, @Param("sellerId") int sellerId,
                    @Param("description") String description, @Param("price") double price);

    @Update("update service set description = #{description} " +
            "where service_id = #{serviceId} and seller_id = #{sellerId}")
    void updateDescriptionById(@Param("serviceId") int serviceId, @Param("sellerId") int sellerId,
                               @Param("description") String description);

    @Update("update service set price = #{price} " +
            "where service_id = #{serviceId} and seller_id = #{sellerId}")
    void updatePriceById(@Param("serviceId") int serviceId, @Param("sellerId") int sellerId,
                         @Param("price") double price);

    @Delete("DELETE FROM service WHERE `service_id`= #{serviceId}) AND (seller_id= #{sellerId})")
    void deleteServiceById(@Param("serviceId") int serviceId, @Param("sellerId") int sellerId);

    @Update("update service set picture = #{pictures} " +
            "where service_id = #{serviceId} and seller_id = #{sellerId}")
    void updatePictureById(@Param("serviceId") int serviceId, @Param("sellerId") int sellerId,
                         @Param("pictures") String pictures);

    @Select("select picture from service where " +
            "service_id = #{serviceId} and seller_id = #{sellerId}")
    String selectPictureById( @Param("serviceId") int serviceId, @Param("sellerId") int sellerId);
}