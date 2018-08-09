package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.driver.UpdateDriver;

import org.apache.ibatis.annotations.*;

@Mapper
public interface SellerMapper{
    @Insert("insert into seller(phone) values (#{phone}")
    @Options(useGeneratedKeys = true, keyProperty = "seller_id")
    int addSeller(@Param("phone")String phone);

<<<<<<< HEAD

    @Select("select phone from seller where seller_id= #{sellerId}")
    String selectPhoneById( @Param("sellerId")int sellerId);

    @Update("update seller set service = #{service} where seller_id = #{sellerId}")
    void  updateServiceById( @Param("sellerId")int sellerId, @Param("service")String service);


    @Select("select service from seller where seller_id= #{sellerId}")
    String selectServiceById( @Param("sellerId")int sellerId );

   // updateIndexPicture(int sellerId, String picpath)
   @Update("update seller set pic_path = #{picPath} where seller_id = #{sellerId}")
    void updatePictureById( @Param("sellerId")int sellerId ,@Param("picPath")String picPath );


=======
    @Select("select phone from seller where seller_id= #{sellerId}")
    String selectPhoneById( @Param("sellerId")int sellerId);

    @Select("select * from seller where seller_id=#{sellerId}")
    Seller selectById(@Param("sellerId")int sellerId);

    @Update("update seller (#{seller}) where seller_id = #{sellerId}")
    @Lang(UpdateDriver.class)
    void updateSellerById(Seller seller);
>>>>>>> f6854896598756a754edfa9e38bc34812d97afa7
}