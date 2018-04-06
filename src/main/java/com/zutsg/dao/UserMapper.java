package com.zutsg.dao;

import com.zutsg.pojo.User;

import java.util.List;

public interface UserMapper {
    /*删除用户接口*/
    int deleteByPrimaryKey(Integer id);
    /* 新增接口*/
    int insertSelective(User record);
     /*用户详情接口*/
    User selectByPrimaryKey(Integer id);
    /*修改用户信息接口*/
    int updateByPrimaryKeySelective(User record);
    /*不分页查询*/
    List<User> selectByUser(User user);
   /*分页查询*/
    List<User> selectByUserPage(User user);
  /*根据手机号查找*/
    List<User> selectByPhone(String phone);

}