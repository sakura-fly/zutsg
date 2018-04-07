package com.zutsg.dao;

import com.zutsg.pojo.GardenGeneral;

public interface GardenGeneralMapper {

    GardenGeneral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GardenGeneral record);


}