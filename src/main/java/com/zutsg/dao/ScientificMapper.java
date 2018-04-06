package com.zutsg.dao;

import com.zutsg.pojo.Scientific;

public interface ScientificMapper {
    int deleteByPrimaryKey(String id);

    int insert(Scientific record);

    int insertSelective(Scientific record);

    Scientific selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Scientific record);

    int updateByPrimaryKey(Scientific record);
}