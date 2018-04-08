package com.zutsg.service;

import com.zutsg.dao.CommentMapper;
import com.zutsg.pojo.Comment;
import com.zutsg.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
@Service
public class CommentServiceImpl implements CommentMapper {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserServiceImpl userService;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Comment record) {
     return commentMapper.insertSelective(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Comment> selectByComment(Comment record) {
        List<Comment> commentList=commentMapper.selectByComment(record);
        if(commentList.size()>0&&commentList!=null){
            for(Comment comment:commentList){
                if(comment.getType()!=null&&comment.getUserId()!=null){
                  User user=userService.selectByPrimaryKey(comment.getUserId());
                      if(user!=null)
                          comment.setUser(user);
                    if(comment.getType()==2&&comment.getToUserId()!=null){
                        User userResult=userService.selectByPrimaryKey(comment.getToUserId());
                        if(userResult!=null)
                            comment.setUser(userResult);
                    }
                }
            }
        }
        return commentList;
    }

    @Override
    public List<Comment> selectByCommentPage(Comment record) {
        List<Comment> commentList=commentMapper.selectByComment(record);
        if(commentList.size()>0&&commentList!=null){
            for(Comment comment:commentList){
                if(comment.getType()!=null&&comment.getUserId()!=null){
                    User user=userService.selectByPrimaryKey(comment.getUserId());
                    if(user!=null)
                        comment.setUser(user);
                    if(comment.getType()==2&&comment.getToUserId()!=null){
                        User userResult=userService.selectByPrimaryKey(comment.getToUserId());
                        if(userResult!=null)
                            comment.setUser(userResult);
                    }
                }
            }
        }
        return commentList;
    }
}
