package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Account;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper{
    @Insert("insert into account(username,password,seller,target_id) values (#{username },#{password},#{seller},#{targetId})")
    int addAccount(@Param("username")String username,@Param("password")String password,@Param("seller")boolean seller,@Param("targetId")int targetId);

    @Select("select password from account where username = #{username}")
    String selectPasswordByUserName( @Param("username")String username);

    @Select("select target_id from account where username = #{username}")
    int selecttargetIdByUserName(@Param("username")String username);
    
    @Select("select seller from account where username = #{username}")
    boolean IsSeller(@Param("username") String username);
    
    @Select("select * from account where username = #{username}")
    Account selectByName(@Param("username") String username);
}
