package com.zutsg.service;

import com.zutsg.dao.UserMapper;
import com.zutsg.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/5 0005.
 */
@Service
public class UserSeriveImpl implements UserMapper{

@Resource
private UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public List<User> selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public List<User> selectByUserPage(User user) {
        return userMapper.selectByUserPage(user);
    }

    @Override
    public List<User> selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

}
