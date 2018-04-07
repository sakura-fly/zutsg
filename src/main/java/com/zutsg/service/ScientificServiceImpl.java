package com.zutsg.service;

import com.zutsg.dao.ScientificMapper;
import com.zutsg.pojo.Scientific;
import com.zutsg.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/6 0006.
 */
@Service
public class ScientificServiceImpl implements ScientificMapper {
    @Resource
    private ScientificMapper scientificMapper;
    @Resource
    private UserServiceImpl userService;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scientificMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insertSelective(Scientific record) {
        return scientificMapper.insertSelective(record);
    }

    @Override
    public Scientific selectByPrimaryKey(Integer id) {
     Scientific scientific= scientificMapper.selectByPrimaryKey(id);
        if(scientific.getUserId()!=null) {
            User user = userService.selectByPrimaryKey(scientific.getUserId());
            if (user != null) {
                scientific.setUser(user);
            }
        }
        return scientific;
    }

    @Override
    public int updateByPrimaryKeySelective(Scientific record) {
        return scientificMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Scientific> selectByScientfic(Scientific record) {
        List<Scientific> scientificList= scientificMapper.selectByScientfic(record);
        if(scientificList.size()>0&&scientificList!=null){
            for(Scientific scientific:scientificList){
                if(scientific.getUserId()!=null){
                    User user= userService.selectByPrimaryKey(scientific.getUserId());
                    if(user!=null){
                        scientific.setUser(user);
                    }
                }
            }
        }
        return scientificList;
    }

    @Override
    public List<Scientific> selectByScientficPage(Scientific record) {
      List<Scientific> scientificList= scientificMapper.selectByScientficPage(record);
      if(scientificList.size()>0&&scientificList!=null){
      for(Scientific scientific:scientificList){
         if(scientific.getUserId()!=null){
           User user= userService.selectByPrimaryKey(scientific.getUserId());
           if(user!=null){
               scientific.setUser(user);
           }
         }
      }
      }
        return scientificList;
    }

}
