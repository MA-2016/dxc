package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IndentMapper {

    @Insert("insert into indent(user_id) values(#{userId})")
    void createOrder(@Param("userId") int userId);


}