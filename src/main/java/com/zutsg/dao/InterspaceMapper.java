package com.zutsg.dao;

import com.zutsg.pojo.Interspace;

import java.util.List;

public interface InterspaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Interspace record);

    int insertSelective(Interspace record);

    Interspace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Interspace record);

    int updateByPrimaryKey(Interspace record);

    List<Interspace> selectByIntersapce(Interspace record);

    List<Interspace> selectByIntersapcePage(Interspace record);
}