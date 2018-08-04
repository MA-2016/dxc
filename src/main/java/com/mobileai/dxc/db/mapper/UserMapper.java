package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.User;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user(email) values (#{email}")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    int addAccount(@Param("email")String email);

    @Select("select user_id from user where email = #{email}")
    int selectIdByEmail(@Param("email")String email);

    @Select("select email from user where user_id = #{userId}")
    String selectEmailById( @Param("userId")int userId);

    @Select("select * from user where user_id = #{userId}")
    User selectById(@Param("userId")int userId);

}