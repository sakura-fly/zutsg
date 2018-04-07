package com.zutsg.dao;

import com.zutsg.pojo.GardenNews;

import java.util.List;

public interface GardenNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(GardenNews record);

    GardenNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GardenNews record);

    List<GardenNews> selectByNews(GardenNews record);

    List<GardenNews> selectByNewsPage(GardenNews record);

}