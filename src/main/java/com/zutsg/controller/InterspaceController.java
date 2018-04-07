package com.zutsg.controller;

import com.zutsg.pojo.Interspace;
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
@RequestMapping("/intersapce")
public class InterspaceController  {
    @Resource
    private InterspaceServiceImpl interspaceService;

    @RequestMapping("/listPage")
    public @ResponseBody
    ReturnDatas listPage(Interspace interspace, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            if(pageBean!=null){
                List<Interspace> interspaceList=interspaceService.selectByIntersapce(interspace);
                pageBean.setCount(interspaceList.size());
                PageBean pageBeanResult=PageBean.pageBean(pageBean);
                interspace.setPageBean(pageBeanResult);
                returnDatas.setPageBean(pageBeanResult);
            }
            List<Interspace> interspaceList=interspaceService.selectByIntersapcePage(interspace);
            returnDatas.setData(interspaceList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/list")
    public @ResponseBody
    ReturnDatas list(Interspace interspace, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        try {
            List<Interspace> interspaceList=interspaceService.selectByIntersapce(interspace);
            returnDatas.setData(interspaceList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

    @RequestMapping("/look")
    public @ResponseBody
    ReturnDatas look(Interspace interspace, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        try {
            if(interspace.getId()==null){
                return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
            }
          Interspace interspaces=interspaceService.selectByPrimaryKey(interspace.getId());
            returnDatas.setData(interspaces);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas update(Interspace interspace, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        try {
            if(interspace.getId()==null||interspace.getUserId()==null){
                return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
            }
           interspaceService.updateByPrimaryKeySelective(interspace);

        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas add(Interspace interspace, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(interspace.getUserId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            interspace.setCreateTime(new Date());
            interspaceService.insertSelective(interspace);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/delete")
    public @ResponseBody
    ReturnDatas delete(Interspace interspace, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(interspace.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            interspaceService.deleteByPrimaryKey(interspace.getId());
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/like")
    public @ResponseBody
    ReturnDatas like(Interspace interspace,HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(interspace.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
           Interspace interspaceResult=interspaceService.selectByPrimaryKey(interspace.getId());
           if(interspaceResult!=null){
               interspace.setTopNum(interspaceResult.getTopNum()==null?1:interspaceResult.getTopNum()+1);
               interspaceService.updateByPrimaryKey(interspace);
           }
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

}
