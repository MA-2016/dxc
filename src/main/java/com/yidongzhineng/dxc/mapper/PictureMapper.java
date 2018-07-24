package com.yidongzhineng.dxc.mapper;

import com.yidongzhineng.dxc.pojo.Picture;
import com.yidongzhineng.dxc.pojo.PictureExample;
import com.yidongzhineng.dxc.pojo.PictureKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    int countByExample(PictureExample example);

    int deleteByExample(PictureExample example);

    int deleteByPrimaryKey(PictureKey key);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    Picture selectByPrimaryKey(PictureKey key);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}