package com.mobileai.dxc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper{
    @Insert("insert into account(username,password,seller,target_id) values (#{username },#{password},#{seller},#{targetid})")
    int addAccount(@Param("username")String username,@Param("password")String password,@Param("seller")boolean seller,@Param("targetid")int targetid);

    @Select("select password from account where username = #{username}")
    String selectPasswordByUserName( @Param("username")String username);

    @Select("select targetid from account where username = #{username}")
    int selecttargetIdByUserName(@Param("username")String username);
    
    @Select("select seller from account where username = #{username}")
    boolean IsSeller(@Param("username") String username);
    
}
