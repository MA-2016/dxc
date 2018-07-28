package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper{
    @Insert("insert into account(username,password) values (#{username },#{password})")
    int addAccount(@Param("username")String username,@Param("password")String password);

    @Select("select password from account where username = #{username}")
    int selectPasswordByUsername( @Param("username")String username);

    @Select("select seller from account where id = #{accountid}")
    boolean selectsellerbyId(@Param("accountid") int accountid);
}
