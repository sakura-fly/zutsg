package com.zutsg.dao;

import com.zutsg.pojo.GardenNews;
import org.springframework.stereotype.Repository;

public interface GardenNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GardenNews record);

    int insertSelective(GardenNews record);

    GardenNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GardenNews record);

    int updateByPrimaryKey(GardenNews record);
}