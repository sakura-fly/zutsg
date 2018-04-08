package com.zutsg.controller;

import com.zutsg.pojo.Comment;
import com.zutsg.pojo.Interspace;
import com.zutsg.service.CommentServiceImpl;
import com.zutsg.service.InterspaceServiceImpl;
import com.zutsg.unti.PageBean;
import com.zutsg.unti.ReturnDatas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentServiceImpl commentService;

    @RequestMapping("/listPage")
    public @ResponseBody
    ReturnDatas listPage(Comment comment, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            if(pageBean!=null){
                List<Comment> commentList=commentService.selectByComment(comment);
                pageBean.setCount(commentList.size());
                PageBean pageBeanResult=PageBean.pageBean(pageBean);
                comment.setPageBean(pageBeanResult);
                returnDatas.setPageBean(pageBeanResult);
            }
            List<Comment> commentList=commentService.selectByCommentPage(comment);
            returnDatas.setData(commentList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/list")
    public @ResponseBody
    ReturnDatas list(Comment comment, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        try {
            List<Comment> commentList=commentService.selectByCommentPage(comment);
            returnDatas.setData(commentList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas add(Comment comment, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(comment.getType()==null||comment.getUserId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        if(comment.getType()==2){
            if(comment.getToUserId()==null)
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            comment.setCreateTime(new Date());
            commentService.insertSelective(comment);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/delete")
    public @ResponseBody
    ReturnDatas delete(Comment comment, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(comment.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            commentService.deleteByPrimaryKey(comment.getId());
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }


}
