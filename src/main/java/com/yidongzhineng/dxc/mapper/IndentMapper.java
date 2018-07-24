package com.yidongzhineng.dxc.mapper;

import com.yidongzhineng.dxc.pojo.Indent;
import com.yidongzhineng.dxc.pojo.IndentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndentMapper {
    int countByExample(IndentExample example);

    int deleteByExample(IndentExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Indent record);

    int insertSelective(Indent record);

    List<Indent> selectByExample(IndentExample example);

    Indent selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Indent record, @Param("example") IndentExample example);

    int updateByExample(@Param("record") Indent record, @Param("example") IndentExample example);

    int updateByPrimaryKeySelective(Indent record);

    int updateByPrimaryKey(Indent record);
}