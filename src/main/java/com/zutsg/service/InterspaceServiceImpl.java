package com.zutsg.service;

import com.zutsg.dao.InterspaceMapper;
import com.zutsg.pojo.Interspace;
import com.zutsg.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
@Service
public class InterspaceServiceImpl implements InterspaceMapper{
    @Resource
    private InterspaceMapper interspaceMapper;
    @Resource
    private UserServiceImpl userService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return interspaceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Interspace record) {
        return 0;
    }

    @Override
    public int insertSelective(Interspace record) {
        return interspaceMapper.insertSelective(record);
    }

    @Override
    public Interspace selectByPrimaryKey(Integer id) {
        Interspace interspace=interspaceMapper.selectByPrimaryKey(id);
        if(interspace.getUserId()!=null){
           User user= userService.selectByPrimaryKey(interspace.getUserId());
            if(user!=null){
                interspace.setUser(user);
            }
        }
        return interspace;
    }

    @Override
    public int updateByPrimaryKeySelective(Interspace record) {
        return interspaceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Interspace record) {
        return interspaceMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Interspace> selectByIntersapce(Interspace interspace) {
        List<Interspace> interspaceList= interspaceMapper.selectByIntersapce(interspace);
        if(interspaceList.size()>0&&interspaceList!=null){
            for(Interspace data:interspaceList){
                if(data.getUserId()!=null){
                    User user= userService.selectByPrimaryKey(data.getUserId());
                    if(user!=null){
                        data.setUser(user);
                    }
                }
            }
        }
        return interspaceList;
    }

    @Override
    public List<Interspace> selectByIntersapcePage(Interspace interspace) {
        List<Interspace> interspaceList= interspaceMapper.selectByIntersapcePage(interspace);
        if(interspaceList.size()>0&&interspaceList!=null){
            for(Interspace data:interspaceList){
                if(data.getUserId()!=null){
                    User user= userService.selectByPrimaryKey(data.getUserId());
                    if(user!=null){
                        data.setUser(user);
                    }
                }
            }
        }
        return interspaceList;
    }
}
