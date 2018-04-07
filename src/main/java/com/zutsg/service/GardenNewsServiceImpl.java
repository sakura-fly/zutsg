package com.zutsg.service;
import com.zutsg.dao.GardenNewsMapper;
import com.zutsg.pojo.GardenNews;
import com.zutsg.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
@Service
public class GardenNewsServiceImpl implements GardenNewsMapper {
    @Resource
    private GardenNewsMapper gardenNewsMapper;
    @Resource
    private UserServiceImpl userService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return gardenNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(GardenNews record) {
        return gardenNewsMapper.insertSelective(record);
    }

    @Override
    public GardenNews selectByPrimaryKey(Integer id) {
        return gardenNewsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GardenNews record) {
        return gardenNewsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<GardenNews> selectByNews(GardenNews record) {
        List<GardenNews> gardenNewsList= gardenNewsMapper.selectByNews(record);
        if(gardenNewsList.size()>0&&gardenNewsList!=null){
            for(GardenNews data:gardenNewsList){
                if(data.getUserId()!=null){
                    User user= userService.selectByPrimaryKey(data.getUserId());
                    if(user!=null){
                        data.setUser(user);
                    }
                }
            }
        }
        return gardenNewsList;
    }

    @Override
    public List<GardenNews> selectByNewsPage(GardenNews record) {
        List<GardenNews> gardenNewsList= gardenNewsMapper.selectByNewsPage(record);
        if(gardenNewsList.size()>0&&gardenNewsList!=null){
            for(GardenNews data:gardenNewsList){
                if(data.getUserId()!=null){
                    User user= userService.selectByPrimaryKey(data.getUserId());
                    if(user!=null){
                        data.setUser(user);
                    }
                }
            }
        }
        return gardenNewsList;
    }
}
