package com.zutsg.dao;

import com.zutsg.pojo.Comment;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Comment record);

     Comment selectByPrimaryKey(Integer id);

     int updateByPrimaryKeySelective(Comment record);

     int updateByPrimaryKey(Comment record);

     List<Comment> selectByComment(Comment record);

    List<Comment> selectByCommentPage(Comment record);
}