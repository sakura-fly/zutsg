package com.zutsg.dao;

import com.zutsg.pojo.Scientific;

import java.util.List;

public interface ScientificMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Scientific record);

    Scientific selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scientific record);

   List<Scientific> selectByScientfic(Scientific record);

    List<Scientific> selectByScientficPage(Scientific record);
}