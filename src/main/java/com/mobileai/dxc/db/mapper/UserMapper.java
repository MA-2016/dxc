package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.User;
import com.mobileai.dxc.service.driver.UpdateDriver;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user(phone) values (#{phone}")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    int addUser(@Param("phone")String phone);

    @Select("select phone from user where user_id = #{userId}")
    String selectPhoneById( @Param("userId")int userId);

    @Select("select * from user where user_id = #{userId}")
    User selectById(@Param("userId")int userId);

    @Update("update user (#{seller}) where user_id = #{userId}")
    @Lang(UpdateDriver.class)
    void updateSellerById(User user);
}