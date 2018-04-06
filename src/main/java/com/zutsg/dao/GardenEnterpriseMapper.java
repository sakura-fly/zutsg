package com.zutsg.dao;

import com.zutsg.pojo.GardenEnterprise;


public interface GardenEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GardenEnterprise record);

    int insertSelective(GardenEnterprise record);

    GardenEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GardenEnterprise record);

    int updateByPrimaryKey(GardenEnterprise record);
}