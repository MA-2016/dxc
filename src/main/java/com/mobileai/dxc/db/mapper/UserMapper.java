package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.User;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select email from User where user_id = #{userId}")
    String selectEmailById( @Param("userId")int userId);

    @Select("select * from User where user_id = #{userId}")
    User selectById(@Param("userId")int userId);

    
}