package com.zutsg.service;

import com.zutsg.dao.GardenGeneralMapper;
import com.zutsg.pojo.GardenGeneral;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
@Service
public class GardenGeneralServiceImpl implements GardenGeneralMapper {


    @Resource
    private GardenGeneralMapper gardenGeneralMapper;


    @Override
    public GardenGeneral selectByPrimaryKey(Integer id) {
        return gardenGeneralMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GardenGeneral record) {
        return gardenGeneralMapper.updateByPrimaryKeySelective(record);
    }

}
