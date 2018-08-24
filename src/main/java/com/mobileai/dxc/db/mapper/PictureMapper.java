package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Picture;
import com.mobileai.dxc.db.pojo.Seller;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PutMapping;
import sun.security.jca.ServiceId;

import java.util.List;


@Mapper
public interface PictureMapper {
//    @Insert("INSERT INTO `service` (`seller_id`, `name`, `description`, `price`, `pre_price`) " +
//            "VALUES(#{provision.sellerId},#{provision.name},#{provision.description},#{provision.price},#{provision.prePrice}) ")
//    @Options(useGeneratedKeys = true, keyProperty = "provision.serviceId" ,keyColumn = "service_id")
//    int addService(@Param("provision")Provision provision);
    @Insert("INSERT INTO `picture` (`service_id`, `pic_path`) " +
           "VALUES(#{picture.serviceId},#{picture.picturePath}) ")
    @Options(useGeneratedKeys = true, keyProperty = "picture.pictureId" ,keyColumn = "pic_id")
    int addPicture(@Param("picture") Picture picture);
    @Select("SELECT * FROM `picture` WHERE pic_id =#{pictureId}")
    @Results(id="pictureResultMapper",value=
            {
            @Result(id=true,property = "pictureId",column = "pic_id"),
            @Result(property = "serviceId",column = "service_id"),
            @Result(property = "picturePath",column = "pic_path"),
    })
     Picture selectById(@Param("pictureId")int pictureId);

    @Delete("DELETE FROM picture WHERE pic_id =#{pictureId}")
    int deletePictureByid(@Param("pictureId")int pictureId);
//    @Select("select * from seller where location like '%${location}%' and topic like '%${topic}%'")
//    List<Seller> selectFuzzy(@Param("location")String location, @Param ("topic")String topic);


    @Select("select * from picture where service_id = #{ServiceId}")
    @ResultMap("pictureResultMapper")
    List<Picture> selectPictureByServiceId(@Param("ServiceId")int  ServiceId);

}
