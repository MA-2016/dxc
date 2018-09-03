package com.mobileai.dxc.db.mapper;

import com.mobileai.dxc.db.pojo.Account;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface AccountMapper{
    @Insert("insert into account(username,password,identify_mark,target_id,create_time,update_time) values (#{account.name},#{account.password},#{account.identifyMark},#{account.targetId},#{account.createTime},#{account.updateTime})")
    int addAccount(@Param("account")Account account);

    @Select("select password from account where username = #{username}")
    String selectPasswordByUserName( @Param("username")String username);

    @Select("select target_id from account where username = #{username}")
    int selecttargetIdByUserName(@Param("username")String username);
    
    @Select("select seller from account where username = #{username}")
    boolean IsSeller(@Param("username") String username);
    
    @Select("select * from account where username = #{username}")
    @Results(id="accountResultMapper",value={
            @Result(id=true, property = "accountId",column = "id"),
            @Result(property = "name",column ="username" ),
            @Result(property = "targetId",column ="target_id" ),
            @Result(property = "createTime",column ="create_time" ),
            @Result(property ="updateTime",column = "update_time"),
            @Result(property = "identifyMark",column ="identify_mark" )
    })
    Account selectByName(@Param("username") String username);
}
