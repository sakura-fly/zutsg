package com.zutsg.dao;

import com.zutsg.pojo.GardenGeneral;

public interface GardenGeneralMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GardenGeneral record);

    int insertSelective(GardenGeneral record);

    GardenGeneral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GardenGeneral record);

    int updateByPrimaryKey(GardenGeneral record);
}